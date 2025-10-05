package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <a href="https://takeuforward.org/data-structure/next-smaller-element">Solution</a>
 * */
public class NextSmallerElement {
    public static void main(String[] args) {
        int[] nums = {8, 8, 2, 2, 4, 9, 1, 1, 5, 10};
        System.out.println(nextSmallerElementOptimal1(nums));
    }

    public static ArrayList<Integer> nextSmallerElementOptimal(int[] arr) {
        int len = arr.length;
        final var nge = new int[len];
        final Stack<Integer> st = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {// Traversing from right to left
            final var num = arr[i];
            while (!st.isEmpty() && st.peek() >= num) {
                st.pop();
            }
            if (st.isEmpty()) { // if stack is empty then directly add to stack and mark that index -1 as we
                // don't have nge for this element
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(num);
        }
        System.out.println(Arrays.toString(nge));

        final var list = new ArrayList<Integer>();
        for (int a : nge) {
            list.add(a);
        }
        return list;
    }

    public static ArrayList<Integer> nextSmallerElementOptimal1(int[] arr) {
        int len = arr.length;
        final var nge = new ArrayList<Integer>();
        final Stack<Integer> st = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {// Traversing from right to left
            final var idx = i;
            final var num = arr[idx];
            while (!st.isEmpty() && st.peek() >= num) {
                st.pop();
            }
            if (st.isEmpty()) { // if stack is empty then directly add to stack and mark that index -1 as we
                // don't
                // have nge for this element
                nge.addFirst(-1);
            } else {
                nge.addFirst(st.peek());
            }
            st.push(num);
        }
        return nge;
    }
}
