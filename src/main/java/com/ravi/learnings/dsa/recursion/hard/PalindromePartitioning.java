package com.ravi.learnings.dsa.recursion.hard;

import java.util.ArrayList;
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
        final var aab = partition("aabaa");
        System.out.println(aab);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> l2 = new ArrayList<>();
        striverSolution(s, 0, new ArrayList<>(), l2);

        return l2;
    }

    /**
     * Steps I have followed before see the solution:
     * 1. Start with 0 index and initiate start point with idx + 1
     * 2. Then start a loop that will run from next index till the last index
     * i.e idx = 0  and i=1 first time then till the last index in last we will have whole string as substring
     * 3. for each element we will recursivly call func for next idx if till current position string is palindrome
     * 4. In base condition if we reach at the end while doing operation then all the string in this node are
     * palindrome and storing them in new list for resulting
     * <p>
     * TC - O(lengthOfString ^ n) * N for each operation
     */
    private static void myFunc(String s, int idx, List<String> palindrome, List<List<String>> ans) {
        if (s.length() == idx) {
            ans.add(new ArrayList<>(palindrome));
        }

        int start = idx + 1;
        for (int i = start; i <= s.length(); i++) {
            final var substring = s.substring(idx, i);

            if (isPalindromeStr(substring)) {
                palindrome.add(s.substring(idx, i));
                myFunc(s, i, palindrome, ans);
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

    private static void striverSolution(String str, int idx, List<String> list, List<List<String>> st) {
        if (str.length() == idx) {
            st.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i <= str.length() - 1; i++) {
            // here we are checking for 0 to 0 but below we are taking i+1 why???
            if (checkPalindrome(str, idx, i)) {
                String subStr = str.substring(idx, i + 1);
                list.add(subStr);
                striverSolution(str, i + 1, list, st);
                list.removeLast();
            }
        }
    }

    /*
     * To check the palindrome we took 2 pointer approach take each string from left and right if they are not equal
     * then return false
     * */
    private static boolean checkPalindrome(final String str, int left, int right) {
        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
