Consider A child want to eat chocolate , he asks his mother to bring , then his mother go to shop and bring chocolate

In above case Mother is act like proxy, Child is Client and Shopkeeper is Server
Meaning: Execute request on someone's behalf, A proxy server can execute requests on behalf of multiple clients, so that
client and server don't have direct communication

Types:
    Forward (Simple Proxy): Simple proxy is known as forward proxy in this requests goes clients -> Proxy -> internet -> server
                            1. Proxy will helps to hide the client that helps in anonymous
                            2. It can Group multiple request if same request is made by multiple clients and send them
                               in group
                            3. Using proxy we can access restricted content, as original request is being made by the proxy server
                            4. Using Proxy we can add some security like if we want to stop access of particular website
                            5. We can also do caching if there are certain static content
                     Disadvantage:
                            1. It works on the application level, if we are having 10 application then we need to create
                            10 proxy servers


    Reverse: No request comming from internet directly communicate with the server, reverse proxy sits between internet and
             the servers
             1. It also adds security outside world don't know the ip addresses of ther servers, as each request is comming to
                the reverse proxy and from there it goes to servers, In case of DDOS attach attacker only attach on the
                proxy server as it is not aware about the actual server and on reverse proxy server only I can hadler
                DDOS attack

                CDN work based on reverse proxy

             2. We can cache static content on the reverse proxy when a user request for data then it first checks on the
                Reverse proxy after that only it reaches to the actual server

             3. Decrease Latency as we can have multiple reverse proxy server based on user location and when data delivered
                by reverse proxy it helps in decreasing latency
             4. Load Balancer Tasks can be done by reverse proxy

Proxy VS VPN:
    VPN:
        There are two  components like VPN client and VPN server when we connect with a VPN it creates a private tunnel
        with the VPN Server in that tunnel data will be encrypted that is done by VPN client, if some attacker attacks
        it will only find encrypted data.
        After that same request when to VPN server and then VPN server will decrypt it again and then sends request to
        the internet

Proxy vs Load Balancer:
    Proxy can be work as load balancer but a Load blancer can't act as proxy because proxy has many things to do like adding
    security, work as CDN , can do logging etc

Proxy vs Firewall:

Firewall: Think you have and wall and it has holes, and each hole is having some rule to pass from it, if  a request came
to firewall it checks the rules like, source and destination IPs, headers, port using packets, if any rule matches request go through
the firewall, if not it will be blocked. Firewall works on packets it do packet scanning, so it work on tranport layer

Proxy: It works on the application layer