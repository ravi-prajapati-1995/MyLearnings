#!/usr/bin/env python3
# EU Visa Sponsorship & Relocation Job Search Bot
# Updated to default search for EU jobs with keywords related to visa sponsorship and relocation

# Main changes:
# - Default query: Java developer with visa sponsorship/relocation synonyms
# - EU countries list for location loop
# - Search runs for each EU country and combines results

import asyncio
import os
from datetime import datetime
from typing import List, Dict, Any

from serpapi import GoogleSearch
from telegram import Update
from telegram.constants import ParseMode
from telegram.ext import ApplicationBuilder, ContextTypes

from utils import get_file_logger

logger = get_file_logger("jobBot", "logs/app.log")

EU_COUNTRIES = [
    "Germany", "Netherlands", "Sweden", "Norway", "Finland", "Denmark", "Ireland", "Switzerland", "Spain", "Austria",
    "Portugal", "Estonia"
]
DEFAULT_QUERY = (
    'Java developer ("visa sponsorship" OR "work permit" OR relocation OR "mobility package")'
)
FILTER_KEYWORD = ["unable to support", "cannot offer", "Not Available", "not offer", "not currently available",
                  "do not provide", "without the need for visa", "not able to provide", "Unfortunately", "can't offer",
                  "Open for European"]
fetched_data = []
start_date = ""


async def search_with_google_job_api(query: str, location: str, num: int = 15) -> List[Dict[str, Any]]:
    params = {
        "engine": "google_jobs",
        "q": f"{DEFAULT_QUERY}",
        "num": num,
        "location": f"{location}",
        "tbs": "qdr:m",  # Getting data for pas month qdr:d For past 24 hrs
        "api_key": os.environ.get("SERPAPI_KEY"),
    }
    search = GoogleSearch(params)
    data = await asyncio.to_thread(search.get_dict)
    results = []

    for item in data.get("jobs_results", []):
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


async def eu_job_search() -> List[Dict[str, Any]]:
    all_results = []
    for country in EU_COUNTRIES:
        try:
            results = await search_with_google_job_api(DEFAULT_QUERY, country)
            all_results.extend(results)
            global fetched_data
            fetched_data.extend(results)
        except Exception as e:
            logger.error(f"Search failed for {country}: {e}", e)
    # Deduplicate
    seen = set()
    final = []
    for r in all_results:
        if r["link"] not in seen:
            seen.add(r["link"])
            final.append(r)
    return final


async def check(update: Update, context: ContextTypes.DEFAULT_TYPE):
    logger.info("I am in update")
    await update.message.reply_text(
        "dat ja bhai search kar reya hu"
    )
