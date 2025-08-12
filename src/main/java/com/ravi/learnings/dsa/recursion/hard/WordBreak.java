package com.ravi.learnings.dsa.recursion.hard;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/word-break/description/">Problem Link</a><br/>
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
public class WordBreak {

    public static void main(String[] args) {
        //        final var wordBreak = wordBreak1("cars", List.of("car","ca","rs"));
        final var wordBreak = wordBreak2("cbca", List.of("bc","ca"), 0);
        System.out.println(wordBreak);
    }

    /**
     * In this solution for each word we check if that is exists in the given list of wordDict
     * in case we found first N characters in the wordDict then we start looking for n+1 till the length of the
     * given string s
     * <p>
     * This approaches fail for test case: s = "aaaaaaa" wordDict: ["aaaa","aaa"]
     * As we are appending each char in str so once we reach with aaa and after that aaa then we reset string and single
     * a is remaining and it returns false
     * <p>
     * Do it yourself if you have doubt
     */
    public static boolean wordBreakBruteForce(String s, List<String> wordDict) {
        int start = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str = str + s.charAt(i);

            if (wordDict.contains(str)) {
                start = i;
                str = "";
            }
        }
        return s.length() - 1 == start;
    }

    /**
     * In this approach instead of adding char one by one and checking if it is present we will check if word dict
     * below logic failed for: s = "cars" wordDict: ["car","ca","rs"]
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        String str = s;
        for (String word : wordDict) {
            if (str.contains(word)) {
                str = str.replace(word, " ");
            }
        }
        return str.trim().isEmpty();
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        final var size = wordDict.size();

        for (int i = 0; i < size; i++) {
            String str = s;
            for (int j = i; j < size; j++) {
                final var s1 = wordDict.get(j);
                if (str.contains(s1)) {
                    str = str.replace(s1, "");
                }

                if (str.trim().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * For each word dict we will make a dicision if we can create word break with current choice
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak2(String s, List<String> wordDict, int idx) {
       if(idx == s.length()) {
           return true;
       }
        String st = "";
        boolean result = false;
        for (int i = idx; i < s.length(); i++) {
            st += s.charAt(i);
            if (wordDict.contains(st)) {
                result = result || wordBreak2(s, wordDict, i + 1);
            }
        }
        return result;
    }
}
