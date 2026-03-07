#!/usr/bin/env python3
# EU Visa Sponsorship & Relocation Job Search Bot
# Updated to default search for EU jobs with keywords related to visa sponsorship and relocation

# Main changes:
# - Default query: Java developer with visa sponsorship/relocation synonyms
# - EU countries list for location loop
# - Search runs for each EU country and combines results

import asyncio
import html
import os
import time
from datetime import datetime, date
from types import SimpleNamespace
from typing import List, Dict, Any
from pathlib import Path

from dotenv import load_dotenv

# Load local .env (if present) into environment for local development
load_dotenv(Path(__file__).parent / '.env')

from telegram import Update, InlineKeyboardButton, InlineKeyboardMarkup
from telegram.constants import ParseMode
from telegram.ext import ApplicationBuilder, CommandHandler, ContextTypes, CallbackQueryHandler

from search import search_with_serpapi, search_with_google_job_api, fetch_using_google

from utils import get_file_logger, parse_date, GOOGLE_SEARCH, API_GOOGLE_JOBS, DEFAULT_QUERY, EU_COUNTRIES, SOURCES, \
    FILTER_KEYWORD, SPONSORSHIP_KEYWORDS, EU_COUNTRIES_ENGLISH_LANGUAGE, has_relocation_support, DEVELOPED_COUNTRIES

from handlers import start, check, search_country_callback, search_all_countries, search_worldwide, error_handler

# Handlers moved to `handlers.py`; `bot.py` delegates to them.
# See `handlers.py` for start/search/send logic.

logger = get_file_logger("jobBot", "logs/app.log")

def main():
    token = os.environ.get("TELEGRAM_BOT_TOKEN")
    if not token:
        raise RuntimeError("TELEGRAM_BOT_TOKEN not set")
    app = ApplicationBuilder().token(token).build()
    app.add_handler(CommandHandler("start", start))
    app.add_handler(CommandHandler("check", check))
    app.add_handler(CallbackQueryHandler(search_country_callback, pattern="^search_country"))
    app.add_handler(CallbackQueryHandler(search_all_countries, pattern="^search_all"))
    app.add_handler(CallbackQueryHandler(search_worldwide, pattern="^search_worldwide"))
    app.add_error_handler(error_handler)
    logger.info("EU Visa Sponsorship Bot running...")
    app.run_polling()


if __name__ == "__main__":
    main()
