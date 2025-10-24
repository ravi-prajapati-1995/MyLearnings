package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/description/">Link</a>
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo 109 + 7.
 */
public class SumOfSubarrayMin {

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 3, 7, 8, 1};
        System.out.println(Arrays.toString(getNextSmallerElement(arr)));
        System.out.println(Arrays.toString(getPrevSmallerElement(arr)));
    }

    /**
     * To get the subarray mins sum we need to find a single element from array how many times contribute in sum
     * i.e 1, 4, 6, 7, 3, 7, 8, 1
     *     0, 1, 2, 3, 4, 5, 6, 7
     * Let we are at index 4 element is 3, to figure out how many times 3 contribute in sum
     * a. Get smallest element in the left side of the element which is 1 at index 0
     * b. Get smallest element in the right side it is 1 at index 7
     * So from index 1 to index 6, 3 will remain smallest element
     * 7 (right side smaller element than 3) - 4 (3 index) = 3
     * 4 (3 index) - 0 (left side smaller element than 3, which is 1) = 4
     * 3*4 = 12
     */
    public static int sumSubarrayMinsOptimal(int[] arr) {
        getNextSmallerElement(arr);
        return 1;
    }

    /**
     * i.e 1, 4, 6, 7, 3, 7, 8, 1
     *     0, 1, 2, 3, 4, 5, 6, 7
     * To find the next smaller element result of above will be:
     * 
     */
    private static int[] getNextSmallerElement(final int[] arr) {
        final var length = arr.length;
        int[] nse = new int[length];

        Stack<Integer> st = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            final var num = arr[i];


        }
        return nse;
    }

    /**
     * i.e 1, 4, 6, 7, 3, 7, 8, 1
     * 0, 1, 2, 3, 4, 5, 6, 7
     */
    private static int[] getPrevSmallerElement(final int[] arr) {
        final var length = arr.length;
        int minIdx = 0;
        int[] nse = new int[length];

        for (int i = 0; i < length; i++) {
            if (arr[i] <= arr[minIdx]) {
                nse[i] = i;
                minIdx = i;
            } else {
                nse[i] = minIdx;
            }
        }
        return nse;
    }

    /**
     * Here we are running two loops to calculate the min of the subarray
     * we start first loop from i=0 to n
     * Then nested loop from j = i to n
     * in inner loop for each we calculate the min
     * i.e [3, 1, 2, 4] , in min we have 3 for i=0;
     * then we compare 3, 3 after that 3, 1 then 1, 2 then 2, 4 and so on...
     * <p>
     * TC - O(N^2) -- as we are using two nested loops
     * SC - O(1) not using extra space
     */
    public static int sumSubarrayMins(int[] arr) {
        final var n = arr.length;
        int res = 0;
        int mod = (int) Math.pow(10, 9) + 7;

        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                res = (res + min) % mod;
            }
        }
        return res;
    }
}
