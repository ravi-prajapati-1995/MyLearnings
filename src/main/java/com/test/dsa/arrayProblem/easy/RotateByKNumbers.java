package com.test.dsa.arrayProblem.easy;

import java.util.Arrays;

public class RotateByKNumbers {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        rotate1(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] b = new int[len];
        for(int i =0; i< len; i++) {
            b[(i+k)%len] = nums[i];
        }

        for(int i=0;i<len;i++) {
            nums[i] = b[i];
        }

    }

    public static void rotate1(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[k];

        for(int i = 0;i < k; i++){
            temp[i] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = nums[i];
        }

        System.out.println(Arrays.toString(temp));
//        for (int i = 0; i < len; i++) {
//            nums[i] = temp[i];
//        }

    }
}
