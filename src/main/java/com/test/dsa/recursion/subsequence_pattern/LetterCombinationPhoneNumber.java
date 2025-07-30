package com.test.dsa.recursion.subsequence_pattern;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">Problem Link</a>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * Input: digits = ""
 * Output: []
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * */
public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        final var strings = new ArrayList<String>();
//        myFunction(strings, digits);
        return null;
    }


    private static void myFunction(final ArrayList<String> strings, final String digits, int count) {
        
    }

    private static Map<Integer, List<Character>> getNumberCharMap() {
        Map<Integer, List<Character>> keypadMap = new HashMap<>();
        keypadMap.put(2, asList('a', 'b', 'c'));
        keypadMap.put(3, asList('d', 'e', 'f'));
        keypadMap.put(4, asList('g', 'h', 'i'));
        keypadMap.put(5, asList('j', 'k', 'l'));
        keypadMap.put(6, asList('m', 'n', 'o'));
        keypadMap.put(7, asList('p', 'q', 'r', 's'));
        keypadMap.put(8, asList('t', 'u', 'v'));
        keypadMap.put(9, asList('w', 'x', 'y', 'z'));

        return keypadMap;
    }
}
