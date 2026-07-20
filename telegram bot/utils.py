import logging
import os
from datetime import datetime

API_GOOGLE_JOBS = "google_job_api"
GOOGLE_SEARCH = "google_search"

EU_COUNTRIES = [
    "Germany", "Netherlands", "Sweden", "Norway", "Finland", "Denmark", "Ireland", "Switzerland", "Spain", "Austria",
    "Portugal", "Estonia", "Latvia", "Lithuania", "Poland", "Czech Republic", "Slovakia", "Hungary", "Romania", 
    "Bulgaria", "Croatia", "Slovenia", "Greece", "Cyprus", "Malta", "France", "Belgium", "Luxembourg", "Italy",
    "Iceland"
]
EU_COUNTRIES_ENGLISH_LANGUAGE = [
    "Netherlands", "Sweden", "Norway", "Finland", "Denmark", "Ireland", "Germany", "Spain", "Portugal", "Austria",
    "Switzerland", "Belgium", "France", "Italy", "Greece", "Poland", "Czech Republic"
]

# Developed countries outside EU for global job search
DEVELOPED_COUNTRIES = [
    "United States", "Canada", "Australia", "New Zealand", "Japan", "Singapore", "South Korea", "Hong Kong",
    "United Arab Emirates", "Israel", "Taiwan", "United Kingdom"
]
DEFAULT_QUERY = (
    'Java developer ("visa sponsorship" OR "work permit" OR relocation OR "mobility package")'
)
SPONSORSHIP_KEYWORDS = ['visa sponsorship', 'work permit', 'relocation', 'mobility package']
FILTER_KEYWORD = ["unable to support", "cannot offer", "Not Available", "not offer", "not currently available",
                  "do not provide", "without the need for visa", "no sponsorship", "No visa sponsorship",
                  "no relocation", " work permit restrictions"]

# Keywords indicating relocation/sponsorship support (positive signals)
RELOCATION_POSITIVE_KEYWORDS = [
    "visa sponsorship",
    "sponsor visa",
    "visa sponsor",
    "relocation assistance",
    "relocation support",
    "relocation package",
    "relocation allowance",
    "work permit sponsorship",
    "sponsorship available",
    "sponsored visa",
    "we sponsor visas",
    "international candidates welcome",
    "willing to sponsor",
    "mobility assistance",
    "mobility package",
]

# Keywords/phrases explicitly denying sponsorship/relocation (negative signals)
RELOCATION_NEGATIVE_KEYWORDS = [
    "no sponsorship",
    "no visa sponsorship",
    "cannot sponsor",
    "unable to sponsor",
    "do not sponsor",
    "do not offer sponsorship",
    "no relocation",
    "no relocation support",
    "must have work permit",
    "must have valid work authorization",
    "no work permit sponsorship",
    "sponsorship not available",
    "unable to provide visa sponsorship",
    "cannot provide relocation",
]

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


def has_relocation_support(job: dict, confidence_threshold: float = 0.5) -> tuple:
    """
    Detect if a job posting explicitly mentions relocation/sponsorship support.
    
    Args:
        job: Job dict with keys like 'title', 'snippet', 'description'.
        confidence_threshold: Float 0.0-1.0. Return True if confidence >= threshold.
    
    Returns:
        Tuple: (is_supported: bool, confidence: float, reason: str)
            - is_supported: True if job likely offers sponsorship/relocation
            - confidence: Confidence score 0.0-1.0
            - reason: Explanation of decision (for logging)
    """
    # Combine all available text fields
    text_parts = []
    for key in ['title', 'snippet', 'description', 'location']:
        val = job.get(key, '')
        if val:
            text_parts.append(str(val))
    
    full_text = ' '.join(text_parts).lower()
    
    # Count positive signals
    positive_count = sum(1 for kw in RELOCATION_POSITIVE_KEYWORDS if kw.lower() in full_text)
    
    # Count negative signals
    negative_count = sum(1 for kw in RELOCATION_NEGATIVE_KEYWORDS if kw.lower() in full_text)
    
    # Simple scoring: if we see negative keywords, confidence is low
    if negative_count > 0:
        confidence = 0.0
        reason = f"Found {negative_count} negative keyword(s): job likely does NOT offer sponsorship."
        return False, confidence, reason
    
    # If we see positive keywords, confidence is high
    if positive_count > 0:
        confidence = min(1.0, 0.7 + (positive_count * 0.1))  # Scale up with more matches
        reason = f"Found {positive_count} positive keyword(s): job likely offers sponsorship/relocation."
        return True, confidence, reason
    
    # No explicit signals found; low confidence
    confidence = 0.3
    reason = "No explicit sponsorship/relocation signals found; treating as uncertain."
    return False, confidence, reason
