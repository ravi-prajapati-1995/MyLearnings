package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * <a href=
 * "https://leetcode.com/problems/sum-of-subarray-minimums/description/">Link</a>
 * Given an array of integers arr, find the sum of min(b), where b ranges over
 * every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo 109 + 7.
 */
public class SumOfSubarrayMin {

    public static void main(String[] args) {
        int[] arr = { 71, 55, 82, 55 };
        System.out.println("nse: " + Arrays.toString(getNextSmallerElement(arr)));
        System.out.println("PSE: " + Arrays.toString(getPrevSmallerElement(arr)));
        System.out.println(sumSubarrayMinsOptimal(arr));
    }

    /**
     * To get the subarray mins sum we need to find a single element from array how
     * many times contribute in sum
     * i.e 1, 4, 6, 7, 3, 7, 8, 1
     * 0, 1, 2, 3, 4, 5, 6, 7
     * Let we are at index 4 element is 3, to figure out how many times 3 contribute
     * in sum
     * a. Get smallest element in the left side of the element which is 1 at index 0
     * b. Get smallest element in the right side it is 1 at index 7
     * So from index 1 to index 6, 3 will remain smallest element
     * 7 (right side smaller element than 3) - 4 (3 index) = 3
     * 4 (3 index) - 0 (left side smaller element than 3, which is 1) = 4
     * 3*4 = 12
     *  res = (res + (count) * arr[i] ) % mod;
     * In above statement we need to do multiple with arr[i] because that many time this number will be multiplied , so to calculate the total value it will contribute in answer
     */
    public static int sumSubarrayMinsOptimal(int[] arr) {
        int[] nse = getNextSmallerElement(arr);
        int[] pse = getPrevSmallerElement(arr);
        int res = 0;
        int mod = (int) 1e9 + 7;

        // So to get the how many time a number contribute in mins
        for(int i = 0;i< arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            int val = (int)((freq * arr[i])%mod);

            res = (res +val ) % mod;
        }

        return res;
    }

    /**
     * i.e 1, 4, 6, 7, 3, 7, 8, 1
     * 0, 1, 2, 3, 4, 5, 6, 7
     * To find the next smaller element result of above will be:
     * next smaller elements are: [-1, 3, 3, 3, 1, 1, 1, -1]
     * next smaller elements Idx: [-1, 4, 4, 4, 7, 7, 7, -1]
     * In next smaller element if we didn't found any next smaller element we will
     * assign -1
     */
    private static int[] getNextSmallerElement(final int[] arr) {
        final var length = arr.length;
        int[] nse = new int[length];

        Stack<Integer> st = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            final var num = arr[i];

            // Meaning we don't have any element in stack then directly add that in stack

            while (!st.isEmpty() && arr[st.peek()] >= num) { // Pop out elements from the stack till we get smaller
                // element than current element
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = length;
            } else {
                nse[i] = st.peek();
            }

            st.push(i);

        }
        return nse;
    }

    /**
     * i.e 1, 4, 6, 7, 3, 7, 8, 1
     * 0, 1, 2, 3, 4, 5, 6, 7
     * 
     * pse = [-1, 1, 4, 6, 1, 3, 7, -1]
     * pse idx = [-1, 0, 1, 2, 0, 4, 5, -1]
     * 
     * In case for the last element we don't have prev smaller element we will store
     * n for subraction of index, because we are doing subraction from f
     * 
     */
    private static int[] getPrevSmallerElement(final int[] arr) {
        final var length = arr.length;
        int[] pse = new int[length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < length; i++) {
            final var num = arr[i];

            // Meaning we don't have any element in stack then directly add that in stack

            while (!st.isEmpty() && arr[st.peek()] > num) { // Pop out elements from the stack till we get smaller
                // element than current element
                st.pop();
            }

            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }

            st.push(i);

        }
        return pse;
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
