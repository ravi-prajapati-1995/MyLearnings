#!/usr/bin/env python3
# EU Visa Sponsorship & Relocation Job Search Bot
# Updated to default search for EU jobs with keywords related to visa sponsorship and relocation

# Main changes:
# - Default query: Java developer with visa sponsorship/relocation synonyms
# - EU countries list for location loop
# - Search runs for each EU country and combines results

import os
import asyncio
import logging
from typing import List, Dict, Any

from serpapi import GoogleSearch
from telegram import Update
from telegram.constants import ParseMode
from telegram.ext import ApplicationBuilder, CommandHandler, ContextTypes

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger("jobbot")

EU_COUNTRIES = [
    "Germany", "Netherlands", "Sweden", "Norway", "Finland", "Denmark", "Ireland", "Switzerland"
]
DEFAULT_QUERY = (
    'Java developer ("visa sponsorship" OR "work permit" OR relocation OR "mobility package")'
)

async def search_with_serpapi(query: str, location: str, site: str, num: int = 5) -> List[Dict[str, Any]]:
    params = {
        "engine": "google",
        "q": f"site:{site} {query} \"{location}\"",
        "num": num,
        "api_key": os.environ.get("SERPAPI_KEY"),
    }
    search = GoogleSearch(params)
    data = await asyncio.to_thread(search.get_dict)
    return [
        {
            "title": item.get("title"),
            "link": item.get("link"),
            "snippet": item.get("snippet"),
            "source": site,
            "location": location
        }
        for item in (data.get("organic_results") or [])
    ]

async def eu_job_search() -> List[Dict[str, Any]]:
    sources = {
        "linkedin": "linkedin.com/jobs",
        "indeed": "indeed.com/viewjob",
        "glassdoor": "glassdoor.com/job-listing"
    }
    all_results = []
    for country in EU_COUNTRIES:
        for site in sources.values():
            try:
                results = await search_with_serpapi(DEFAULT_QUERY, country, site)
                all_results.extend(results)
            except Exception as e:
                logger.warning(f"Search failed for {country} on {site}: {e}")
    # Deduplicate
    seen = set()
    final = []
    for r in all_results:
        if r["link"] not in seen:
            seen.add(r["link"])
            final.append(r)
    return final

async def start(update: Update, context: ContextTypes.DEFAULT_TYPE):
    await update.message.reply_text(
        "🔍 Searching EU jobs with visa sponsorship/relocation keywords..."
    )
    results = await eu_job_search()
    if not results:
        await update.message.reply_text("No results found.")
        return
    for r in results[:15]:  # limit to top 15 results for brevity
        msg = f"<b>{r['title']}</b>\n{r['snippet']}\n<i>{r['location']}</i>\n{r['link']}"
        await update.message.reply_text(msg, parse_mode=ParseMode.HTML, disable_web_page_preview=False)

def main():
    token = os.environ.get("TELEGRAM_BOT_TOKEN")
    if not token:
        raise RuntimeError("TELEGRAM_BOT_TOKEN not set")
    app = ApplicationBuilder().token(token).build()
    app.add_handler(CommandHandler("start", start))
    logger.info("EU Visa Sponsorship Bot running...")
    app.run_polling()

if __name__ == "__main__":
    main()
