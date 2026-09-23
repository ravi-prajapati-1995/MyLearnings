package com.ravi.learnings.dsa.stack.implementation_problem;

import com.ravi.learnings.dsa.stack.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://takeuforward.org/plus/dsa/problems/stock-span-problem?source=strivers-a2z-dsa-track
 * Given an array arr of size n, where each element arr[i] represents the stock price on day i.
 * Calculate the span of stock prices for each day.
 * The span Si for a specific day i is defined as the maximum number of consecutive previous days (including the current day)
 * for which the stock price was less than or equal to the price on day i.
 * Input: n = 7, arr = [120, 100, 60, 80, 90, 110, 115]
 * Output: [1, 1, 1, 2, 3, 5, 6]
 * */
public class _002StockSpanProblem {
    public static void main(String[] args) {
        int[] arr = {120, 100, 60, 80, 90, 110, 115};
        System.out.println(calculateSpanOptimal(arr));
//        System.out.println(calculateSpanBruteForceStriver(arr));
    }

    /*
     * This is brute force solution gives the desired output, but it is time complexity
     * TC: O(n * n!)
     * */
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        final var result = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int res = 0;
            int curr = arr[i];
            for (int j = 0; j <= i; j++) {
                if (curr >= arr[j]) {
                    res++;
                } else {
                    res = 0;
                }
            }

            result.add(res);
        }
        return result;
    }

    /*
     * So instead of starting from the 0 the element and going till the current element, we can do that
     * we will start from the current element and goes toward 0, and find out how many span elements we have
     * */
    public static ArrayList<Integer> calculateSpanBruteForceStriver(int[] arr) {
        final var result = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int res = 0;
            int curr = arr[i];
            int j = i;
            while (j >= 0) {
                if (arr[j] <= curr) {
                    res++;
                } else {
                    break;
                }
                j--;
            }
            result.add(res);
        }
        return result;
    }

    /**
     * In optimal solution we will use the PGE(previous greater element)
     * arr: [120, 100, 60, 80, 90, 110, 115]
     * pge : [-1, 0, 1, 1, 1, 0, 0]
     * So we will find out the above array and for each index we will calculate
     * i = i - (pge[i])
     * 0 = 0 - (-1) = 1
     * 1 = 1 - (0) = 1
     * 2 = 2 - (1) = 1
     * 3 = 3-(1) = 2
     * 4 = 4 - (1) = 3
     * 5 = 5 - (0) = 5
     * 6 = 6 - (0) = 6
     * res = [1, 1, 1, 2, 3, 5, 6]
     *
     */
    public static int[] calculateSpanOptimal(int[] arr) {
        final var list = new ArrayList<Integer>();
        final var previousGreaterElement = getPreviousGreaterElement(arr);
        for (int i = 0; i < arr.length; i++) {
            list.add((i - previousGreaterElement.get(i)));
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * So this method will calculate the previous greater element using monotonic stack order will be ascending, meaning
     * larget element at the bottom
     * 1. Push the first element which is at 0 index.
     * 2. We will traverse through the elements from 1-n-1
     * 3. while traversing get the top most element if top element is less than currently adding element then pop
     * till we get greater element
     * 4. Get the top element and add idx of that in list
     * 5. Then add back to stack current element
     *
     */
    private static List<Integer> getPreviousGreaterElement(final int[] arr) {
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        final var list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int top = arr[i];
            while (!st.isEmpty() && st.peek().val() <= top) {
                st.pop();
            }

            int idx = st.isEmpty() ? -1 : st.peek().key();
            list.add(idx);

            st.push(new Pair<>(i, top));
        }

        System.out.println(list);
        return list;
    }
}
