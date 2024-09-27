package com.test.dsa.hashing;

public class NumberOfOccurrenceBuretForce {
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 1, 2, 1, 4, 1};
		var counter = getCounter(a, 10);
		System.out.println(counter);
		System.out.println(getCounter(a, 1));
	}

	private static int getCounter(final int[] a, final int numberToFind) {
		int counter = 0;

		for (final int j : a) {
			if (j == numberToFind) {
				counter++;
			}
		}
		return counter;
	}
}
