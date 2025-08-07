package com.ravi.learnings.dsa.recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets-ii/">Problem Link</a>
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class SubSetSums2 {

    public static void main(String[] args) {
        int nums[] = {1, 2, 2};
        subsetsWithDup(nums);
    }

    /**
     * We used power set logic here, just modified when we are calling second call,
     * TC = O(2^n) * N
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        final var lists = new ArrayList<List<Integer>>();
        getAllSubsequenceWithForLoop(nums, 0, new ArrayList<>(), lists);
        System.out.println(lists);
        return lists;
    }

    private static void getAllSubsequenceStriver(
            final int[] nums,
            int idx,
            List<Integer> l1,
            List<List<Integer>> l2
    ) {

        if (idx == nums.length) {
            l2.add(new ArrayList<>(l1));
            return;
        }

        final var num = nums[idx];
        l1.add(num);
        // Take the current element and process
        getAllSubsequenceStriver(nums, idx + 1, l1, l2);

        l1.removeLast();
        idx = upperBound(nums, num, idx);
        //Not taking the current element and proceed
        getAllSubsequenceStriver(nums, idx, l1, l2);
    }

    private static void getAllSubsequenceWithForLoop(
            final int[] nums,
            int idx,
            List<Integer> l1,
            List<List<Integer>> l2
    ) {

        if (idx == nums.length) {
            l2.add(new ArrayList<>(l1));
            return;
        }

        final var num = nums[idx];
        l1.add(num);
        // Take the current element and process
        getAllSubsequenceWithForLoop(nums, idx + 1, l1, l2);

        l1.removeLast();
        while (idx < nums.length && nums[idx] == num) {
            idx++;
        }
        //Not taking the current element and proceed
        getAllSubsequenceWithForLoop(nums, idx, l1, l2);
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
