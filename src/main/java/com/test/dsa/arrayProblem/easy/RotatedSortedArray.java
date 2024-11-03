package com.test.dsa.arrayProblem.easy;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {2,1,3,4};
        System.out.println(check(nums));
    }
    public static boolean check(int[] nums) {
        int count = 0;

        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                count++;
            }
        }

        if(nums[nums.length-1] > nums[0]) {
            count++;
        }

        return count <= 1;
    }
}
