package com.ravi.learnings.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {

    /*
     *	Bubble sort: Push maximum to the last by adjacent compare
     * 		In this we will compare adjacent numbers if they are in order then do nothing
     * 		If they are not swap
     * 		In first iteration we will compare 64 and 25 and swap them,
     * 		then in same iteration 25 will be on 0 and 64 will be on 1
     * 		then compare 64 with 2nd idx 12 then again swap it
     * 		then compare 64 with 3rd idx 22 then again swap it
     * 		In this way when first iteration is completed we will get greatest element in last
     */
    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        //		bubbleSort(arr, 5);
        bubbleSortRecursive(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortRecursive(int[] arr, int to) {

        if (to == 1) {
            return;
        }

        for (int j = 0; j < to; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        bubbleSortRecursive(arr, to - 1);
    }
}
