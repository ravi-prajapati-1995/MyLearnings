package com.ravi.learnings.dsa.dynamic_programming;

import java.util.Arrays;

public class _001FibonacciNumbers {
    public static void main(String[] args) {
        int n = 10;
        usingTabulation(n);
        usingMemoization(n);
        usingMemoizationOptimal(n);
    }

    /*
    * TC = O(N) -- Running loop till the number of n
    * SC = O(N) -- For storing data in dpArray
    * */
    public static void usingMemoization(int n) {
        int[] dpArray = new int[n+1];

        // Start with the base case
        dpArray[0] = 0;
        dpArray[1] = 1;

        for(int i = 2; i<= n; i++) {
            dpArray[i] = dpArray[i - 1] + dpArray[i - 2];
        }
        System.out.println(Arrays.toString(dpArray));

    }

    /*
    * To eliminate the SC we can use two pointer which points
    * pre = which is n -1
    * pre2 = which is n -2
    * Instead of storing it in array we will use two variables and calculate the Fibonacci number at n
    * */
    public static void usingMemoizationOptimal(int n) {
        int pre = 1;
        int pre2 = 0;
        for(int i = 2; i<= n; i++) {
            int currI = pre + pre2;
            pre2 = pre;
            pre = currI;
        }

        System.out.println(pre);

    }

    /*
     * TC = O(N) -- Running loop till the number of n
     * SC = O(N) -- For storing data in dpArray + O(N) - Recursion call
     * */
    public static void usingTabulation(int n) {
        int[] dpArray = new int[n+1];
        Arrays.fill(dpArray, -1);
        final var fibonacci = getFibonacciTabulation(n, dpArray);
        dpArray[n] = fibonacci;
        System.out.println(Arrays.toString(dpArray));
    }
    public static int getFibonacciTabulation(int n, final int[] dpArray) {
        // base case
        if(n <= 1) {
            return n;
        }

        if(dpArray[n] != -1) {
            return dpArray[n];
        }
        // check if we have n-1 and n-2 in sour dpArray

        final var i = getFibonacciTabulation(n - 1, dpArray) + getFibonacciTabulation(n - 2, dpArray);
        dpArray[n] = i;

        return i;
    }
}
