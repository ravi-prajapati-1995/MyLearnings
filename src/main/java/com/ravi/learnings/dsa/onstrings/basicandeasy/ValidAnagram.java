package com.ravi.learnings.dsa.onstrings.basicandeasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    /*
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.
     * */
    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }

    /*
    * We are keep tracking of all the characters present in the strings and the storing it in map
    * in last checking if both maps are equals
    * */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            final var c1 = s.charAt(i);
            final var c2 = t.charAt(i);
            if(!map1.containsKey(c1)) {
                map1.put(c1, 1);
            } else {
                map1.computeIfPresent(c1, (a, b) -> b + 1);
            }

            if(!map2.containsKey(c2)) {
                map2.put(c2, 1);
            } else {
                map2.computeIfPresent(c2, (a, b) -> b + 1);
            }
        }

        return map1.equals(map2);
    }

    /**
     * We can sort both the string and then compare strings if bot are same then they are anagram
     * */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        final var charArray = s.toCharArray();
        Arrays.sort(charArray);
        final var charArray1 = t.toCharArray();
        Arrays.sort(charArray1);
        return Arrays.equals(charArray, charArray1);
    }
}
