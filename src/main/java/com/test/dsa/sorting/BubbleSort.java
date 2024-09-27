package com.test.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {

	/*
	*	Bubble sort: Push maximum to the last by adjacent compare
	* 		In this we will compare adjacent numbers if they are in order then do nothing
	* 		If they are not swap
	*/
	public static void main(String[] args) {
		int arr[] = {64, 25, 12, 22, 11};
		bubbleSort(arr, 5);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int arr[], int n) {
		for(int i =1; i < n-1; i++ ) {
			for (int j = 0; j < n - i -1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
