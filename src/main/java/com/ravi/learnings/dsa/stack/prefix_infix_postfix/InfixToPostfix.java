package com.ravi.learnings.dsa.stack.prefix_infix_postfix;

import java.util.List;
import java.util.Stack;

/**
 * Video link: <a href=
 * "https://www.youtube.com/watch?si=ryeVvQWpCgwbTQrh&v=4pIc9UBHJtk&feature=youtu.be">Link</a>
 * You are given a string s representing an infix expression. Convert this infix
 * expression to a postfix expression.
 *
 * <p>
 * Infix expression: The expression of the form a op b. When an operator is in
 * between every pair of operands.
 * Postfix expression: The expression of the form a b op. When an operator is
 * followed for every pair of operands.
 * <p>
 * Input: a*(b+c)/d
 * output: abc+*d/
 * Operator and priority
 * ^ ------- 3
 * * / ------- 2
 * + - ------- 1
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println(infixToPostfixStriver("h^m^q^(7-4)"));
    }

    public static String infixToPostfixStriver(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder(s.length());
        for (final char ch : s.toCharArray()) {
            if (isOperand(ch)) { // a+b*(c^d-e)^(f+g*h)-i
                result.append(ch);
            } else if (ch == '(') {
                st.push(ch); // In case opening bracket we will directly push to stack
            } else if (ch == ')') { // when we got closing bracket we will got till opening bracket and push all the
                // elements in the result
                while (!st.empty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                // as we got starting bracket (
                st.pop();
            } else { // When we got operator then we need pop all the operator from stack which has
                // greater than or equal priority
                // like the comming operator
                while (!st.isEmpty() && priority(st.peek()) >= priority(ch) && ch != '^') {
                    result.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.toString();
    }

    /**
     * So to convert infix to postfix we will do the following steps:
     * I will traverse character by character when and check if it is operator or
     * operand
     * if I get operator then I will put it in stack
     * If I get operand I will append it in result String
     * If while inserting in stack there is already operand available then we will
     * check priority
     * If it has priority greater than what on the top then simply add it
     * Else we will pop out elements from stack and add to result till we find
     * operator that has lower prirority
     * than this sign
     * If we see opening bracket directly put it into the stack without thinking
     */
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder(s.length());
        for (final char ch : s.toCharArray()) {
            if (isOperand(ch)) { // a+b*(c^d-e)^(f+g*h)-i
                result.append(ch);
            } else {
                if (canAddOperator(ch, st)) { // A*(B+C)/D
                    st.push(ch);
                } else {
                    // Whe we got closing bracket we will pop out till we get a opening bracket and
                    // add popped item to
                    // result
                    if (ch == ')') {
                        while (!st.empty() && st.peek() != '(') {
                            result.append(st.pop());
                        }
                        // as we got starting bracket (
                        st.pop();
                        continue;
                    }
                    // Suppose here * is coming and we have - in that case we will pop out element
                    // till stack is not
                    // empty or we found a sign that has less than or equal to this priority
                    // if we got less priority operator we will append it in result
                    // If the operator is ^ then we will not pop out we will add that in stack
                    while (!st.isEmpty() && priority(ch) <= priority(st.peek()) && ch != '^') {
                        result.append(st.pop());
                    }
                    st.push(ch);
                }
            }
        }

        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        return result.toString();
    }

    private static boolean canAddOperator(final char ch, final Stack<Character> st) {
        if (st.isEmpty() || ch == '(') {
            return true;
        }

        if (ch == ')') {
            return false;
        }
        final var peek = st.peek();
        return priority(ch) > priority(peek);
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

    private static boolean isOperand(final char ch) {
        final var characters = List.of('+', '-', '*', '(', '^', ')', '/');
        return !characters.contains(ch);
    }
}
