package com.ravi.learnings.dsa.stack.implementation_problem;

import java.util.*;

/**
 * Problem Link:
 * https://leetcode.com/problems/sliding-window-maximum/description/
 * <p>
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 *
 */
public class _001SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {609,894,552,690,-565,-260,31,-896,-179,-216,256,940,-253,430,983,803,782,993};
        int k = 4;
        System.out.println(Arrays.toString(maxSlidingWindowOptimal(nums, k)));
    }

    /**
     * To find the max in each window in brute force approach we will
     * 1. Take outer loop that will run from 0 index to n-k index
     * 2. Take inner loop that will run from current index till K steps
     * 3. Take a max to current element while iterating inner loop check for max
     * 4. After inner loop completes then add that max in the result list
     * <p>
     * TC: O((N-K)*K) (where N is the size of given array)
     * SC: O(N-K)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res.add(max);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    /*
    * Keep a dequeue where we will max element at first and after that smaller and smaller
    * if we are reaching out of current window then remove the first element as it will not be in current window
    * While adding element if the last element is less than current element remove that element, till get larger element
    *
    * */
    public static int[] maxSlidingWindowOptimal(int[] nums, int k) {
        final LinkedList<Integer> deque = new LinkedList<>();
        final ArrayList<Integer> maxSum = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && (i - deque.peekFirst()) >= k) {
                deque.pollFirst();
            }

            // case when then incoming element is greater then all stored elements
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.add(i);
            if (i >= k-1) {
                maxSum.add(nums[deque.getFirst()]);
            }
        }

        return maxSum.stream().mapToInt(Integer::intValue).toArray();
    }

}
