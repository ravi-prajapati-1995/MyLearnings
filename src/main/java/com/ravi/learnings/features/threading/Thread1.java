package com.ravi.learnings.features.threading;

/**
 * Below is the example of synchronize
 * In this example we have obj1 of class MyObject, which has synchronized method foo
 * Then created 2 threads which will access that foo method with obj1
 * In that only one thread is able to access that method at once, till it completed its task
 * After completion of one thread another thread can access that method
 * if we pass obj2 in thread2 then both can access foo method as they are different object
 */
public class Thread1 {

    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        Thread thread = new Thread(obj1::foo, "Thread-1");
        Thread thread2 = new Thread(obj1::foo, "Thread-2");
        Thread thread3 = new Thread(obj1::foo, "Thread-3");

        thread.start();
        thread2.start();
        thread3.start();
    }
}

class MyObject {
    synchronized void foo() {
        try {
            System.out.printf("Starting thread: %s%n", Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.printf("Running thread: %s%n", Thread.currentThread().getName());
            System.out.printf("Ending thread: %s%n", Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}