package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i/">Problem Link</a>
 * Monotonic Stack: A stack in which we store elements in specific order it may be in ascending,
 * descending or in any other order is known as monotonic stack
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        //        int arr[] = {6, 0, 8, 1, 3};
        //        System.out.println(Arrays.toString(ngeBruteForce(arr)));
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElementStriver(nums1, nums2)));
    }


    /**
     * For getting next greater element we will use the monotonic stack
     * 1. Start traversing from right to left, and take a stack and push elements in stack
     * 2. If stack is empty mark -1 at that index as there will no next greater element
     * 3. Compare current item with the peek element of the stack if it is greater than that add to stack
     * 4. Else if pop all the element till we get the greater element
     * 5. After getting element mark current index with that number and add that number to the stack
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public static int[] nextGreaterElementStriver(int[] nums1, int[] nums2) {
        final var res = new int[nums1.length];
        final var nge = new int[1001];
        final Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {//Traversing from right to left
            final var num = nums2[i];
            while (!st.isEmpty() && st.peek() < num) {
                st.pop();
            }
            if (st.isEmpty()) { // if stack is empty then directly add to stack and mark that index -1 as we don't
                // have nge for this element
                nge[nums2[i]] = -1;
            } else {
                nge[nums2[i]] = st.peek();
            }
            st.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = nge[nums1[i]];
        }
        return res;
    }
    
    public static int[] nextGreaterElementOptimal(int[] nums1, int[] nums2) {
        final var res = new int[nums1.length];
        final var nge = new int[nums2.length];
        final Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {//Traversing from right to left
            final var num = nums2[i];
            if (st.isEmpty()) { // if stack is empty then directly add to stack and mark that index -1 as we don't
                // have nge for this element
                nge[i] = -1;
                st.push(num);
            } else {
                if (st.peek() > num) { // when stack's top element is greater than current element then mark current
                    // index with the peed element and push the number
                    nge[i] = st.peek();
                    st.push(num);
                } else { // when at top element is lesser than current element
                    while (!st.isEmpty() && st.peek() < num) {
                        st.pop();
                    }

                    if (st.isEmpty()) {
                        nge[i] = -1;
                        st.push(num);
                    } else {
                        nge[i] = st.peek();
                        st.push(num);
                    }
                }
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            final var idx = getElementIndex(nums2, nums1[i]);
            res[i] = nge[idx];
        }
        return res;
    }

    private static int getElementIndex(final int[] nums2, final int num) {
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * TC: O(n^2)
     * SC: O(N) we are storing data in array
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final var res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean isAdded = false;
            final var idx = getElementIndex(nums2, nums1[i]);
            for (int j = idx; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
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
     * Given an array arr = [6, 0, 8, 1, 3] for each element in the array we need to find out next greater element
     * we will traverse array from left to right
     * for 6 --- nge = 8
     * 0 -- 8
     * 8 -- -1 (In case we don't have any greater element we should add -1)
     * 1 -- 3
     * 3 -- -1
     * So we need to return the array as: [8, 8, -1, 3, -1]
     */
    public static int[] ngeBruteForce(int[] arr) {
        final var res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean isAdded = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
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
}
