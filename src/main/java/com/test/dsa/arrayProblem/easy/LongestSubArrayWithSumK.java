package com.test.dsa.arrayProblem.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 50, 1, 1, 1, 50, 2, 3, 2, 3};
        int i = lenOfLongestSubArrTwoPointerApproach(arr, 6);
        System.out.println(i);
    }

    public static int lenOfLongestSubarr(int[] arr, int k) {
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = 0;
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                len++;
                if (currentSum == k) {
                    if (len > maxlen) {
                        maxlen = len;
                    }
                }
            }
        }
        return maxlen;
    }

    public static int lenOfLongestSubarrBetterSolutionValidForPositiveCase(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == k) {
                maxLen = i+1;
            }
            int rem = sum - k;
            if(map.containsKey(rem)) {
                final var index = map.get(rem);
                maxLen = Math.max(maxLen, i - index);
            }

            //we need to add element only when that sum is not existed previously
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int lenOfLongestSubArrTwoPointerApproach(int[] arr, int k) {
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (i < arr.length) {
            if(sum > k) {
                sum = sum - arr[j];
                j++;
            } else {
                if(sum == k) {
                    maxLen = Math.max(i - j, maxLen);
                }
                sum += arr[i];
                i++;

            }

        }

        return maxLen;
    }
}
