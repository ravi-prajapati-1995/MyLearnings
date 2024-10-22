package com.test.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
	/**
	* This algo is based on <b>Divide and merge</b><br/>
	 * arr = [3, 5, 6, 9, 2, 11, 5], n=7 <br/>
	 * we will divide array into two parts left part 4 : [3, 5, 6, 9] elements and right part 3: [2, 11, 5] elements
	 * Take left part: [3, 5, 6, 9] and then divide it again into two part left part: 2 elements: [3, 5]
	 * Right part 2 elements: [6, 9]
	* */
	public static void main(String[] args) {
		int arr[] = {3, 5, 6, 9, 2, 11, 5};
		int n = 7;

		sortArray(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortArray(final int[] arr, int from, final int to) {
		if(from >= to) {
			return;
		}

		int mid = (to + from) / 2;

		sortArray(arr, from, mid);
		sortArray(arr, mid + 1, to);
		mergeArray(arr, from, mid,  to);
	}

	private static void mergeArray(final int[] arr, final int low, final int mid, final int high) {
		final var list = new ArrayList<Integer>(arr.length);
		int left = low;
		int right = mid +1;
		while(left <= mid && right <= high) {
			if(arr[left] < arr[right]) {
				list.add(arr[left]);
				left++;
			} else if(arr[right] < arr[left]) {
				list.add(arr[right]);
				right++;
			}
		}

		while(left <= mid) {
			list.add(arr[left]);
			left++;
		}

		while(right <= high) {
			list.add(arr[right]);
			right++;
		}

	}


}
