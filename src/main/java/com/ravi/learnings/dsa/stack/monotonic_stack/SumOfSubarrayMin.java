package com.ravi.learnings.dsa.stack.monotonic_stack;

/**
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/description/">Link</a>
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo 109 + 7.
 */
public class SumOfSubarrayMin {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        final var n = arr.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int x = i; x < n; x++) {
                int min = arr[x];
                for (int j = x + 1; j < n; j++) {
                    min = Math.min(arr[j], min);
                }
                res = res + min;
            }
        }
        return res;
    }
}
