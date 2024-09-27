package com.test.features;

public class sortedArrayFirstAndLastOccurrence {
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7, 7, 7};

		findOccurrence(arr, 7);
	}

	private static void findOccurrence(final int[] arr, int number) {
		int half = arr.length / 2 -1;
		int firstIndex = -1;
		int lastIndex = -1;
		final var centerNumber = arr[half];
		if(centerNumber == number) {

			firstIndex = half;
			lastIndex = half;
			for (int i = half; i >= 0; i--) {
				//first got to left side to check first occurrence
				if(arr[i] == number) {
					firstIndex = i;
				} if(arr[i] < number) {
					break;
				}
			}

			for (int i = half; i < arr.length; i++) {
				//first got to left side to check first occurrence
				if(arr[i] == number) {
					lastIndex = i;
				} if(arr[i] > number) {
					break;
				}
			}
		} else if(centerNumber < number) {
			//search right
			for (int i = half; i < arr.length; i++) {
				if (arr[i] == number) {
					if (firstIndex == -1) {
						firstIndex = i;
						lastIndex = i;
					} else {
						lastIndex = i;
					}
				} else if(arr[i] > number) {
					break;
				}
			}

			System.out.println(firstIndex + "\t"+ lastIndex);
		} else {
			//search left
			for (int i = half; i >= 0; i--) {
				if (arr[i] == number) {
					if (firstIndex == -1) {
						firstIndex = i;
						lastIndex = i;
					} else {
						lastIndex = i;
					}
				} else if(arr[i] > number) {
					break;
				}
			}
		}

		System.out.println(firstIndex + "\t" + lastIndex);
	}
}
