package com.test.dsa.recursion.hard;

import com.test.dsa.linkedList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s partition string s such that every substring of partition is palindrome.
 * Return all possible palindrome partition of string s.
 * <p>
 * Input : s = "aabaa"
 * <p>
 * Output : [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , [ "a", "aba", "a"] , [ "aa", "b", "a", "a"] ,
 * [ "aa", "b", "aa" ] , [ "aabaa" ] ]
 * <p>
 * Explanation : Above all are the possible ways in which the string can be partitioned so that each substring is a
 * palindrome.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        final var aab = partition("aab");
        //        System.out.println(isPalindromeStr("aabbaa"));

        System.out.println(aab);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> l2 = new ArrayList<>();
        myFunc(s, 0, new ArrayList<>(), l2);

        return l2;
    }

    private static void myFunc(String s, int idx, List<String> palindrome, List<List<String>> ans) {
        if (s.length() == idx) {
            ans.add(new ArrayList<>(palindrome));
        }

        for (int i = idx + 1; i <= s.length(); i++) {
            final var substring = s.substring(idx, i);

            if (isPalindromeStr(substring)) {
                palindrome.add(s.substring(idx, i));
                myFunc(s, idx + 1, palindrome, ans);
                palindrome.removeLast();
            }
        }
    }

    private static boolean isPalindromeStr(final String str) {

        if (str.length() == 1) {
            return true;
        }
        int start = 0;
        int end = str.length() - 1;
        while (end > start) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
