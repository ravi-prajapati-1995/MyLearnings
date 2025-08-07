package com.ravi.learnings.dsa.onstrings.basicandeasy;

/**
 * <a href="https://leetcode.com/problems/remove-outermost-parentheses/description/">Problem</a>
 * Given a string with brackets: (()(())
 *
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 * */
public class RemoveOuterParentheses {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }


    public static String removeOuterParentheses(String s) {
        int counter = 0;
        int from = 0;
        int to = 0;
        StringBuilder result = new StringBuilder();

        for(char c: s.toCharArray()) {
            to++;
            if(c == '(') {
                counter++;
            } else if(c == ')'){
                counter--;
            }

            if(counter == 0) {
                final var substring = s.substring(from + 1, to - 1);
                result.append(substring);
                from = to;
            }
        }
        return result.toString();
    }
}
