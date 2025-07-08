package com.test.dsa.recursion.strong_hold;

import java.util.List;

/**
 *<a href="https://leetcode.com/problems/subsets/description/">Problem Link</a>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Subsets {
    public static void main(String[] args) {
        final var ints = new int[]{1, 2, 3};
        subsets(ints);
    }


    public static List<List<Integer>> subsets(int[] nums) {

        return null;
    }

    public static void aa(int[] nums, int idx) {
        if(idx == nums.length) {
            return;
        }

        final var num = nums[idx];
        System.out.println(num);
        aa(nums, idx + 1);

    }
}
