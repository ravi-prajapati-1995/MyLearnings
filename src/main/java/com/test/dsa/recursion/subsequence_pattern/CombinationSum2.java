package com.test.dsa.recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/description/">Problem Link</a>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{10,1,2,7,6,1,5}, 8);
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
     * */
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
            List<Integer> sortedList = l1.stream().sorted().toList();
            if(!result.contains(sortedList)) {
                result.add(new ArrayList<>(sortedList));
            }
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
        getAllSubsequence(nums, k, idx + 1, currSum, l1, result);

        l1.removeLast();
        currSum = currSum - num;
        //Not taking the current element and proceed
        getAllSubsequence(nums, k, idx + 1, currSum, l1, result);
    }
}
