package com.test.dsa.sorting;

import java.util.Arrays;

import static com.test.dsa.sorting.InsertionSort.swap;

public class QuickSort {
    /*
        1. Select the pivot in our example we are taking pivot 1st element.
        2. take two pointers i from left, j from right
        3. From left find element which is greater than pivot
        4. From right find element which is smaller than pivot
     */
    public static void main(String[] args) {
        int[] arr = {24, 18, 38, 43, 14, 40, 1, 54}; //3, 5, 6, 9, 2, 11, 7

        sortArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(final int[] arr, int low , final int high) {
        System.out.println(low+"\t"+high);
       if(low < high) {
           int partitionIndex = fun(arr, low, high);
           sortArray(arr, low, partitionIndex - 1);
           sortArray(arr, partitionIndex + 1, high);
       }
    }

    private static int fun(final int[] arr, final int low, final int high) {
        int pivot = arr[low];
        int i = low ;
        int j = high;

        while (i < j) {
            while(arr[i] <= pivot && i < high) {
                i++;
            }

            while(arr[j] > pivot && j > low) {
                j--;
            }

            if(i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        System.out.println(Arrays.toString(arr));
        return j;
    }
}
