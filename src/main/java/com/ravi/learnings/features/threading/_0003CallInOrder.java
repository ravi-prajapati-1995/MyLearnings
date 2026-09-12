package com.ravi.learnings.features.threading;

import java.util.concurrent.locks.ReentrantLock;

public class _0003CallInOrder {
    public static void main(String[] args) {
        final var foo = new Foo();
        final var bar = new Bar();
        for(int i  = 0; i< 5;  i++) {
            test1(foo);
//            test2(bar);
        }
    }

    private static void test1(Foo foo) {
        Thread thread1 = new Thread(foo::first);
        Thread thread2 = new Thread(foo::second);
        Thread thread3 = new Thread(foo::third);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void test2(Bar bar) {

        Thread thread1 = new Thread(bar::first);
        Thread thread2 = new Thread(bar::second);
        Thread thread3 = new Thread(bar::third);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


/*
* We have below class Foo and there are 3 method that need to be called one after one
* */
class Foo {
    ReentrantLock lock = new ReentrantLock(true);

    void first() {
        try {
            lock.lock();
            System.out.println("I am in first(): "+Thread.currentThread());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void second() {
        try {
            lock.lock();
            System.out.println("I am in second(): "+Thread.currentThread());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void third() {
        try {
            lock.lock();
            System.out.println("I am in third(): "+Thread.currentThread());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


/*
 * We have below class Foo and there are 3 method that need to be called one after one
 * */
class Bar {

    synchronized void first() {
        try {
            System.out.println("I am in first(): "+Thread.currentThread());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void second() {
        try {
            System.out.println("I am in second(): "+Thread.currentThread());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void third() {
        try {
            System.out.println("I am in third(): "+Thread.currentThread());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}