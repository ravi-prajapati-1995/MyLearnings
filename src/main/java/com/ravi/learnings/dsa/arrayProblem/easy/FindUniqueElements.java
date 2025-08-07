package com.ravi.learnings.dsa.arrayProblem.easy;

import java.util.Arrays;

public class FindUniqueElements {
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 2, 3};
        int count = getUniqueElementsCount(arr);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }

    private static int getUniqueElementsCount(int[] arr) {
        int currentItem = arr[0];
        int idx = 1;
        int result[] = new int[arr.length];
        result[0] = currentItem;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != currentItem) {
                currentItem = arr[i];
                result[idx] = currentItem;
                idx++;
            }
        }

        for (int i = 0; i < idx; i++) {
            arr[i] = result[i];
        }

        return idx;
    }
}
