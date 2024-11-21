package com.test.dsa.arrayProblem.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,3};
        int[] ints = twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{0, 1};
    }
}
