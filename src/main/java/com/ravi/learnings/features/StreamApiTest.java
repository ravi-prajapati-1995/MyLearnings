package com.ravi.learnings.features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamApiTest {
    public static void main(String[] args) {
//		reduceExample();
//		final var intStream = IntStream.of(1, 2, 1, 1, 1, 1);
//		final var reduce = intStream.map(i -> i * 3).reduce(0, Integer::sum);
//		System.out.println(reduce);
        filterExample();
    }

    private static void filterExample() {
        final var list = List.of(1, 3, 4, 5, 6, 7, 8);
        final var integers = List.of(1, 6, 8);
        final var filteredResult = list.stream().filter(i -> i == 3).toList();
        System.out.println(filteredResult);

        final var list1 = list.stream().filter(integers::contains).toList();
        System.out.println(list1);
    }

    private static void reduceExample() {
        IntStream range = IntStream.range(-100, 101);
        System.out.println(Arrays.toString(range.toArray()));
        final var intStream = IntStream.of(1, 2, 1, 1, 1, 1);
        final var reduce = intStream.reduce(1, (sum, curr) -> {
            System.out.println(sum + "\t" + curr);
            return sum * curr;
        });
        System.out.println(reduce);
    }
}
