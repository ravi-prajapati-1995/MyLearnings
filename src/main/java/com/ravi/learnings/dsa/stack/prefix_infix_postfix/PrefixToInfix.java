package com.ravi.learnings.dsa.stack.prefix_infix_postfix;

import java.util.List;
import java.util.Stack;

/**
 * 1. start traversing from back, basically from right to left
 * 2. When got operand add to stack
 * 3. When got operator pick last tow operand and put operator in between and
 * reinsert to stack
 */
public class PrefixToInfix {
    public static void main(String[] args) {
        System.out.println(preToInfix("*-A/BC-/AKL"));
    }

    static String preToInfix(String pre_exp) {
        Stack<String> st = new Stack<>();
        int size = pre_exp.length();
        for (int i = size - 1; i >= 0; i--) {
            String c = pre_exp.charAt(i) + "";
            if (isOperand(pre_exp.charAt(i))) {
                st.push(c);
            } else { //Get last two elements and add operator add back to stack

                String r = "(" + st.pop() + c + st.pop() + ")";
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
