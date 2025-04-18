package com.test.dsa.hashing;

import java.util.Arrays;

public class NumberOfOccurrenceHashinArray {
	public static void main(String[] args) {

		int a[] = {1, 2, 3, 4, 1, 2, 1, 4, 1};
		//Pre calculate array using empty array from 0-20 index and put number and increase while we get number
		int preCalculate[] = new int[20];

		preCalculate(preCalculate, a);
		System.out.println(Arrays.toString(preCalculate));

		var counter = preCalculate[1];
		System.out.println(counter);
	}

	private static void preCalculate(final int[] preCalculate, final int[] a) {
		for(int i = 0; i < a.length; i++) {
			preCalculate[a[i]] = preCalculate[a[i]] + 1;
		}
	}
}
