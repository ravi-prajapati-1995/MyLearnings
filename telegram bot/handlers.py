import html
import time
from types import SimpleNamespace
from telegram import Update, InlineKeyboardButton, InlineKeyboardMarkup
from telegram.constants import ParseMode
from telegram.ext import ContextTypes

from utils import get_file_logger, FILTER_KEYWORD, EU_COUNTRIES_ENGLISH_LANGUAGE, has_relocation_support, DEVELOPED_COUNTRIES, GOOGLE_SEARCH
from search import fetch_using_google, search_with_google_job_api

logger = get_file_logger("jobBot.handlers", "logs/app.log")

fetched_data = {}


async def search_country_callback(update: Update, context: ContextTypes.DEFAULT_TYPE):
    query = update.callback_query
    if not query:
        return
    await query.answer()  # remove loading state
    data = query.data or ""
    country = data.split("|", 1)[1] if "|" in data else data
    await query.edit_message_text(f"Searching jobs for {country} ...")

    results = []
    try:
        await fetch_using_google(results, country, "google_search")
    except Exception as e:
        logger.error(f"Error during Google site search for {country}: {e}")

    try:
        api_results = await search_with_google_job_api(country)
        results.extend(api_results)
    except Exception as e:
        logger.error(f"Error during Google Jobs API search for {country}: {e}")

    # dedupe by link or (title, location, date)
    seen = set()
    final = []
    for r in results:
        key = r.get("link") or (r.get("title"), r.get("location"), r.get("date"))
        if key not in seen:
            seen.add(key)
            final.append(r)

    if not final:
        await query.message.reply_text(f"No results found for {country}.")
        return

    # reuse send_job_message by faking an update with .message
    fake_update = SimpleNamespace(message=query.message)
    await send_job_message(final, fake_update)


async def start(update: Update, context: ContextTypes.DEFAULT_TYPE):
    global fetched_data
    fetched_data = { }
    user = update.effective_user
    user_name = f"{user.first_name} {user.last_name}"
    logger.info(f"Starting job for the user: {user_name} and message: {update.effective_message.text}")
    await update.message.reply_text(
        f"Hi {user_name} 🔍 Searching jobs with visa sponsorship/relocation keywords..."
    )

    keyboard = []
    countries = EU_COUNTRIES_ENGLISH_LANGUAGE
    for i in range(0, len(countries), 2):
        row = [
            InlineKeyboardButton(c, callback_data=f"search_country|{c}") for c in countries[i:i+2]
        ]
        keyboard.append(row)
    
    # Add "Search All" buttons at the bottom
    keyboard.append([InlineKeyboardButton("🌍 Search All EU Countries", callback_data="search_all")])
    keyboard.append([InlineKeyboardButton("🌎 Search Worldwide (Developed)", callback_data="search_worldwide")])
    
    markup = InlineKeyboardMarkup(keyboard)
    await update.message.reply_text("Select a country to search or search across regions:", reply_markup=markup)


async def send_job_message(results, update: Update):
    # First, filter by FILTER_KEYWORD (existing logic)
    filtered_results = [
        item for item in results
        if not any(keyword.lower() in (item.get("snippet") or "").lower() for keyword in FILTER_KEYWORD)
    ]
    
    # Filter to include only Java-related jobs
    java_filtered = [
        item for item in filtered_results
        if "java" in (item.get("title") or "").lower() or "java" in (item.get("snippet") or "").lower()
    ]
    
    if not java_filtered:
        await update.message.reply_text("No Java jobs found matching your criteria.")
        return
    
    logger.info(f"Java filter: {len(java_filtered)} out of {len(filtered_results)} jobs matched")
    
    # Apply relocation/sponsorship filtering
    relocation_filtered = []
    uncertain_jobs = []
    filtered_out_count = 0
    
    for item in java_filtered:
        is_supported, confidence, reason = has_relocation_support(item)
        if is_supported:
            relocation_filtered.append(item)
            logger.info(f"✓ Included: {item['title']} | {reason}")
        elif confidence >= 0.3:  # Uncertain; keep in secondary list
            uncertain_jobs.append(item)
            logger.info(f"? Uncertain: {item['title']} | {reason}")
        else:
            filtered_out_count += 1
            logger.info(f"✗ Filtered out: {item['title']} | {reason}")
    
    # Log summary
    logger.info(f"Relocation filter results: {len(relocation_filtered)} included, {len(uncertain_jobs)} uncertain, {filtered_out_count} excluded")
    
    # Send included jobs first
    if relocation_filtered:
        await update.message.reply_text(f"<b>Found {len(relocation_filtered)} Java job(s) with explicit sponsorship/relocation support:</b>", parse_mode=ParseMode.HTML)
        for r in relocation_filtered:
            formatted_date = r['date'].strftime("%d %B %Y") if r['date'] else ""
            snippet = r.get('snippet') or ""
            if len(snippet) > 200:
                snippet = snippet[:200] + "…"
            snippet = html.escape(snippet)

            msg = f"<b>{r['title']}</b>\n{snippet}\n<i>{r['location']} - {formatted_date}</i>\n{r['link']}"
            await update.message.reply_text(msg, parse_mode=ParseMode.HTML, disable_web_page_preview=False)
            time.sleep(1)
    else:
        await update.message.reply_text("No Java jobs found with explicit sponsorship/relocation support.")
    
    # Send uncertain jobs
    if uncertain_jobs:
        await update.message.reply_text(f"\n<b>⚠️ Uncertain ({len(uncertain_jobs)} job(s) without explicit signals - check details):</b>", parse_mode=ParseMode.HTML)
        for r in uncertain_jobs:
            formatted_date = r['date'].strftime("%d %B %Y") if r['date'] else ""
            snippet = r.get('snippet') or ""
            if len(snippet) > 200:
                snippet = snippet[:200] + "…"
            snippet = html.escape(snippet)
            msg = f"⚠️ <i><b>{r['title']}</b></i>\n{snippet}\n<i>{r['location']} - {formatted_date}</i>\n{r['link']}"
            await update.message.reply_text(msg, parse_mode=ParseMode.HTML, disable_web_page_preview=False)
            time.sleep(1)


async def check(update: Update, context: ContextTypes.DEFAULT_TYPE):
    logger.info("I am in update")
    await update.message.reply_text(
        "dat ja bhai search kar reya hu"
    )


async def search_all_countries(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Search jobs across all EU countries and aggregate results."""
    query = update.callback_query
    if not query:
        return
    await query.answer()
    await query.edit_message_text("🌍 Searching jobs across all EU countries... This may take a moment.")

    all_results = []
    countries = EU_COUNTRIES_ENGLISH_LANGUAGE
    
    for country in countries:
        try:
            results = []
            await fetch_using_google(results, country, GOOGLE_SEARCH)
            all_results.extend(results)
            logger.info(f"Searched {country}: {len(results)} results")
        except Exception as e:
            logger.error(f"Error searching {country}: {e}")

        try:
            api_results = await search_with_google_job_api(country)
            all_results.extend(api_results)
            logger.info(f"Google Jobs API for {country}: {len(api_results)} results")
        except Exception as e:
            logger.error(f"Error with Google Jobs API for {country}: {e}")

    # Dedupe by link or (title, location, date)
    seen = set()
    final = []
    for r in all_results:
        key = r.get("link") or (r.get("title"), r.get("location"), r.get("date"))
        if key not in seen:
            seen.add(key)
            final.append(r)

    if not final:
        await query.message.reply_text("No results found across all EU countries.")
        return

    logger.info(f"Total results before filtering: {len(final)}")

    # Reuse send_job_message by faking an update
    fake_update = SimpleNamespace(message=query.message)
    await send_job_message(final, fake_update)


async def search_worldwide(update: Update, context: ContextTypes.DEFAULT_TYPE):
    """Search jobs across developed countries worldwide and aggregate results."""
    query = update.callback_query
    if not query:
        return
    await query.answer()
    await query.edit_message_text("🌎 Searching jobs across developed countries worldwide... This may take a moment.")

    all_results = []
    countries = DEVELOPED_COUNTRIES
    
    for country in countries:
        try:
            results = []
            await fetch_using_google(results, country, GOOGLE_SEARCH)
            all_results.extend(results)
            logger.info(f"Searched {country}: {len(results)} results")
        except Exception as e:
            logger.error(f"Error searching {country}: {e}")

        try:
            api_results = await search_with_google_job_api(country)
            all_results.extend(api_results)
            logger.info(f"Google Jobs API for {country}: {len(api_results)} results")
        except Exception as e:
            logger.error(f"Error with Google Jobs API for {country}: {e}")

    # Dedupe by link or (title, location, date)
    seen = set()
    final = []
    for r in all_results:
        key = r.get("link") or (r.get("title"), r.get("location"), r.get("date"))
        if key not in seen:
            seen.add(key)
            final.append(r)

    if not final:
        await query.message.reply_text("No results found across developed countries worldwide.")
        return

    logger.info(f"Total results before filtering: {len(final)}")

    # Reuse send_job_message by faking an update
    fake_update = SimpleNamespace(message=query.message)
    await send_job_message(final, fake_update)


async def error_handler(update: object, context: ContextTypes.DEFAULT_TYPE):
    print(f"⚠️ Exception: {context.error}")
    logger.error(f"Something wrong happen {context.error}", context)
    if update and isinstance(update, Update):
        try:
            await update.message.reply_text("Oops! Something went wrong.")
        except Exception as e:
            logger.error("Something wrong happended {e}", e)
