package com.ravi.learnings.dsa.heap;

import java.util.PriorityQueue;

/**
 * Given an array nums, return the kth largest element in the array.
 * Input: nums = [1, 2, 3, 4, 5], k = 2
 * Output: 4
 */
public class KthLargestElement {

    public static void main(String[] args) {
        int nums[] = {-5, 4, 1, 2, -3};
        System.out.println(kthLargestElement_BruteForce(nums, 5));
        System.out.println(kthLargestElement_BruteForce_striver(nums, 5));
    }

    /**
     * Brute Force Approach:
     * One way to do it by sort the given array in descending order, then find the k-1 element and return simple
     * TC = O(NlogN) -- as we are sorting the array
     * SC - O(1) -- Not using extra space
     * Better Approach:
     * 1. We can use a priority queue which will have k elements
     * 2. Traverse the array after adding K element when adding next element check the top element if it is smaller than
     * current element
     * 3. If yes then continue to next element
     * 4. If not then remove the top element and add the current element priority queue
     * 5. Do same for all the elements we will left with k largest element in the priority queue
     *
     * TC: So we are adding K element in the PQ so compexity: ( O(KlogK) + (N-k)LogK ) = logK(k + N -K) --> NlogK
     * So time complexity is near about nlogn
     * SC -- O(k) for storing K elements
     */
    public static int kthLargestElement_BruteForce(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i : nums) {
            if (pq.size() < k) { // if priority queue have less than k elements we will add that in queue directly
                pq.add(i);
            } else { // meaning PQ is full with k element
                if(pq.peek() < i) { // meaning we have small element in PQ
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        System.out.println(pq);
        return pq.poll();
    }


    public static int kthLargestElement_BruteForce_striver(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (pq.peek() < i) { // meaning we have small element in PQ
                pq.poll();
                pq.add(i);
            }
        }
        System.out.println(pq);
        return pq.poll();
    }
}
