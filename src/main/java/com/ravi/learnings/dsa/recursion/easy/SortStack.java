package com.ravi.learnings.dsa.recursion.easy;

import java.util.Stack;

/**
 * <a href="https://www.geeksforgeeks.org/problems/sort-a-stack/1">Problem Link</a>
 *
 * <a href="https://www.youtube.com/watch?v=MOGBRkkOhkY">Video Link by Aditya Verma</a>
 * Given a stack, the task is to sort it such that the top of the stack has the greatest element.
 * <p>
 * Input:
 * Stack: 11 2 32 3 41
 * Output: 41 32 11 3 2
 */
public class SortStack {
    public static void main(String[] args) {
        final var integers = new Stack<Integer>();
        integers.push(41);
        integers.push(3);
        integers.push(32);
        integers.push(2);
        integers.push(11);

        System.out.println(integers);

        final var sortedStack = sort(integers);

        System.out.println(sortedStack);
    }

    /**
     * we will use recursion for sorting stack
     * 1. Add base condition if stack is only has 1 element then return
     * 2. We will pop out current element and store it and call sort function for remianing
     * 3. After calling sort method call insert function that will insert current element at right position
     * 4. Then return the sorted stack
     */
    public static Stack<Integer> sort(Stack<Integer> s) {
        if (s.size() == 1) {
            return s;
        }

        final var currentElement = s.pop();
        final var sortedStack = sort(s);

        insert(sortedStack, currentElement);

        return s;
    }

    /**
     * Here in insert function we will do
     * 1. Check for base condition if stack is empty or current next element is smalled that element that we want to insert
     * 2. If yes then insert current element and return
     * 3. if no then pop out element and store it
     * 4. Call insert for remaining elements
     * 5. After that push back popped element
     */
    private static void insert(final Stack<Integer> sortedStack, final Integer currentElement) {
        if (sortedStack.isEmpty() || sortedStack.peek() < currentElement) {
            sortedStack.push(currentElement);
            return;
        }

        final var pop = sortedStack.pop();
        insert(sortedStack, currentElement);
        sortedStack.push(pop);
    }
}
