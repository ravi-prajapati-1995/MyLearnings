package com.ravi.learnings.dsa.stack.prefix_infix_postfix;

import java.util.List;
import java.util.Stack;

/**
 * Problem Link: https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion/1
 * Video Link: https://youtu.be/4pIc9UBHJtk?si=G93OXXhErNw_Pn4D
 * To solve we will follow the below steps:
 * 1. Traverse from Left to Right
 * 2. When get operand add to stacck
 * 3. When get operator pick top two and add operator before them and put back that String to stack
 */
public class PosfixToPrefix {
    public static void main(String[] args) {
        System.out.println(postfixToPrefix("ABC/-AK/L-*"));
    }

    public static String postfixToPrefix(final String str) {
        // Take a stack and add element when its operand
        Stack<String> st = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (isOperand(ch)) {
                st.push(ch + "");
            } else {
                //Pop out two elements and put the operator and add back to stack
                StringBuilder res = new StringBuilder();
                String a = st.pop();
                String b = st.pop();
                res.append(ch).append(b).append(a);
                st.push(res.toString());
            }
        }
        return st.pop();
    }

    private static boolean isOperand(final char ch) {
        final var characters = List.of('+', '-', '*', '(', '^', ')', '/');
        return !characters.contains(ch);
    }
}
