package com.test.dsa.recursion;

import java.util.Arrays;

public class ReverseArrayRemoveExtraVariable {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		reverse(arr, 0);
		System.out.println(Arrays.toString(arr));
	}

	private static void reverse(int [] arr, int first){
		int last = arr.length - 1 -first;
		if(first >= last) {
			return;
		}
		swap(arr, first, last);
		reverse(arr, first+1);
	}

	private static void swap(final int[] arr, final int first, final int last) {
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}
}
