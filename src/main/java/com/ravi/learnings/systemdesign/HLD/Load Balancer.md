https://www.udemy.com/course/system_design_lld_hld/learn/lecture/41910262#overview

Load Balancer: When in a application we have multiple servers to balance the traffic between these servers we need
load balancer.
This will help that requests are equally distributed appropriately between all there servers so that no one single
server over burden

There are two types of load balancer:
1. L4 load balancer ( Network Load Balancer) L4 meaning here is 4th layer of OSI model mean network layer, As it works on
Network layer so it can read only information like TCP port, UDP port, Ip address of source and destination.
. This load balancer is faster than l7

2. L7 Load Balancer (Application Load Balancer): L7 means 7th layer of OSI model , As it is on application layer so it can
read Headers, session, cookie, data and response also, So it can make decision based on these things where request should go.
It can also do caching as reads response. It is advance load balancer due to having access to multiple things and we can
balance load based on multiple things


L4 Load Balancer types:
1. Static Algorithm:
    a. Round Robin
    b. Weighted round robin
    c. Ip hash
2. Dynamic Algorithms:
    a. Least Connection
    b. Weighted least connection
    c. Lease Response Time


Round Robin: If we have 2 servers in round robing fasion req1 goest to S1(server1) and req2 goest to S2(server2)
            then r3 -> s1, r4 -> s2, r5 -> s1... so on
    advantages:
        1. Easy to Implement
        2. Equally load distributed to all the servers

    disadvantage:
        1. if one server is 32 GB RAM and another is 8 GB both are treated as same
        2. Chances that low capacity server may go down due to lack of resources

Wighted Round Robin: In this algorithm we will gave weight to the servers like if on server is 32 GB and another is 8 GB
    we can define weight for S1 4 and for S2 1, so 4 requests will goes to the S1 and after that 1 request go to the S2
    In this way we can eliminate disadvantages of round robin

    Advantages:
        1. We can define weight to the server and according to those request will be distributed
         2. Easy to implement as weight remaining static , no dynamic computation

    Disadvantage:
        1. There can be problem that request 1, 2, 3, 4 are completed in 50 ms and request 5 is taking long time like 50s
            so there may be change that long running process overburden the low weighted server


Ip hash: In this we will distribute load based on the ip address of the client, we will have hash function which will helps
    to decide at which server request should goes.

    Advantages:
        1. Easy to implement
        2. Good when we want that same client should connect with same server

    Disadvantage:
        1. If client is using a proxy then it may be chance a single server can be overloaded with the requests
        2. Can't ensure even distribution


Dynamic Load Balancing:
1. Least Connection: In this type of load balancing , load balancer checks server for the connection to the server. if
    Server 1 is having more connection and server 2 is having less connection then new request will goes to server2

    Advantages:
        1. Dynamic allocation of requests so that requests distributed equally between servers, if servers are equal then
            very low chance to overburden

    Disadvantage:
        1. If servers are not equal capacity, then 1 server may get overburden as requests distributed equally
        2. Not considering then resource usage, like server 1 is having 2 TCP connection which don't have major traffic
            then there may be chance another server get requests, as it is not considering resource usage

2. Weighted Least Connection: In this we have weight to the servers so load balancer will calculate the ratio of active
                              connection with its weight, if server 1 is 3x then server 2 load balancer will calculate
                              minimum ratio to connect with next server


3. Least Response Time: In this type of load balancer, Load balancer will keep tracking about the request and response time
                        for a request and compute TTFB(Time To first byte), and it has information about the active connection
                        with the server.
                        When a new request comes in load balancer will multiply TTFB * Active connection then server who has
                        least value new request send to that server. if this value clash then round robin method applied


