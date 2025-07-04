package com.test.dsa.recursion.easy;

import java.util.Stack;

/**
 * <a href="https://www.geeksforgeeks.org/problems/sort-a-stack/1">Problem Link</a>
 *
 * <a href="https://www.youtube.com/watch?v=MOGBRkkOhkY">Video Link by Aditya Verma</a>
 * Given a stack, the task is to sort it such that the top of the stack has the greatest element.
 *
 * Input:
 * Stack: 11 2 32 3 41
 * Output: 41 32 11 3 2
 */
public class SortStack {
    public static void main(String[] args) {

    }
    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.size() == 1) {
            return s;
        }

        final var currentElement = s.pop();
        final var sortedStack = sort(s);

        insert(sortedStack, currentElement);

    }

    private void insert(final Stack<Integer> sortedStack, final Integer currentElement) {
//        if(sortedStack.size()
    }
}
