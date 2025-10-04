package com.ravi.learnings.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {
    /*
        {64, 25, 12, 22, 11}
    *   In insertion sort we will select a part of array we will first select [64] check if all elements are
        at correct position if not then put it on correct position

        Then we select [64, 25] and select 1st index and check if it is at correct position if not then put it
        on correct position: result will be [25, 64, 12, 22, 11]

        then we will select [25, 64, 12] check if 12 is at correct position if not put it on correct
        position result will: [12, 25, 64, 22, 11]

        then select: [12, 25, 64, 22] and pick 22 put it on right place result: [12, 22,  25, 64, 11]

        Note: we will pick an item and swap it to left till we didn't find element sorter than current element
    */

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        //        insertionSort(arr, 5);
        //        striverInsertionSort(arr, 5);
        recursiveInsertionSort(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void striverInsertionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    private static void recursiveInsertionSort(int[] arr, int from) {
        if (from >= arr.length)
            return;

        int j = from;
        while (j > 0 && arr[j] < arr[j - 1]) {
            swap(arr, j, j - 1);
            j--;
        }

        recursiveInsertionSort(arr, from + 1);
    }

    private static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
