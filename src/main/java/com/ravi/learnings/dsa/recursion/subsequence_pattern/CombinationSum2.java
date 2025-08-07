package com.ravi.learnings.dsa.recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/description/">Problem Link</a>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
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
        List<List<Integer>> lists = combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
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
        Arrays.sort(candidates);
        getAllSubsequenceStriver(candidates, target, 0, 0, new ArrayList<>(), lists);
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
            if (!result.contains(sortedList)) {
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

    /**
     * instead of checking at last while we are adding element in the list
     * we will do this:
     * Sort thee array i.e [1, 2, 2, 2, 5]
     * while processing take or not take, if we are at 1st index so we will not take 2 we directly move to 5 in not take scenario
     */
    private static void getAllSubsequenceStriver(
            final int[] nums,
            final int k,
            int idx,
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
        getAllSubsequenceStriver(nums, k, idx + 1, currSum, l1, result);

        l1.removeLast();
        currSum = currSum - num;

        idx = upperBound(nums, num, idx);
        //Not taking the current element and proceed
        getAllSubsequenceStriver(nums, k, idx, currSum, l1, result);
    }

    public static int upperBound(int[] arr, int target, int start) {
        int result = arr.length;
        int low = start;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
