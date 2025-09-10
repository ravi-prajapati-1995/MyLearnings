package com.ravi.learnings.dsa.bit_manipulation.interview_problems;

/**
 *<a href="https://leetcode.com/problems/single-number/description/">Problem link</a>
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * TC = O(N)
 * */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        int number = 0;
        for (int n : nums) {
            number = number ^ n;
        }
        return number;
    }
}
