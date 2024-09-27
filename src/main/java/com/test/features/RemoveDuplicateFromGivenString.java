package com.test.features;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicateFromGivenString {
	public static void main(String[] args) {
		String str = "ravi kumar";
		System.out.println(new Date().toInstant());
		usingSimpleLoop(str);
		System.out.println(new Date().toInstant());
		usingStreamApi(str);
		System.out.println(new Date().toInstant());
	}

	private static void usingSimpleLoop(final String str) {
		final var split = str.split("");

		StringBuilder result = new StringBuilder();
		final var strings = new Hashtable<String, Integer>(str.length());

		for(String st: split) {
			if(!strings.containsKey(st)) {
				result.append(st);
				strings.put(st, 1);
			}
		}
		System.out.println(result);
	}

	private static void usingStreamApi(final String str) {
		final var collect = Stream.of(str.split(""))
				.collect(Collectors.toCollection(LinkedHashSet::new))
				.stream()
				.map(StringBuffer::new)
				.reduce(new StringBuffer(), StringBuffer::append);

		System.out.println(collect);
	}
}
