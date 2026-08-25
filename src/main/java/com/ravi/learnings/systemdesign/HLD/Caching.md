Caching:
    1. Caching is the technique where we store frequently used data in fast access memory rather than accessing data
    every time from slow access memory. Slow Access Memory: HardDisk, DB, Fast Access Memory: RAM
    2. It makes system fast as data is accessed from fast access memory
    3. Helps in reduce latency
    4. Helps in achieving fault tolerance

 Different layers caching:
 1. Client Side caching
 2. CDN
 3. Load Balancer
 4. Server side (Redis) : Cache sids between application server and DB layer

 When we have multiple servers and only one cache server like redis cache so there are some problems:
 1. Single point of failure, if that cache server is down then application latency increased
 2. Lack of scalability: Server only have limited resource so it can't scale byond limit


So to overcome above problems we have distribution caching:
    In distributed caching we have multiple caching server in cache pool and each server is use caching client to connect
    with one of the cache server where it put and read the data.