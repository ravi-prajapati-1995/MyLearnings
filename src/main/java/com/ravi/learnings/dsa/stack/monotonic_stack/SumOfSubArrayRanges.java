package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Problem link:
 * https://leetcode.com/problems/sum-of-subarray-ranges/description/
 * 
 * You are given an integer array nums. The range of a subarray of nums is the
 * difference between the largest and smallest element in the subarray.
 * Return the sum of all subarray ranges of nums.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Input: nums = [1,2,3]
 * Output: 4
 * Explanation: The 6 subarrays of nums are the following:
 * [1], range = largest - smallest = 1 - 1 = 0
 * [2], range = 2 - 2 = 0
 * [3], range = 3 - 3 = 0
 * [1,2], range = 2 - 1 = 1
 * [2,3], range = 3 - 2 = 1
 * [1,2,3], range = 3 - 1 = 2
 * So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
 */
public class SumOfSubArrayRanges {

    public static void main(String[] args) {
            int arr[] = {4,-2,-3,4,1};
            System.out.println(subArrayRangesOptimal(arr));
    }

    /**
     * To get the sub array ranges we will use sum or subarray min and sum of subarray max
     * then to get the sub array ranges we will do (sum of subarray max) - (sum of subarray min)
     * 
     * @param nums
     * @return
     */
    public static long subArrayRangesOptimal(int[] nums) {
        return  sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }

     public static long sumSubarrayMax(int[] arr) {
        int[] nse = getNextMaxElement(arr);
        int[] pse = getPrevMaxElement(arr);
        long res = 0;

        // So to get the how many time a number contribute in mins
        for(int i = 0;i< arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            long val = (int)((freq * arr[i]));

            res = (res +val );
        }

        return res;
    }

    private static int[] getNextMaxElement(final int[] arr) {
        final var length = arr.length;
        int[] nse = new int[length];

        Stack<Integer> st = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            final var num = arr[i];


            while (!st.isEmpty() && arr[st.peek()] <= num) {
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

    private static int[] getPrevMaxElement(final int[] arr) {
        final var length = arr.length;
        int[] pse = new int[length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < length; i++) {
            final var num = arr[i];
            while (!st.isEmpty() && arr[st.peek()] < num) {
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

    public static long sumSubarrayMins(int[] arr) {
        int[] nse = getNextSmallerElement(arr);
        int[] pse = getPrevSmallerElement(arr);
        System.out.println("NSE: "+ Arrays.toString(nse));
        System.out.println("PSE: "+ Arrays.toString(pse));
        long res = 0;

        // So to get the how many time a number contribute in mins
        for(int i = 0;i< arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            long val = (int)((freq * arr[i]));

            res = (res +val );
        }

        return res;
    }

    private static int[] getNextSmallerElement(final int[] arr) {
        final var length = arr.length;
        int[] nse = new int[length];

        Stack<Integer> st = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            final var num = arr[i];


            while (!st.isEmpty() && arr[st.peek()] >= num) {
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

    private static int[] getPrevSmallerElement(final int[] arr) {
        final var length = arr.length;
        int[] pse = new int[length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < length; i++) {
            final var num = arr[i];
            while (!st.isEmpty() && arr[st.peek()] > num) {
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
     * Here we created 2 inner loop as we need to generate all subarray i.e {1, 2, 3, 4}
     * 1                2           3       4
     * 1, 2             2, 3        3, 4
     * 1, 2, 3          2, 3, 4
     * 1, 2, 3, 4
     * 
     * In inner loop for each element I get largest and samllest by maintaining 2 variables and then calculating range
     * for each step
     * TC = O(N^2)
     * @param nums
     * @return
     */
    public static long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int s = nums[i];
            int l = nums[i];
            // We are starting inner loop from i+1 because if we start it from i then for first subarray i = 0, j = 0
            //that became 0 always so starting 1 step ahead
            for (int j = i+1; j < nums.length; j++) {
                
                if(nums[j] < s) {
                    s = nums[j];
                }

                if(nums[j] > l) {
                    l = nums[j];
                }

                res = res + (l-s);
            }
        }
        return res;
    }

}
