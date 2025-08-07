package com.ravi.learnings.dsa.recursion.easy;

public class PrintNNumbers {
    public static void main(String[] args) {
        printNNumbers1(1, 4);
    }

    private static void printNNumbers(int i) {
        if (i == 0) {
            return;
        }
        printNNumbers(--i);
        System.out.println(i);

    }

    private static void printNNumbers1(int x, int n) {
        if (x > n) {
            return;
        }
        System.out.println(x);
        printNNumbers1(x+1, n);

    }

    private static void printNNumbers(int x, int n) {
        if (n == 0) {
            return;
        }
        System.out.println(x);
        printNNumbers(x, --n);

    }
}
