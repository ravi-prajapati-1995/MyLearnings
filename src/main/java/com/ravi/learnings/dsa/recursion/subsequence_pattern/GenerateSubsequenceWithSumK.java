package com.ravi.learnings.dsa.recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array = [1, 2, 1] and sum = 2 we need to find all subsequence whose sum is two
 */
public class GenerateSubsequenceWithSumK {
    public static void main(String[] args) {
        int nums[] = {2, 1, 1, 2, 1};
        //        final var subsequenceWithSum = findSubsequenceWithSum(nums, 2);
        int countAllSubsequence = getCountAllSubsequence(nums, 2, 0, 0, new ArrayList<>());
        System.out.println(countAllSubsequence);
        //        System.out.println(subsequenceWithSum);
    }

    private static List<List<Integer>> findSubsequenceWithSum(final int[] nums, final int k) {
        final var lists = new ArrayList<List<Integer>>();

        //        getAllSubsequence(nums, k, 0, 0, new ArrayList<>(), lists);
        //        getFirstSubsequece(nums, k, 0, 0, new ArrayList<>(), lists);
        getFirstSubsequeceStriverMethod(nums, k, 0, 0, new ArrayList<>(), lists);
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
        getAllSubsequence(nums, k, idx + 1, currSum, l1, result);

        l1.removeLast();
        currSum = currSum - num;
        //Not taking the current element and proceed
        getAllSubsequence(nums, k, idx + 1, currSum, l1, result);
    }

    private static int getCountAllSubsequence(
            final int[] nums,
            final int k,
            final int idx,
            int currSum,
            List<Integer> l1
    ) {

        if (currSum == k) {
            return 1;
        }

        if (currSum > k) {
            return 0;
        }
        if (idx == nums.length) {
            return 0;
        }

        final var num = nums[idx];
        l1.add(num);
        currSum = currSum + num;
        // Take the current element and process
        int countAllSubsequence = getCountAllSubsequence(nums, k, idx + 1, currSum, l1);

        l1.remove(l1.size() - 1);
        currSum = currSum - num;
        //Not taking the current element and proceed
        int countAllSubsequence1 = getCountAllSubsequence(nums, k, idx + 1, currSum, l1);

        return countAllSubsequence + countAllSubsequence1;
    }

    private static void getFirstSubsequece(
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

        if (!result.isEmpty()) {
            return;
        }
        final var num = nums[idx];
        l1.add(num);
        currSum = currSum + num;
        // Take the current element and process
        getFirstSubsequece(nums, k, idx + 1, currSum, l1, result);

        l1.remove(l1.size() - 1);
        currSum = currSum - num;
        //Not taking the current element and proceed
        getFirstSubsequece(nums, k, idx + 1, currSum, l1, result);
    }

    private static boolean getFirstSubsequeceStriverMethod(
            final int[] nums,
            final int k,
            final int idx,
            int currSum,
            List<Integer> l1,
            List<List<Integer>> result
    ) {

        if (currSum == k) {
            result.add(new ArrayList<>(l1));
            return true;
        }

        if (currSum > k) {
            return false;
        }
        if (idx == nums.length) {
            return false;
        }

        final var num = nums[idx];
        l1.add(num);
        currSum = currSum + num;
        // Take the current element and process
        final var firstSubsequeceStriverMethod = getFirstSubsequeceStriverMethod(nums, k, idx + 1, currSum, l1, result);
        if (firstSubsequeceStriverMethod == true) {
            return true;
        }

        l1.removeLast();
        currSum = currSum - num;
        //Not taking the current element and proceed
        getFirstSubsequeceStriverMethod(nums, k, idx + 1, currSum, l1, result);
        return false;
    }
}
