package com.ravi.learnings.dsa.arrayProblem.easy;

import java.util.Arrays;

public class MoveZeroToLast {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;

        for(int i = 0; i <nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonZeroIdx] = nums[i];
                nonZeroIdx++;
            }
        }

        for(int i = nonZeroIdx; i<nums.length;i++) {
            nums[i] = 0;
        }
    }
}
