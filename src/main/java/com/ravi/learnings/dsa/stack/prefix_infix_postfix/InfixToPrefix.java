package com.ravi.learnings.dsa.stack.prefix_infix_postfix;

import java.util.List;
import java.util.Stack;

/**
 * Video Link: <a href="https://youtu.be/4pIc9UBHJtk?si=pTxB3cva1rFXFzMw&t=1001">Video Link</a>
 * To change InfixToPrefix we will follow the following steps:
 * 1. Reverse the Infix
 * 2. Infix 2 Postfix -- With conditional changes
 * 3. Reverse that answer
 * Example: (a+b)*c-d+f
 * 1. Reverse: f+d-c*)b+a( -- After reversing make the opening bracket to closing bracket and closing bracket to
 * opening bracket
 * In control conversion :
 * For ^ we will pop out all the operator which has <= priority than the ^
 * for other operator we pop out all operator which has < priority than the current stack element
 */
public class InfixToPrefix {
    public static void main(String[] args) {
        System.out.println(infixToPrefix("a+b*(c^d-e)^(f+g*h)-i"));
    }

    public static String infixToPrefix(String s) {
        // Reversed the given String
        var reversed = getReversed(s);
        char[] charArray;

        System.out.println(reversed);
        final var string = reversed.toString();
        // Replacing ( with ) and ) with (
        final var replace = string.replace("(", "#").replace(")", "@");
        final var replace1 = replace.replace("#", ")").replace("@", "(");
        System.out.println(replace1);

        Stack<Character> st = new Stack<>();
        charArray = replace1.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char ch : charArray) {
            if (isOperand(ch)) {
                res.append(ch);
            } else {
                if (ch == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        res.append(st.pop());
                    }
                    st.pop();
                } else if (ch == '^') { // In case of ^ we will get all the operator which has less priority than
                    // this: Control conversion
                    while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                        res.append(st.pop());
                    }

                    st.push(ch);
                } else if (ch == '(') {
                    st.push(ch);
                } else { // When I got operator other than ^ or got opening bracket
                    while (!st.isEmpty() && priority(ch) < priority(st.peek())) {
                        res.append(st.pop());
                    }

                    st.push(ch);
                }
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return getReversed(res.toString()).toString();
    }

    private static StringBuilder getReversed(final String s) {
        StringBuilder reversed = new StringBuilder();
        int size = s.length();
        char[] charArray = s.toCharArray();
        for (int i = size - 1; i >= 0; i--) {
            reversed.append(charArray[i]);
        }
        return reversed;
    }

    private static boolean isOperand(final char ch) {
        final var characters = List.of('+', '-', '*', '(', '^', ')', '/');
        return !characters.contains(ch);
    }

    private static int priority(final char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '/' || ch == '*') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }

        return 0;
    }
}
