package com.test.dsa.onstrings.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/sum-of-beauty-of-all-substrings/">Problem</a>
 * The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
 *
 * For example, the beauty of "abaacc" is 3 - 1 = 2.
 * Given a string s, return the sum of beauty of all of its substrings.
 *
 * Input: s = "aabcb"
 * Output: 5
 * Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
 */
public class BeautySum {

    public static void main(String[] args) {
        System.out.println(beautySumBetter("aabcbaa"));
    }

    /**
     * We are doing N^3 iterations in brute force solution we try to do it in O(n^2) * 26
     * @param s
     * @return
     */
    public static int beautySumBetter(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            int chars[] = new int[26];
            for (int j = i; j < s.length(); j++) {
                int pos = s.charAt(j) - 'a';
                chars[pos]++;
                int sum = getMaxCount(chars)  - getMinCount(chars);
                result += sum;
            }
        }
        return result;
    }

    private static int getMaxCount(final int[] chars) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(chars[i], max);
        }
        return max;
    }

    private static int getMinCount(final int[] chars) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if(chars[i] != 0) {
                min = Math.min(chars[i], min);
            }
        }
        return min;
    }

    /**
     * This is brute force technique which has TC - O(n^3) -> We are creating each possible substring and then for each
     * substring we are getting beauty number
     * */
    public static int beautySum(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int sum = getBeautySum(s, i, j);
                result += sum;
            }
        }
        return result;
    }

    private static int getBeautySum(final String s, final int i, final int j) {
        Map<Character, Integer> map = new HashMap<>();
        for (int x = i; x <= j; x++) {
            map.put(s.charAt(x), map.getOrDefault(s.charAt(x), 0) + 1);
        }

        final var list = map.values().stream().sorted().toList();
        return list.getLast() - list.getFirst();
    }
}
