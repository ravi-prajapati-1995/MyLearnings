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
