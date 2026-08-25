CSRF: Cross Site Request Forgery:

In this attack I am authenticated to a server i.e bank server and I had SESSION_ID in my browser
Then I clicked a malicious link, then that website will make a request to the bank server, as my session id already
stored in the browser so the browser will automatically add that session id ,
In this way the attacker can do malicious activity

Steps:
1. User Should be logged in website and had a token
2. It is only applicable for statefull applications
3. When user click on third party app, then in background a request made to bank server without user notice
when sending request to bank server that is known to user so browser will automatically add cookie with the request
and request succeed

How to protect CSRF token:
By adding CSRF token in the requests So when we are submitting a form in along with data we will send CSRF token
that is received from the server for each request, so server will validate that CSRF token and after that it will proceed


# Micro-ADR: Course Schedule (Cycle Detection)

- **Context:** Given a list of prerequisite pairs (e.g., to take Course A, you must take Course B), determine if it's possible to finish all courses.
- **Alternatives:**
    - *Standard DFS/BFS:* Will infinitely loop if Course A requires B, and B requires A.
- **The Decision:** Topological Sort using Kahn's Algorithm (In-Degree Array).
- **Consequences:**
    - *Pros:* Naturally isolates nodes with zero dependencies (in-degree of 0) and processes them outward. If the processed count doesn't equal total courses, a cycle exists.
    - *Gotchas:* Must represent the prerequisites as a directed Adjacency List first. Building the graph and the in-degree array simultaneously is the most common point of failure.


