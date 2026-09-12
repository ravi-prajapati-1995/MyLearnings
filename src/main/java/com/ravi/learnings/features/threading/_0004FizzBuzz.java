package com.ravi.learnings.features.threading;

/*
 * In this we have number 1-n if a number divisible by 3 print fizz, if it divisible by 5 print buzz,
 * if it is divisible by both 3 and 5 print fizzbuzz
 *
 * To do it in multithreading way we need one thread that will check if it divisible by 3,
 * 2nd thread to check 5
 * 3rd to check if it is divisible by 3 and 5
 * 4th thread to increase the number
 * */
public class _0004FizzBuzz {
    public static void main(String[] args) {
        final var fizzBuzz = new FizzBuzz(50);
//        fizzBuzz.fizzBuzz();

        Thread thread1 = new Thread(fizzBuzz::increaseNumber);
        Thread thread2 = new Thread(fizzBuzz::check5and3Divisible);
        Thread thread3 = new Thread(fizzBuzz::check3Divisible);
        Thread thread4 = new Thread(fizzBuzz::check5Divisible);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}

/*
 * Need to reiterate this
 * */
class FizzBuzz {
    private static final Object obj = new Object();
    private static int num = 1;
    Integer max;

    public FizzBuzz(int max) {
        this.max = max;
    }

    synchronized void increaseNumber() {
        for (int i = 1; i < max; i++) {
            num++;
            System.out.println("increasing number: " + num + "\t" + Thread.currentThread());
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized void check5and3Divisible() {
        while (true) {
            if (num > max) {
                return;
            }
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.println("fizzBuzz: " + num + "\t" + Thread.currentThread());
            }
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized void check3Divisible() {
        while (true) {
            if (num > max) {
                return;
            }
            if (num % 3 == 0) {
                System.out.println("fizz: " + num + "\t" + Thread.currentThread());
            }
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    synchronized void check5Divisible() {
        while (true) {
            if (num > max) {
                return;
            }
            if (num % 5 == 0) {
                System.out.println("buzz: " + num + "\t" + Thread.currentThread());
            }
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    void fizzBuzz() {
        for (int i = 1; i < 50; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzBuzz: " + i);
            } else if (i % 3 == 0) {
                System.out.println("fizz: " + i);
            } else if (i % 5 == 0) {
                System.out.println("buzz: " + i);
            }
        }
    }
}


