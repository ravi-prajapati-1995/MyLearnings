RabbitMQ has below components:
1. Producer
2. Exchange
3. Queue
4. Consumer

Producer: Producer will send message to exchange and from there based on Routing key it will put into a queue

Exchange:
    1. Fanout: This will broadcast the message to all the queue which are associated with this exchange
    2. Direct: Based on the key it will send message to that queue if exactly match with the key(Message Key & Routing key)
    3. Topic: We can use wild card like: *123 if india_123 comes then sent message to all the queue which matches with the
        pattern like *123

In rabbitMQ if a message is not able to process then server requeue that message after multiple retry it goes to dead letter
queue