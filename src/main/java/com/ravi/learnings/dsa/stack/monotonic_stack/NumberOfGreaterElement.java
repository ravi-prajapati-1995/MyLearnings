package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Problem Link: <a href="https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1">Link</a>
 */
public class NumberOfGreaterElement {
    public static void main(String[] args) {
        int[] nums = {87330,24307,48161,50608,39614,25392,55022,98575,62076,85944,89406,76527,40230,8223,42414,36926,14577,36876,1962,25126,58481,62074,75480,6002
};
        int[] idx = {4197};
        System.out.println(Arrays.toString(count_NGE(nums, idx)));
    }

    /**
     * Below solution is brute force which gave TLE
     * In blow solution we take the indics array and traverse it as we have index in it
     * we get index , then we traverse main arr from the next element of idex
     * */
    public static int[] count_NGE(int arr[], int indices[]) {
        int res[] = new int[indices.length];
        for (int i = 0; i < indices.length; i++) { // start iterating by all indices
            final var index = indices[i];
            int number = arr[index];
            int count = 0;
            for (int j = index + 1; j < arr.length; j++) {
                if (arr[j] > number) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
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
