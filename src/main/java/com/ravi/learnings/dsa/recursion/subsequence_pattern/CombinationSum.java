package com.ravi.learnings.dsa.recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/description/">Problem Link</a>
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
 * of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150
 * combinations for the given input.
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }

    /**
     * Used earlier approach of take / not-take
     * TC - Here we are considering one element multiple times as problem says so TC dependent on the
     * target value
     * take a example where arr = [1] , target 7 so we need to go in depth 7 times
     * TC = m^n * T , here m is the depends on the target i.e [2], target 6 , so we need to take 2, 3 times to get 6 sum 2^3,
     * if element [1] target 6, so m=1 and n=6 we need to call recursively to get 6 sum need to call 1^6
     * and n is the number of times
     * T is the recursion depth  this TC is exponential
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        getAllSubsequence(candidates, target, 0, 0, new ArrayList<>(), lists);
        return lists;
    }

    private static void getAllSubsequence(
            final int[] nums,
            final int k,
            final int idx,
            int currSum,
            List<Integer> l1,
            List<List<Integer>> result
    ) {

        if (currSum == k) {
            result.add(new ArrayList<>(l1));
            return;
        }

        if (currSum > k) {
            return;
        }
        if (idx == nums.length) {
            return;
        }

        final var num = nums[idx];
        l1.add(num);
        currSum = currSum + num;
        // Take the current element and process
        getAllSubsequence(nums, k, idx, currSum, l1, result);

        l1.removeLast();
        currSum = currSum - num;
        //Not taking the current element and proceed
        getAllSubsequence(nums, k, idx + 1, currSum, l1, result);
    }
}
