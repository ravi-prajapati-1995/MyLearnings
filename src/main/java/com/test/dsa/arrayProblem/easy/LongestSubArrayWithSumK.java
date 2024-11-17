package com.test.dsa.arrayProblem.easy;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int arr[] = {1, -1, 5, -2, 3};
        int i = lenOfLongestSubarr(arr, 3);
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
}
