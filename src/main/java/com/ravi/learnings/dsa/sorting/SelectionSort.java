package com.ravi.learnings.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    /*
     * In selection sort we will select element like arr[0] --> 64 in our case
     * 		in first iteration we will compare it with adjacent elements like arr[1], arr[2], arr[3 and so on
     * 		we will keep minIdx variable which will have minimum number when first iteration completed we will have the smallest number
     * 		we will compare arr[0] if this element is greater than other element then we will
     * 		After executing first iteration we will get the smallest element in first place
     * 		In second iteration we will start from index 1 as 0 is already sorted and so on
     */
    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        striverMethodSort(arr, 5);
    }

    static void striverMethodSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swapNumbers(minIdx, i, arr);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void swapNumbers(int i, int j, final int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int select(int arr[], int i) {
        // code here such that selectionSort() sorts arr[]
        int minimum = arr[i];
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < minimum) {
                int temp = arr[j];
                arr[j] = minimum;
                arr[i] = temp;
                minimum = temp;
            }
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("----------------------------------------------");
        return 1;
    }

    static void selectionSort(int arr[], int n) {
        //code here
        for (int i = 0; i < n; i++) {
            select(arr, i);
            System.out.println(Arrays.toString(arr));
        }
    }
}
