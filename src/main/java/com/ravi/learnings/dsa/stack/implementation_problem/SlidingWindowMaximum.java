package com.ravi.learnings.dsa.stack.implementation_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Link:
 * https://leetcode.com/problems/sliding-window-maximum/description/
 * 
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * 
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    /**
     * To find the max in each window in brute force approach we will 
     * 1. Take outer loop that will run from 0 index to n-k index
     * 2. Take inner loop that will run from current index till K steps
     * 3. Take a max to current element while iterating inner loop check for max 
     * 4. After inner loop completes then add that max in the result list
     * 
     * TC: O((N-K)*K) (where N is the size of given array)
     * SC: O(N-K)
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i <= nums.length - k ; i++) {
            int max = nums[i];
            for(int j = i; j < i + k; j ++) {
                max = Math.max(max, nums[j]);
            }
            res.add(max);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();

    }

}
