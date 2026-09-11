# Threading

In [_001Thread.java](_001Thread.java) this file we have it will have MyObj and MyClass with is thread class by extending
Thread.
When we create single object of MyObj and pass same in MyClass
objects, then foo method calls on Thread 1 when it completed task
then Thread 2 start processing 

Mean at a time only one object get accessed to foo method

When we changed foo method to static then if we have different object 
for MyObj, then only one can access at a time even another thread is accessing bar method 