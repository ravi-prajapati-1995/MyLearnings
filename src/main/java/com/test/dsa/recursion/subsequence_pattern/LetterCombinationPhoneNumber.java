package com.test.dsa.recursion.subsequence_pattern;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">Problem Link</a>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * Input: digits = ""
 * Output: []
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        final var strings = new ArrayList<String>();
        final var numberCharMap = getNumberCharMap();
        myFunction(strings, digits, 0, numberCharMap, "");
        return null;
    }

    /**
     * To solve this problem followed below :
     * 1. Create a map that will have characters corresponding to number
     * 2. Then for each character on that number call recursively this function i.e 23
     *  While for 0th idx process for 2 -> we can have a, b, c so we will process for all chars separately to get all
     *  the combinations then increase the idx so we reach with a -> (def) and for b and c also
     *  3. Base case when idx become equal to the length of string mean we processed all the string
     *  4. if string is empty return empty list.
     *
     *  TC -> O(4^N * N) -> As for each number in wrost case we have 4 characters so we call recursion 4 times * N
     *  for each time processing
     *  SC -> O(N) for storing the result
     */
    private static void myFunction(
            List<String> strings, final String digits, int idx,
            Map<Integer, List<String>> numberCharMap, String str
    ) {

        if (digits.isEmpty()) {
            return;
        }

        if (digits.length() == idx) {
            strings.add(str);
            return;
        }

        final var number = digits.charAt(idx) - '0';
        final var characters = numberCharMap.get(number);
        for (String c : characters) {
            myFunction(strings, digits, idx + 1, numberCharMap, str + c);
        }
    }

    private static Map<Integer, List<String>> getNumberCharMap() {
        Map<Integer, List<String>> keypadMap = new HashMap<>();
        keypadMap.put(2, Arrays.asList("a", "b", "c"));
        keypadMap.put(3, Arrays.asList("d", "e", "f"));
        keypadMap.put(4, Arrays.asList("g", "h", "i"));
        keypadMap.put(5, Arrays.asList("j", "k", "l"));
        keypadMap.put(6, Arrays.asList("m", "n", "o"));
        keypadMap.put(7, Arrays.asList("p", "q", "r", "s"));
        keypadMap.put(8, Arrays.asList("t", "u", "v"));
        keypadMap.put(9, Arrays.asList("w", "x", "y", "z"));
        return keypadMap;
    }
}
