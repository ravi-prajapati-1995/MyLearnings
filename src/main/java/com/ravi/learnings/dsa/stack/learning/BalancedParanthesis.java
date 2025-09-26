package com.ravi.learnings.dsa.stack.learning;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/description/">Problem Link</a></br>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class BalancedParanthesis {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));

    }


    /**
     * below logic will not work for String: ([)]
     * */
    public static boolean isValid(String s) {
        final var charArray = s.toCharArray();
        int small = 0;
        int med = 0;
        int large = 0;

        for (char c : charArray) {
            switch (c) {
                case '(':
                    small++;
                    break;
                case ')':
                    small--;
                    break;
                case '{':
                    med++;
                    break;
                case '}':
                    med--;
                    break;
                case '[':
                    large++;
                    break;
                case ']':
                    large--;
                    break;
            }
        }
        return small == 0 && med == 0 && large == 0;
    }
}
