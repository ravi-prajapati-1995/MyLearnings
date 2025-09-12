package com.ravi.learnings.dsa.bit_manipulation.interview_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/description/">Problem Link</a>
 * <a href="https://takeuforward.org/plus/dsa/problems/power-set-bit-manipulation?tab=editorial">Editorial</a>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * So we can use bitwise operator to get the power set
 * Powerset of n numbers  = 2^n
 * if numbers are 3 then powerset will be 2^3 = 8
 */
public class PowerSet {
    /**
     * Taking example of {1, 2, 3}, when we generate bit from 0 - number of powerset - 1
     * 0  -> 0 0 0   -> []
     * 1  -> 0 0 1   -> [1]
     * 2  -> 0 1 0   -> [2]
     * 3  -> 0 1 1   -> [1, 2]
     * 4  -> 1 0 0   -> [3]
     * 5  -> 1 0 1   -> [1, 3]
     * 6  -> 1 1 0   -> [2, 3]
     * 7  -> 1 1 1   -> [1, 2, 3]
     * <p>
     * if we take first 0 from right most as 1 then 2nd bit 2 and then 3rd bit 3
     */
    public static void main(String[] args) {
        final var ints = new int[]{1, 2, 3};
        System.out.println(powerSet(ints));
    }

    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int noOfPowerSet = 1 << nums.length;
        for (int i = 0; i < noOfPowerSet; i++) {
            result.add(getSet(i, nums));
        }
        return result;
    }

    private static List<Integer> getSet(int i, final int[] nums) {
        List<Integer> aa = new ArrayList<>();
        int idx = 0;
        int n = nums.length - 1;
        while (i > 0) {
            if (i % 2 == 1) {
                aa.add(nums[idx]);
            }
            i = i >> 1;
            idx++;
        }
        return aa;
    }
}
