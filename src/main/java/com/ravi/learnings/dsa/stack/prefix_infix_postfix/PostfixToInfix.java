package com.ravi.learnings.dsa.stack.prefix_infix_postfix;

import java.util.List;
import java.util.Stack;

/**
 * Problem Link: https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1
 * Video Link: https://youtu.be/4pIc9UBHJtk?si=i23DVCvllVhJ-LBr&t=1710
 * To convert a expression from Postfix to infix
 * 1. Add operand to the stack
 * 2. When get operator pick last 2 operand and put that sign in between those
 * and wrap in bracket
 */
public class PostfixToInfix {
    public static void main(String[] args) {
        System.out.println(postFixToInfix("ab*c+"));
    }

    public static String postFixToInfix(final String str) {
        // Take a stack and add element when its operand
        Stack<String> st = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (isOperand(ch)) {
                st.push(ch + "");
            } else {
                //Pop out two elements and put the operator and add to res
                StringBuilder res = new StringBuilder();
                String a = st.pop();
                String b = st.pop();
                res.append("(").append(b).append(ch).append(a).append(")");
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
