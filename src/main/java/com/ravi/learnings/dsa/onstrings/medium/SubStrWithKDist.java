package com.ravi.learnings.dsa.onstrings.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * [TODO] Need to revisit
 * <a href="https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1">Problem</a>
 * <p>
 * Given a string s of lowercase alphabets, count all possible substrings (not necessarily distinct)
 * that have exactly k distinct characters.
 * <p>
 * Input: s = "aba", k = 2
 * Output: 3
 * Explanation: The substrings are: "ab", "ba" and "aba".
 */
public class SubStrWithKDist {

    public static void main(String[] args) {
        System.out.println(countSubstrOptimal("abaaca", 2));
    }

    /**
     * Optimizing using sliding window and two pointer approach
     * take l and r variable and start them with 0
     * with each iteration add char in set and check count
     * if count is < k then increase r
     * if count is equal to k then increase r and count
     * if count is greater than k than increase l
     */
    static int countSubstrOptimal(String s, int k) {
        // if k is less than 0, return 0
        if (k < 0)
            return 0;

        // initialize variables
        int left = 0;
        int right = 0;
        int cnt = 0;
        int res = 0;
        int[] charArray = new int[26];

        // loop until the end of the string
        while (right < s.length()) {
            // increment frequency of current character
            charArray[(s.charAt(right) - 'a')]++;

            // if frequency becomes 1, increase the count
            if (charArray[(s.charAt(right) - 'a')] == 1)
                cnt++;

            // while the count is greater than k
            while (cnt > k) {
                // decrement frequency of character at start index
                final var position = s.charAt(left) - 'a';
                charArray[position]--;

                // if frequency becomes 0, decrease the count
                if (charArray[position] == 0)
                    cnt--;

                // move the start index to the right
                left++;
            }

            // calculate the number of substrings with at most k distinct characters
            res += (right - left + 1);
            // move the end index to the right
            right++;
        }
        // return the result
        return res;
    }

    /*
     * Brute  force approach
     * */
    static int countSubstr(String s, int k) {
        int count = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < length; j++) {
                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }

                if (map.size() == k) {
                    count++;
                    //                    System.out.println(map.keySet());
                } else if (map.size() > k) {
                    break;
                }
            }
        }

        return count;
    }
}
