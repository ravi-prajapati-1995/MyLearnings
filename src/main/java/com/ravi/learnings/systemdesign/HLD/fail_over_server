We have only one DB for our application, SO when DB goes down our application will go down.
So its an single point of failure
To overcome this issue we have few strategy:
1. Failover Server: Cold Standby: -- In this scenario we will have periodic backup of our data on the storage service i.e
s3 and we have another database server and when server main DB server goes down we restore latest backup on the new
server.
Pros: This is cost effective we need to run DB only when main DB is down, which is good for service which can loose some data
Cons:
1. Need time to create and restore backup on new server, for that time application will be down
2. Data can be lost for some time

Failover Server: Warm Standby:--
So instead of getting copy from the DB, we have an another database which is running everytime and create replication of
main DB
Databases have inbuild functionality for the replication if you are running DB server you need to provide url for that

Failover Server: Hot Standby:
In this we have same setup like warm standby, main difference is that application can read simultaneously from both servers
if case main/master DB goes down all traffic move to secondary DB as everthing will be upto date in secondary DB to,
and read/write operation done by the secondary DB

Failover Server: Multi-primary: -- True Horizontal