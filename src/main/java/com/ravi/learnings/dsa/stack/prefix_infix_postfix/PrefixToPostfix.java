package com.ravi.learnings.dsa.stack.prefix_infix_postfix;

import java.util.List;
import java.util.Stack;

/**
 * To convert a expression from prefix to postfix we will follow the below steps
 * 1. Start traverse from right to left
 * 2. When got operand then add that to the stack
 * 3. When got operator then pick last two elements and add operator before them
 * and add back to stack without brackets
 * 
 * 
 */
public class PrefixToPostfix {

    public static void main(String[] args) {
        System.out.println(preToPostfix("*-A/BC-/AKL"));
    }

    static String preToPostfix(String pre_exp) {
        Stack<String> st = new Stack<>();
        int size = pre_exp.length();
        for (int i = size - 1; i >= 0; i--) {
            String c = pre_exp.charAt(i) + "";
            if (isOperand(pre_exp.charAt(i))) {
                st.push(c);
            } else { // Get last two elements and add operator add back to stack

                String r = st.pop() + st.pop() + c;
                st.push(r);
            }
        }
        return st.pop();

    }

    private static boolean isOperand(final char ch) {
        final var characters = List.of('+', '-', '*', '(', '^', ')', '/');
        return !characters.contains(ch);
    }
}
