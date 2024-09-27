package com.test.dsa.hashing;

import java.util.Arrays;

public class NumberOfOccurrenceOfChar {
	//a = 97, z=122
	public static void main(String[] args) {
		char[] chars = "aaabbbccdeffaaghhiijjjaeiqerqoiwurasdlfjalvkmalsjasflkjsdlfjasdlnkmsalsfjaslasfl".toCharArray();

		//0 = 97, 1 = 98, ... so on
//		int[] preProcessed = new int[26];
//		for(int i = 0; i < chars.length; i++) {
//			final int aChar = chars[i];
//			preProcessed[aChar - 'a']++;
//		}
//
//		System.out.println(getCounts(preProcessed, 'f'));

		final var arr = new int[]{3 ,3 , 3 , 3};
		frequencyCount(arr, 4, 3);
		System.out.println(Arrays.toString(arr));
	}

	private static int getCounts(final int[] preProcessed, final char a) {
		return preProcessed[a - 97];
	}

	public static void frequencyCount(int arr[], int n, int p) {
		// do modify in the given array
		int[] preCompute = new int[p+1];
		for(int i = 0; i < n; i++ ){
			preCompute[arr[i] -1]++;
		}
		// System.out.println(Arrays.toString(preCompute));

		for(int i = 0; i < n; i++) {
			if( i < p) {
				arr[i] = preCompute[i];
			} else {
				arr[i] = 0;
			}
		}

	}
}
