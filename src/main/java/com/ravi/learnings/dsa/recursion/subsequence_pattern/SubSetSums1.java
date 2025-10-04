package com.ravi.learnings.dsa.recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/problems/subset-sums2234/1">Problem link</a>
 * Given a array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.
 * <p>
 * Input: arr[] = [2, 3]
 * Output: [0, 2, 3, 5]
 * Explanation: When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2.
 * When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
 * <p>
 * Input: arr[] = [1, 2, 1]
 * Output: [0, 1, 1, 2, 2, 3, 3, 4]
 * Explanation: The possible subset sums are 0 (no elements), 1 (either of the 1's), 2 (the element 2),
 * and their combinations.
 */
public class SubSetSums1 {

    public static void main(String[] args) {
        var lists = subsetSums(new int[]{2, 3});
        System.out.println(lists);
    }

    public static ArrayList<Integer> subsetSums(int[] arr) {
        Arrays.sort(arr);
        final var l1 = new ArrayList<Integer>();
        getAllSubsequenceStriver(arr, 0, 0, l1);
        return l1;
    }

    /**
     * Same as powerset problem we will carry sum instead of list
     * TC - 2^n (generating 2 raise to power n subsequence) * N(We have n steps for generating each sum)
     * for [2, 3] -> [0, 2, 3, 5] for 2 element we have 4
     */
    private static void getAllSubsequenceStriver(
            final int[] nums,
            int idx,
            int currSum,
            List<Integer> l1
    ) {

        if (idx == nums.length) {
            l1.add(currSum);
            return;
        }

        final var num = nums[idx];
        currSum = currSum + num;
        // Take the current element and process
        getAllSubsequenceStriver(nums, idx + 1, currSum, l1);

        currSum = currSum - num;

        idx = upperBound(nums, num, idx);
        //Not taking the current element and proceed
        getAllSubsequenceStriver(nums, idx, currSum, l1);
    }

    public static int upperBound(int[] arr, int target, int start) {
        int result = arr.length;
        int low = start;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
