#!/usr/bin/env python3
# EU Visa Sponsorship & Relocation Job Search Bot
# Updated to default search for EU jobs with keywords related to visa sponsorship and relocation

# Main changes:
# - Default query: Java developer with visa sponsorship/relocation synonyms
# - EU countries list for location loop
# - Search runs for each EU country and combines results

import asyncio
import os
import time
from datetime import datetime, date
from typing import List, Dict, Any

from serpapi import GoogleSearch
from telegram import Update
from telegram.constants import ParseMode
from telegram.ext import ApplicationBuilder, CommandHandler, ContextTypes

from utils import get_file_logger, parse_date, GOOGLE_SEARCH, API_GOOGLE_JOBS, DEFAULT_QUERY, EU_COUNTRIES, SOURCES, \
    FILTER_KEYWORD, SPONSORSHIP_KEYWORDS, EU_COUNTRIES_ENGLISH_LANGUAGE

logger = get_file_logger("jobBot", "logs/app.log")

fetched_data = {
    GOOGLE_SEARCH: [],
    API_GOOGLE_JOBS: []
}
start_date = ""


async def search_with_serpapi(query: str, location: str, site: str, num: int = 15) -> List[Dict[str, Any]]:
    params = {
        "engine": "google",
        "q": f"site:{site} {query} \"{location}\"",
        "num": num,
        "tbs": "qdr:m",  # Getting data for pas month qdr:d For past 24 hrs
        "api_key": os.environ.get("SERPAPI_KEY"),
    }
    __search = GoogleSearch(params)
    data = await asyncio.to_thread(__search.get_dict)
    results = []
    for item in (data.get("organic_results") or []):
        date_str = item.get("date") or item.get("published_time") or ""
        date_obj = parse_date(date_str)
        results.append({
            "title": item.get("title"),
            "link": item.get("link"),
            "snippet": item.get("snippet"),
            "source": site,
            "location": location,
            "date": date_obj
        })

    # Custom sort: None first, then oldest → latest last
    results.sort(key=lambda x: (x['date'] is not None, x['date'] or datetime.min))
    logger.info(f"Total result : {len(results)} for: {location}")
    return results


async def search_with_google_job_api(location: str, num: int = 15) -> List[Dict[str, Any]]:
    all_jobs = []
    for kw in SPONSORSHIP_KEYWORDS:
        params = {
            "engine": "google_jobs",
            "q": f"Java developer {kw}",
            "num": num,
            "location": location,
            "tbs": "qdr:m",  # Getting data for pas month qdr:d For past 24 hrs
            "api_key": os.environ.get("SERPAPI_KEY"),
        }
        __search = GoogleSearch(params)
        data = await asyncio.to_thread(__search.get_dict)
        if data.get('error'):
            logger.warning(f"{data.get('error')} or location: {location}")
        jobs = data.get("jobs_results", [])
        logger.info(f"Getting jobs count: {len(jobs)} for keyword: {params['q']} for country: {location}")
        all_jobs.extend(jobs)

    results = []

    for item in all_jobs:
        posted = item.get('detected_extensions', {}).get('posted_at', 'N/A')
        logger.info(f"{item['title']} - {item['company_name']} - {item['location']} - Posted: {posted}")
        date_str = item.get('detected_extensions', {}).get('posted_at', "")
        date_obj = parse_date(date_str)
        results.append({
            "title": item.get("title"),
            "link": item.get("apply_options")[0]["link"] if item.get('apply_options') else None,
            "snippet": (item.get("description")[:200] + "…") if item.get("description") and len(
                item.get("description")) > 200 else item.get("description"),
            "source": item.get("via"),
            "location": item.get("location"),
            "date": date_obj
        })

    # Custom sort: None first, then oldest → latest last
    results.sort(key=lambda x: (x['date'] is not None, x['date'] or datetime.min))

    logger.info(f"Total result is: {len(results)} for country:{location}")
    return results


async def eu_job_search(location=GOOGLE_SEARCH) -> List[Dict[str, Any]]:
    global fetched_data
    all_results = []
    for country in EU_COUNTRIES_ENGLISH_LANGUAGE:
        if location == GOOGLE_SEARCH:
            await fetch_using_google(all_results, country, location)
        else:
            results = await search_with_google_job_api(country)
            all_results.extend(results)
            fetched_data[location].extend(results)
    # Deduplicate
    seen = set()
    final = []
    for r in all_results:
        if r["link"] not in seen:
            seen.add(r["link"])
            final.append(r)
    return final


async def fetch_using_google(all_results, country, location):
    for site in SOURCES.values():
        try:
            results = await search_with_serpapi(DEFAULT_QUERY, country, site)
            all_results.extend(results)
            global fetched_data
            fetched_data[location].extend(results)
        except Exception as e:
            logger.error(f"Search failed for {country} on {site}: {e}", e)


async def start(update: Update, context: ContextTypes.DEFAULT_TYPE):
    global start_date, fetched_data
    user = update.effective_user
    user_name = f"{user.first_name} {user.last_name}"
    logger.info(f"Starting job for the user: {user_name} and message: {update.effective_message.text}")
    await update.message.reply_text(
        f"Hi {user_name} 🔍 Searching EU jobs with visa sponsorship/relocation keywords..."
    )

    today_str = date.today().strftime("%d %B %Y")
    data = fetched_data[GOOGLE_SEARCH]
    logger.info(
        f"Getting request to get jobs for data: {today_str}, we have data already for: {start_date} "
        f"and results: {fetched_data}")
    if today_str != start_date or len(data) == 0:
        fetched_data[GOOGLE_SEARCH] = []
        results = await eu_job_search()
        start_date = today_str
        if not results:
            await update.message.reply_text("No results found.")
            return

        logger.info(f"Sending jobs to user: {len(results)}")
        await send_job_message(results, update)
    else:
        await send_job_message(data, update)


async def search(update: Update, context: ContextTypes.DEFAULT_TYPE):
    global start_date, fetched_data
    user = update.effective_user
    user_name = f"{user.first_name} {user.last_name}"
    logger.info(f"Starting job for the user: {user_name} and message: {update.effective_message.text}")
    await update.message.reply_text(
        f"Hi {user_name} 🔍 Searching EU jobs with visa sponsorship/relocation keywords..."
    )

    data = fetched_data[API_GOOGLE_JOBS]
    today_str = date.today().strftime("%d %B %Y")
    logger.info(
        f"Getting request to get jobs for data: {today_str}, we have data already for: {start_date} "
        f"and results: {fetched_data}")
    if today_str != start_date or len(data) == 0:
        fetched_data[API_GOOGLE_JOBS] = []
        results = await eu_job_search(API_GOOGLE_JOBS)
        start_date = today_str
        if not results:
            await update.message.reply_text("No results found.")
            return

        logger.info(f"Sending jobs to user: {len(results)}")
        await send_job_message(results, update)
    else:
        await send_job_message(data, update)


async def send_job_message(results, update: Update):
    filtered_results = [
        item for item in results
        if not any(keyword.lower() in item["snippet"].lower() for keyword in FILTER_KEYWORD)
    ]
    for r in filtered_results:  # limit to top 15 results for brevity
        formatted_date = r['date'].strftime("%d %B %Y") if r['date'] else ""
        description = (r['snippet'][:200] + "…") if r['snippet'] and len(r['snippet']) > 200 else r['snippet']

        msg = f"<b>{r['title']}</b>\n{description}\n<i>{r['location']} - {formatted_date}</i>\n{r['link']}"
        await update.message.reply_text(msg, parse_mode=ParseMode.HTML, disable_web_page_preview=False)
        time.sleep(1)  # Sleep for one second


async def check(update: Update, context: ContextTypes.DEFAULT_TYPE):
    logger.info("I am in update")
    await update.message.reply_text(
        "dat ja bhai search kar reya hu"
    )


async def error_handler(update: object, context: ContextTypes.DEFAULT_TYPE):
    print(f"⚠️ Exception: {context.error}")
    logger.error(f"Something wrong happen {context.error}", context)
    # Optionally, inform the user
    if update and isinstance(update, Update):
        try:
            await update.message.reply_text("Oops! Something went wrong.")
        except Exception as e:
            logger.error("Something wrong happended {e}", e)


def main():
    token = os.environ.get("TELEGRAM_BOT_TOKEN")
    if not token:
        raise RuntimeError("TELEGRAM_BOT_TOKEN not set")
    app = ApplicationBuilder().token(token).build()
    app.add_handler(CommandHandler("start", start))
    app.add_handler(CommandHandler("check", check))
    app.add_handler(CommandHandler("search", search))
    app.add_error_handler(error_handler)
    logger.info("EU Visa Sponsorship Bot running...")
    app.run_polling()


if __name__ == "__main__":
    main()
