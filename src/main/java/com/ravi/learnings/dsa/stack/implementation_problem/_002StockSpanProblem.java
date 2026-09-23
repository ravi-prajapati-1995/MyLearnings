package com.ravi.learnings.dsa.stack.implementation_problem;

import java.util.ArrayList;
import java.util.Vector;

/*
 * https://takeuforward.org/plus/dsa/problems/stock-span-problem?source=strivers-a2z-dsa-track
 * Given an array arr of size n, where each element arr[i] represents the stock price on day i.
 * Calculate the span of stock prices for each day.
 * The span Si for a specific day i is defined as the maximum number of consecutive previous days (including the current day)
 * for which the stock price was less than or equal to the price on day i.
 * Input: n = 7, arr = [120, 100, 60, 80, 90, 110, 115]
 * Output: [1, 1, 1, 2, 3, 5, 6]
 * */
public class _002StockSpanProblem {
    public static void main(String[] args) {
        int[] arr = {100, 80, 90, 120};
        System.out.println(calculateSpan(arr));
        System.out.println(calculateSpanBruteForceStriver(arr));
    }

    /*
     * This is brute force solution gives the desired output, but it is time complexity
     * TC: O(n * n!)
     * */
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        final var result = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int res = 0;
            int curr = arr[i];
            for (int j = 0; j <= i; j++) {
                if (curr >= arr[j]) {
                    res++;
                } else {
                    res = 0;
                }
            }

            result.add(res);
        }
        return result;
    }

    /*
     * So instead of starting from the 0 the element and going till the current element, we can do that
     * we will start from the current element and goes toward 0, and find out how many span elements we have
     * */
    public static ArrayList<Integer> calculateSpanBruteForceStriver(int[] arr) {
        final var result = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int res = 0;
            int curr = arr[i];
            int j = i;
            while(j >= 0) {
                if(arr[j] <= curr) {
                    res++;
                } else{
                    break;
                }
                j--;
            }
            result.add(res);
        }
        return result;
    }
}
