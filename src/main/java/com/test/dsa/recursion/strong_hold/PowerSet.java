package com.test.dsa.recursion.strong_hold;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/description/">Problem Link</a>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class PowerSet {
    public static void main(String[] args) {
        final var ints = new int[]{1, 2, 3};
        subsets(ints);
    }

    /**
     * Here We will use take and non-take
     * i.e [1, 2, 3] for this array we will make 2 choices
     * Take 1 and increase idx
     * Leave 1 and increase idx
     * In this way we will add recursion
     * Base Case: When reaches equal to nums length then store it in list
     *
     * TC -> O(2^n)
     * SC -> O(N) for recursive space + O(N) list that we are using to create elements + O(2^n + N) for storing final
     * result
     * */
    public static List<List<Integer>> subsets(int[] nums) {
        final var l1 = new ArrayList<Integer>();
        final var l2 = new ArrayList<List<Integer>>();
        striver(l1, l2, nums, 0);
        System.out.println(l1);
        System.out.println(l2);
        return null;
    }

    public static void aa(List<Integer> l1, List<List<Integer>> l2, int[] nums, int idx) {
        if (idx == nums.length) {
            l2.add(l1);
            return;
        }
        aa(l1, l2, nums, idx + 1);
        final var newList = new ArrayList<>(l1);
        final var num = nums[idx];
        newList.add(num);
        aa(newList, l2, nums, idx + 1);
    }

    public static void striver(List<Integer> l1, List<List<Integer>> l2, int[] nums, int idx) {
        if (idx == nums.length) {
            l2.add(new ArrayList<>(l1));
            return;
        }
        final var num = nums[idx];
        striver(l1, l2, nums, idx + 1);
        l1.add(num);
        striver(l1, l2, nums, idx + 1);
        l1.removeLast();
    }
}
