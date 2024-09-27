package com.test.features;

import java.util.stream.IntStream;

public class StreamApiTest {
	public static void main(String[] args) {
//		reduceExample();
		final var intStream = IntStream.of(1, 2, 1, 1, 1, 1);
		final var reduce = intStream.map(i -> i * 3).reduce(0, Integer::sum);
		System.out.println(reduce);
	}


	private static void reduceExample() {
		final var intStream = IntStream.of(1, 2, 1, 1, 1, 1);
		final var reduce = intStream.reduce(1, (sum, curr) -> {
			System.out.println(sum + "\t" + curr);
			return sum*curr;
		});
		System.out.println(reduce);
	}
}
