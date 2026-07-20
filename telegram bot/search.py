import asyncio
from datetime import datetime
from typing import List, Dict, Any

from serpapi import GoogleSearch

from utils import parse_date, SPONSORSHIP_KEYWORDS, DEFAULT_QUERY, SOURCES, GOOGLE_SEARCH, API_GOOGLE_JOBS, get_file_logger

logger = get_file_logger("search", "logs/app.log")


async def search_with_serpapi(query: str, location: str, site: str, num: int = 15) -> List[Dict[str, Any]]:
    params = {
        "engine": "google",
        "q": f"site:{site} {query} \"{location}\"",
        "num": num,
        "tbs": "qdr:m",
        "api_key": __import__('os').environ.get("SERPAPI_KEY"),
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
            "tbs": "qdr:m",
            "api_key": __import__('os').environ.get("SERPAPI_KEY"),
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


async def fetch_using_google(all_results, country, location):
    for site in SOURCES.values():
        try:
            results = await search_with_serpapi(DEFAULT_QUERY, country, site)
            all_results.extend(results)
        except Exception as e:
            logger.error(f"Search failed for {country} on {site}: {e}", e)
