package com.ravi.learnings.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	/**
	* This algo is based on <b>Divide and merge
	 * arr = [3, 5, 6, 9, 2, 11, 5], n=7
	 * we will divide array into two parts
	 * left part 4 : [3, 5, 6, 9] elements And right part 3: [2, 11, 5] elements
	 * Take left part: [3, 5, 6, 9] and then divide it again into two part
	 * left part: 2 elements: [3, 5] Right part 2 elements: [6, 9]
	 * We will do this till we get only one element after that we will do same for right part
	 * After this step we will merge both arrays like if we traverse left part then in last we will have [3] and [5]
	 * For merge we will take list and two pointer 1st points to left start point and second points to right start point
	 * we iterate this and compare elements and add in list
	 * there may be case when left side there will be some element or may be in left side
	 * Those elements will be the larger and we will add them in list directly
	 * After that we will replace these values in array according to index we are merging array
	* */
	public static void main(String[] args) {
		int arr[] = {1 ,3, 9, 7}; //3, 5, 6, 9, 2, 11, 7
		int n = 4;

        sortArray(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static void sortArray(final int[] arr, int low , final int high) {
        int mid = (low + high)/2;

        if (low  == high) {
            return;
        }
        // Sort left part
        sortArray(arr, low, mid);

        // Sort right part
        sortArray(arr, mid + 1, high);

        // Merge Left and Right
        mergeArray(arr, low, mid, high);
    }

    private static void mergeArray(final int[] arr,  int low, final int mid,  int high) {
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid+1;
        /*
        * Took two pointer lets suppose we have:
        * [18, 24, 38, 43] from low to mid and [1, 14, 40]
        *
        * We arr looping here till our left pointer reaches mid or our right pointer reaches to high
        * And storing value in temporary list according to ascending order
        * */
        while(left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }

        //In case while loop completed and we have elements in left side so adding them
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }

        // If we have elements left in right side, only one will be executed at a time
        while(right <= high) {
            list.add(arr[right]);
            right++;
        }
//		System.out.println(list);

		for(int i=low; i<=high; i++) {
			arr[i] = list.get(i - low);
		}

        // adding back those value to original array
        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
//        System.out.println(list);
    }


}
