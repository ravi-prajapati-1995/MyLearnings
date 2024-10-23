package com.test.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

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

	private static void sortArray(final int[] arr, int from, final int to) {
		if(from == to) {
			return;
		}

		int mid = (to + from) / 2;

		sortArray(arr, from, mid);
		sortArray(arr, mid + 1, to);
		mergeArray(arr, from, mid,  to);
	}

	private static void mergeArray(final int[] arr, final int low, final int mid, final int high) {
		final var list = new ArrayList<Integer>(high - low);
		int left = low;
		int right = mid +1;
		while(left <= mid && right <= high) {
			if(arr[left] <= arr[right]) {
				list.add(arr[left]);
				left++;
			} else {
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
//		System.out.println(list);

		for(int i=low; i<=high; i++) {
			arr[i] = list.get(i - low);
		}

	}


}
