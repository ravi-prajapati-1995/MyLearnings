package com.ravi.learnings.features.threading;

import java.util.Objects;


public class _001Thread {
    public static void main(String[] args) {
        final var myObj = new MyObj();
        final var myObj2 = new MyObj();
        MyClass myClass = new MyClass("Thread 1", myObj);
        MyClass myClass1 = new MyClass("Thread 2", myObj2);
        myClass.start();
        myClass1.start();

    }
}

/*
* In this class we have MyObj which is having synchronized method
* If that method is instance method and we are calling it on same myObj object, then only one thread can access it at
* a time
* If that method is instance method and we are calling it on different myObj object, then both thread can access it at
* a time independently
* If that method is static method then even if we call it on different objects then only 1 will be called
* or event we have two static synchronized method then only one will be called at same time
*
*
* */
class MyClass extends  Thread {
    String name;
    MyObj myObj;

    public MyClass(final String name, final MyObj myObj) {
        this.name = name;
        this.myObj = myObj;
    }

    @Override
    public void run() {
        if(Objects.equals(name, "Thread 1")) {
            MyObj.foo(name);
        } else {
            MyObj.bar(name);
        }
    }
}


class MyObj {

    public static synchronized void foo(String name) {
        try {
            System.out.println("Thread " + name + " foo() starting");
            Thread.sleep(3000);
            System.out.println("Thread " + name + " foo() Ending");
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " foo() interuppted");
        }
    }

    public static synchronized void bar(String name) {
        try {
            System.out.println("Thread " + name + " bar() starting");
            Thread.sleep(3000);
            System.out.println("Thread " + name + " bar() Ending");
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " bar() interuppted");
        }
    }
}
