package com.ravi.learnings.dsa.onstrings.medium;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">problem</a>
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * A string is palindromic if it reads the same forward and backward.
 */
public class LongestPalindromicString {
    public static void main(String[] args) {
        System.out.println(longestPalindromeOptimal("abcba"));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1)
            return false;

        int left = 0;
        int right = s.length() - 1;
        final var charArray = s.toCharArray();
        while (left <= right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Time complexity for brute force is O(n^3) we are having two loops to go through every character and length
     * and inner loop for checking if substring is palindrome
     */
    public static String longestPalindrome(String s) {
        int max = 0;
        String resultStr = "";

        for (int i = 0; i <= s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {
                final var substring = s.substring(i, j);
                if (isPalindrome(substring)) {
                    System.out.println(substring);
                    if (max < (j - i + 1)) {
                        max = j - i + 1;
                        resultStr = substring;
                    }
                }
            }
        }
        return resultStr;
    }

    /**
     * In this approach we are doing this in O(n^2)
     * abcba ->  Palindrome will be all string (Odd Case)
     * abbc  ->  Palindrome will be (Even case)
     * <p>
     * Question: why we are couting for even and odd
     * Ans: Suppose we have only
     */
    public static String longestPalindromeOptimal(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            final var even = expandAroundCenter(s, i, i);
            final var odd = expandAroundCenter(s, i, i + 1);

            final var maxLen = Math.max(even, odd);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * We will give left and right to this function and this function will return number of characters that made
     * palindrome
     * i.e if string is: nitin and we gave left = 2 and right=2 it start from index 2 and expending around 2 till either
     * cross string boundaries
     */
    private static int expandAroundCenter(final String s, int left, int right) {
        while (left >= 0 && right <= s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
            } else {
                break;
            }
        }

        return right - left - 1;
    }
}
