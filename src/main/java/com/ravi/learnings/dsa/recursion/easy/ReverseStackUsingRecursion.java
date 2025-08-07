package com.ravi.learnings.dsa.recursion.easy;

import java.util.Stack;

/**
 * <a href="https://www.geeksforgeeks.org/problems/reverse-a-stack/1">Problem Link</a>
 * You are given a stack St. You have to reverse the stack using recursion.
 *
 * Input:
 * St = {3,2,1,7,6}
 * Output:
 * {6,7,1,2,3}
 * Explanation:
 * Input stack after reversing will look like the stack in the output.
 */
public class ReverseStackUsingRecursion {
    public static void main(String[] args) {
        final var integers = new Stack<Integer>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        integers.push(4);
        integers.push(5);

        System.out.println(integers);

        reverse(integers);

        System.out.println(integers);
    }

    /**
     * Mostly same as sort stack just different insert function logic
     * */
    static void reverse(Stack<Integer> s) {
        // add your code here
        if(s.empty()) {
            return;
        }

        final var pop = s.pop();
        reverse(s);

        insertAtLast(s, pop);
    }

    /**
     * This function will add current element at the end of the stack
     * */
    static void insertAtLast(Stack<Integer> s, Integer element) {
        if(s.isEmpty()) {
            s.push(element);
            return;
        }

        final var pop = s.pop();
        insertAtLast(s, element);
        s.push(pop);
    }

}
