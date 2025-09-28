package com.ravi.learnings.dsa.stack.learning;

import java.util.LinkedList;

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
        System.out.println(isValidStriver("([)]"));

    }

    /**
     * To to solve this problem we need to keep track of last opening bracket i.e: ()[{}()]
     * traverse all the characters
     * So first opening of ( comes we will push it to stack
     * Then ) came then check stack is it having opening bracket for this if yes continue else return false
     * Then [ push to stack and then { push to stack
     * after that } came  pop from stack if top element is {
     *
     * in that way we can solve this
     * TC: O(N)
     * SC: O(N) --- to storing the closing brackets
     * @return
     */
    public static boolean isValidStriver(String s) {
        final var linkedList = new LinkedList<Character>();
        final var charArray = s.toCharArray();
        for(char c: charArray) {
            if(c == '(' || c == '{' || c == '[') {
                linkedList.push(c);
            } else {
                if(linkedList.isEmpty()) {
                    return false;
                }
                final var pop = linkedList.pop();
                if((c == ']' && pop != '[')) {
                    return false;
                } else if((c == ')' && pop != '(')) {
                    return false;
                } else if((c == '}' && pop != '{')) {
                    return false;
                }
            }
        }
        return  linkedList.isEmpty();
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
