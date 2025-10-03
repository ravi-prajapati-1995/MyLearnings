package com.ravi.learnings.dsa.stack.prefix_infix_postfix;

import java.util.List;
import java.util.Stack;

/**
 * Video Link: https://youtu.be/4pIc9UBHJtk?si=pTxB3cva1rFXFzMw&t=1001
 * To change InfixToPrefix we will follow the following steps:
 * 1. Reverse the Infix
 * 2. Infix 2 Postfix -- With conditional changes
 * 3. Reverse that answer
 * Example: (a+b)*c-d+f
 * 1. Reverse: f+d-c*)b+a( -- After reversing make the opening bracket to closing bracket and closing bracket to
 * opening bracket
 * In this we will directly add the operator to stack if it is other than ^
 */
public class InfixToPrefix {
    public static void main(String[] args) {
        System.out.println(infixToPrefix("ravi"));
    }

    public static String infixToPrefix(String s) {
        // Reversed the given String
        StringBuilder reversed = new StringBuilder();
        int size = s.length();
        char[] charArray = s.toCharArray();
        for (int i = size - 1; i >= 0; i--) {
            reversed.append(charArray[i]);
        }

        System.out.println(reversed);
        Stack<Character> st = new Stack<>();
        final var string = reversed.toString();
//        string.replace("(", ")").replace();
        charArray = string.toCharArray();
        StringBuilder res = new StringBuilder();
        for(char ch: charArray) {
            if(isOperand(ch)) {
                res.append(ch);
            } else {
                if(ch == '('){

                }
            }
        }

        return null;
    }

    private static boolean isOperand(final char ch) {
        final var characters = List.of('+', '-', '*', '(', '^', ')', '/');
        return !characters.contains(ch);
    }

}
