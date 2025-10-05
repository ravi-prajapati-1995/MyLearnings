package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Problem link:
 * https://leetcode.com/problems/next-greater-element-ii/description/
 * Given a circular integer array nums (i.e., the next element of
 * nums[nums.length - 1] is nums[0]), return the next greater number for every
 * element in nums.
 * 
 * The next greater number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, return -1 for this
 * number.
 * 
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also
 * 2.
 */
public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElementStriver(nums)));
    }

    /**
     * In the brute force approach we can start from i and process till nums.length if element is not present then
     * we will traverse from 0 till i (exclusive)
     * 
     * So to avoid two loops we can use virtual array where we will repeat the array i.e we hav: 
     * { 1, 2, 3, 4, 3 } we will repeat it one time { { 1, 2, 3, 4, 3, 1, 2, 3, 4, 3} here if we are at index 2 with element 3, we will take element { 3, 4, 3, 1, 2} So that we can use circular array
     * 
     * Lets suppose we have array with length of 5 and we are processing for index 2 
     * Then we will add 5+2 and internal array we will traverse < 7 to get the 
     * so we will do module with nums.length to get the exact value for 5%5 -- 0, 6%5 ---1
     * TC; O(N^2)
     * SC: O(N) -- To storing the result
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        final var res = new int[length];
        for (int i = 0; i < nums.length; i++) {
            boolean isAdded = false;

            int last = i + length;
            for (int j = i; j < last; j++) {
                if (nums[j%length] > nums[i]) {
                    res[i] = nums[j%length];
                    isAdded = true;
                    break;
                }
            }

            if (!isAdded) {
                res[i] = -1;
            }
        }
        return res;
    }

    /**
     * We will create a virtual array so that we can make use of circular array
     * 
     * TC - O(2N) -- For loop runing 2 times + O(2N) In while we will remove at max 2N elements
     * @param nums
     * @return
     */
    public static int[] nextGreaterElementStriver(int[] nums) {
        int len = nums.length;
        final var nge = new int[len];
        final Stack<Integer> st = new Stack<>();
        for (int i = (2 * len) - 1; i >= 0; i--) {//Traversing from right to left
            final var idx = i%len;
            final var num = nums[idx];
            while (!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }
            if (st.isEmpty()) { // if stack is empty then directly add to stack and mark that index -1 as we don't
                // have nge for this element
                nge[idx] = -1;
            } else {
                nge[idx] = st.peek();
            }
            st.push(num);
        }
        return nge;
    }
}
