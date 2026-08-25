What is Hashing?
Hashing a technique in which I give a random length string to a function and it will return a constant length string/Integer
i.e hash("ravi") -> 5 , hash("Nitin") -> 2

Module of Hashing: When we have a fixed length hash table or hashmap and want to store all the result of hash function
in that DS then we use module:
i.e hash function return 239 and we have 6 size of hashtable or list then we do 239 % 6 -> 5, 123874 % 6 -> 4

Where hashing is used:
1. On load balancer: If we have 3 servers and  we have hash function based on ip  address then that function will return
values from 1, 2 and 3 and according to that we will move request to corresponding server.
2. In Horizontal Sharding: We have a table which is having 100k entries of user and we want to shard it on multiple servers
such that a-f on 1 server g-p on 2 and from q-z on 3rd server, so we will write a hash function, that will give server no
based on first name and we will store data accordingly

Problem with Hashing:
    Load Balancer:
        1. We do hashing or constant hashing when we add or remove a server then we need to rehash requests again.
        2. There may be chances also that 1 server will receive more request than other that will also cause problem

    Horizontal sharding:
        1. In horizontal sharding if we added new server or Deleted a server then we need to re - balancing the record may be from
            1st server some record to 2nd and so on, re-balancing is very expensive task that will take time.

Consistence Hashing: When there is addition of new node or deletion of node in that case rebalanceing should be minimum
it should be (1/n)%  where n is the number of nodes, of total numbers of keys


How Does Consistence hashing works:
  In consistence hashing we have a virtual ring which will have some numbers in our case lets take a virtual ring
  0 - 11 and I am having a hash function key%12 with will give me where current data will goes

  on that virtual ring we will have point our server lets take we have 3 server 1 is at 3rd position, 2nd is at 7th and
  3rd is at 11th position

  when any data came we will calculate its hash, using hash function lets take a example
  k1 comes at 1st place, k2 comes on 2nd soo on k11 comes on 11th position in the virtual ring
  then to calculate which key is handled by which server, we move in the clockwise direction, for k1 we move in clockwise
  direction then at 3rd position we have s1 , that will handle k1, same for k2 in clockwise direction we have S1
  so k2 request also handled by S1,

  see in this video for graphics: https://www.udemy.com/course/system_design_lld_hld/learn/lecture/41910208#overview

  similarly for for K4 and k5 request will go ton the S2 which is at 7th position
  and K8, k9 and k10 will got to S3 at 11th position

  How it will resolve problem in addition of server and removing of the server:
    Current server setup: s1  -> 3rd, s2-- 7th and s3 --- at 11th
    Lets suppose we have added a new server at position 5 so I have to do rebalancing of the keys which are between 3, 4 only
    because request before 3rd now also handled by
    Before Rebalancing
    S1 handles -- k0, k1, k2,
    S2 Handles: k4, k5, k6
    S3 handles: k7, k8, k9, k10

    After adding new server:
    S1 handles -- k0, k1, k2,
    S2 Handles: k5, k6
    S3 handles: k7, k8, k9, k10
    s4 (new Server): it is at 5th position so k4 request will be reblanced only, : k4

    in  this way adding new server required minimum rebalancing
    If we delete a node:
    suppose we have deleted s2:
     Before Rebalancing
     S1 handles -- k0, k1, k2,
     S2 Handles: k4, k5, k6
     S3 handles: k7, k8, k9, k10

     After deleting s2
      S1 handles -- k0, k1, k2,
      S3 handles: k4, k5, k6, k7, k8, k9, k10

      we need to re-balance k4, k5 and k6 all other requests go same way


  Disadvantage: we distribute the server on the ring at equal distance by our hash function if our hash function will return
  s1 at 1st , s2 at 2nd and s3 at 3rd place in that case most of the requests will be handled by s1 only, in this case
  constant load balancer across servers fails


To overcome above problem we will replicate the same server at the different position in the virtual ring so that distribution
can be equal balanced


Where consistance hashing will work:    Where I am having dynamic servers where adding new node and deleting existing load