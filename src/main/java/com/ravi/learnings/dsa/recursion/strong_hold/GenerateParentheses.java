package com.ravi.learnings.dsa.recursion.strong_hold;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/description/">Problem Link</a>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        final var strings = new ArrayList<String>();
        aa(n, "", 0, 0, strings);
        return strings;
    }

    public static void aa(int n, String s, int open, int closed, List<String> list) {
        //Base case when there are n open and n closed parentheses then we need to add that in list
        if (open == n && closed == n) {
            list.add(s);
        }

        if (open > n) {
            return;
        }

        aa(n, s + "(", open + 1, closed, list);

        // Closed bracket only possible when there are open bracket and open bracket are greater that closed
        if (closed < open) {
            aa(n, s + ")", open, closed + 1, list);
        }
    }
}
