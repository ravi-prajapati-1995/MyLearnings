package com.ravi.learnings.features;

public class VolatileExample {
    private static volatile boolean flag = false; // Declare the flag variable as volatile

    public static void main(String[] args) {
        // Thread that changes the flag value
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate some work
                flag = true; // Change the flag value
                System.out.println("Flag value changed to true.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Thread that checks the flag value
        new Thread(() -> {
            while (!flag) { // Loop until the flag is true
                // Busy-wait until the flag becomes true
                System.out.println("Busy-wait until the flag becomes true");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Flag detected as true, exiting loop.");
        }).start();
    }
}
