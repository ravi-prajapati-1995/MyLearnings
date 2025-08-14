import logging
import os
from datetime import datetime

API_GOOGLE_JOBS = "google_job_api"
GOOGLE_SEARCH = "google_search"

EU_COUNTRIES = [
    "Germany", "Netherlands", "Sweden", "Norway", "Finland", "Denmark", "Ireland", "Switzerland", "Spain", "Austria",
    "Portugal", "Estonia"
]
DEFAULT_QUERY = (
    'Java developer ("visa sponsorship" OR "work permit" OR relocation OR "mobility package")'
)
SPONSORSHIP_KEYWORDS = ['visa sponsorship', 'work permit', 'relocation', 'mobility package']
FILTER_KEYWORD = ["unable to support", "cannot offer", "Not Available", "not offer", "not currently available",
                  "do not provide", "without the need for visa"]

SOURCES = {
    "linkedin": "linkedin.com/jobs",
    "indeed": "indeed.com/viewjob",
    "glassdoor": "glassdoor.com/job-listing"
}

def get_file_logger(name: str, log_file: str, level=logging.INFO, to_console=False):
    """
    Create and return a logger that writes logs to a file (and optionally console).

    :param name: Logger name (usually __name__)
    :param log_file: Path to the log file
    :param level: Logging level (e.g., logging.DEBUG, logging.INFO)
    :param to_console: If True, also log to console
    :return: Configured logger object
    """
    # Ensure log directory exists
    os.makedirs(os.path.dirname(log_file) or ".", exist_ok=True)

    logger = logging.getLogger(name)
    logger.setLevel(level)

    # Avoid adding multiple handlers if logger already set up
    if not logger.handlers:
        # File handler
        fh = logging.FileHandler(log_file, encoding="utf-8")
        fh.setLevel(level)

        # Formatter
        formatter = logging.Formatter(
            "%(asctime)s - %(name)s - %(levelname)s - %(message)s",
            datefmt="%Y-%m-%d %H:%M:%S"
        )
        fh.setFormatter(formatter)
        logger.addHandler(fh)

        # Console handler (optional)
        if to_console:
            ch = logging.StreamHandler()
            ch.setLevel(level)
            ch.setFormatter(formatter)
            logger.addHandler(ch)

    return logger

def parse_date(date_str):
    try:
        # Common formats you might encounter, extend if needed
        for fmt in ("%Y-%m-%d", "%b %d, %Y", "%d %b %Y"):
            try:
                return datetime.strptime(date_str, fmt)
            except:
                continue
        # fallback if unknown format
        return None
    except:
        return None
