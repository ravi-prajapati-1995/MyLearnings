package com.ravi.learnings.dsa.onstrings.basicandeasy;

import java.util.HashMap;

public class isIsomorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    /**
     * Given two strings s and t, determine if they are isomorphic.
     *
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     *
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character, but a character may map to itself.
     * */
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> m1 = new HashMap();
        HashMap<Character, Integer> m2 = new HashMap();
        final var sCharArray = s.toCharArray();
        final var tCharArray = t.toCharArray();
//"bbbaaaba", "aaabbbba"
        for (int i = 0; i < s.length(); i++) {

            if (!m1.containsKey(sCharArray[i])) {
                m1.put(sCharArray[i], i);
            }

            if (!m2.containsKey(tCharArray[i])) {
                m2.put(tCharArray[i], i);
            }

            if(m1.get(sCharArray[i]) != m2.get(tCharArray[i])) {
                return false;
            }
        }

        return true;
    }
}
