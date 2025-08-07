package com.ravi.learnings.features.threading;

public class TwoThreadPrintingNumbers {
    boolean printEven = false;

    /*
    * We need to put wait in condition because if it is without condition then thread will start and it will go in wait
    * state, thread will wait until some other thready notify it
    *
    * Earlier we are adding wait without condition then both thread goes in wait state and noting is printing
    * */
    synchronized public void printOdd() {
        for (int i = 1; i < 50; i = i + 2) {
            try {
                if (printEven)
                    wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            printEven = true;
            System.out.println("Print odd function: " + i);

            notify();
        }
    }

    /*
    * wait() Method Kya Karta Hai?
    wait() method ek thread ko temporarily suspend (block) karta hai aur monitor lock chhodne ke liye force karta hai, 
    taaki doosre thread ko synchronize block access karne ka mauka mile.
    
    👉 wait() ka exact kaam yeh hota hai:
    Thread execution ko pause karta hai
    
    Jab ek thread wait() call karta hai, toh woh turant waiting state me chala jata hai.
    Monitor lock ko release karta hai
    
    wait() synchronized block ya method ke andar hi call kiya ja sakta hai.
    wait() call hote hi, thread lock chhod deta hai, taaki doosra thread kaam kar sake.
    Notify hone tak wait karta hai
    
    Jab tak doosra thread notify() ya notifyAll() call nahi karta, tab tak yeh waiting state me hi rahta hai.
    * */
    synchronized private void printEven() {
        for (int i = 2; i < 50; i = i + 2) {
            try {
                if (!printEven)
                    wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            printEven = false;
            System.out.println("Print even function: " + i);

            notify();
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        final var twoThreadPrintingNumbers = new TwoThreadPrintingNumbers();
        Runnable printOdd = twoThreadPrintingNumbers::printOdd;
        Runnable printEven = twoThreadPrintingNumbers::printEven;

        Thread thread1 = new Thread(printOdd);
        Thread thread2 = new Thread(printEven);

        thread1.start();
        thread2.start();
    }


}
