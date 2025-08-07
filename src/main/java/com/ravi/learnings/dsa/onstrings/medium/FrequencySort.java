package com.ravi.learnings.dsa.onstrings.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 * */
public class FrequencySort {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static  String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        final var list = map.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).toList();

        StringBuilder ans = new StringBuilder();
        for (var entry : list) {
            final var key = entry.getKey();
            ans.append(String.valueOf(key).repeat(entry.getValue()));
        }

        return ans.toString();
    }
}
