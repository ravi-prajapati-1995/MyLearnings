package com.ravi.learnings.dsa.stack.monotonic_stack;

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
            System.out.println(subArrayRanges(arr));
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
