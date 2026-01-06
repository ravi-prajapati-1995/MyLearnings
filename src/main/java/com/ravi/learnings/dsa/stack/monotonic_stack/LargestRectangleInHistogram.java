package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a href=
 * "https://leetcode.com/problems/largest-rectangle-in-histogram/description/">Problem
 * Link</a>
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleAreaNgeAndNse(heights));
    }

    /**
     * I can also do it via finding the next greater element and Previous smaller
     * element
     * i.e { 2, 1, 5, 6, 2, 3 }
     *      0, 1, 2, 3, 4, 5
     * We are at 2nd index 5 length histogram
     * next smaller element for 5(idx 2) is 2(idx 4)
     * Previous Smaller element is 1(idx 1)
     * so we do nse - pse - 1
     * in our case 4-1-1 = 2
     * TC --> for NSE O(2n) + for PSE O(2n) + for getting larest O(n) = O(5n)
     * SC --- > In NSE we are using array for return and stack for internal use o(2n) + sam for PSE O(2n) = O(4N)
     */
    public static int largestRectangleAreaNgeAndNse(int[] heights) {
        int res = 0;
        int[] nse = nextSmallerElement(heights);
        int[] pse = prevSmallerElement(heights);
        System.out.println(Arrays.toString(nse));
        System.out.println(Arrays.toString(pse));

        // previousSmallerElement(heights);
        for (int i = 0; i < heights.length; i++) {
            int val = nse[i] - pse[i] -1;
            res = Math.max(res, (val*heights[i]));
        }
        return res;
    }

    /**
     * i.e { 2, 1, 5, 6, 2, 3}
     * ------0, 1, 2, 3, 4, 5
     * 
     * @param heights
     * @return
     */
    private static int[] nextSmallerElement(int[] heights) {
        int res[] = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {

            while (!st.empty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }

            res[i] = st.empty() ? heights.length : st.peek();

            st.push(i);

        }
        return res;
    }

    /**
     * i.e { 2, 1, 5, 6, 2, 3}
     * ------0, 1, 2, 3, 4, 5
     * 
     * @param heights
     * @return
     */
    private static int[] prevSmallerElement(int[] heights) {
        int res[] = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < heights.length; i++) {

            while (!st.empty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }

            res[i] = st.empty() ? -1 : st.peek();

            st.push(i);

        }
        return res;
    }

    /**
     * So in brute force technique I have used a loop and inside calling function
     * that will give me number of time that histogram can be added
     * for that I am going to the left side for each element, if I found element with current element then keep adding
     * Other wise break Same for the right side
     * After getting both the side count then multiply this with the element so that we can calculate total area
     * and then getting max for each element
     */
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int val = (checkMaxFor(i, heights) * heights[i]);
            res = Math.max(res, val);
        }
        return res;
    }

    private static int checkMaxFor(int idx, int[] heights) {
        int res = 0;

        // checking in left side how many histogram we can take
        for (int i = idx; i >= 0; i--) {
            if (heights[i] >= heights[idx]) {
                res++;
            } else {
                break;
            }
        }

        // checking in right side how many histogram we can take
        for (int i = idx + 1; i < heights.length; i++) {
            if (heights[i] >= heights[idx]) {
                res++;
            } else {
                break;
            }
        }

        return res;
    }
}
