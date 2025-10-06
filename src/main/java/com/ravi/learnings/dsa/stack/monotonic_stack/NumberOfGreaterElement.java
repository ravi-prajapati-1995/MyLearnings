package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Problem Link: https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1
 */
public class NumberOfGreaterElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println(numberOfGreaterElement(nums));
    }

    public static ArrayList<Integer> numberOfGreaterElement(int[] arr) {
        int len = arr.length;
        final var nge = new int[len];
        final Stack<Integer> st = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {// Traversing from right to left
            final var num = arr[i];
            while (!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(num);
        }

        System.out.println(Arrays.toString(nge));
        return null;
    }
}
