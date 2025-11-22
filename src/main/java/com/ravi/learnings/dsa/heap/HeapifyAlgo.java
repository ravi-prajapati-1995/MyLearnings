package com.ravi.learnings.dsa.heap;

import java.util.Arrays;

/**
 * We have given a heap and need to update the value at particular index
 * int[] arr = {10, 7, 6, 4, 5, 4, 5, 3, 2};
 *          10
 *        /    \
 *       7      6
 *      / \    / \
 *     4   5  4   5
 *    / \
 *   3   2
 *
 *   In above max heap we need to replace value at certain places
 * */
public class HeapifyAlgo {
    public static void main(String[] args) {
        int[] arr = {10, 7, 6, 4, 5, 4, 5, 3, 2};
        heapifyDown(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * When we set a value that is smaller than the current value i.e if at index 0 we set 1 , then we need to do
     * heapify down till it follow the heap properties.
     * 1. we will check left and right child, and get the child which has higher value
     * 2. Swap that child with the root value
     * 3. Repeat this process till it follow the heap properties
     * */
    public static void heapifyDown(int[] nums, int ind, int val) {
        nums[ind] = val;
        int leftChild = ind * 2 + 1;
        int rightChild = ind * 2 + 2;

        if(leftChild >= nums.length || rightChild >= nums.length) {
            return;
        }
        if(nums[ind] >= nums[leftChild] && nums[ind] > nums[rightChild]) {
            return;
        }

        // Getting max value element from the child
        int maxIdx = nums[leftChild] > nums[rightChild] ? leftChild : rightChild;

        //Now we will replace the ind with the maxIdx value and maxIdx with ind val
        replace(nums, ind, maxIdx);

        heapifyDown(nums, maxIdx, nums[maxIdx]);
    }

    /**
     * If we want to set 15 at index 7 , then we need to move that element to the root till heap properties are not
     * satisfied
     *
     * @param nums
     * @param ind
     * @param val
     */
    public static void heapifyUp(int[] nums, int ind, int val) {
        nums[ind] = val;
        int leftChild = ind * 2 + 1;
        int rightChild = ind * 2 + 2;

        if(leftChild >= nums.length || rightChild >= nums.length) {
            return;
        }
        if(nums[ind] >= nums[leftChild] && nums[ind] > nums[rightChild]) {
            return;
        }

        // Getting max value element from the child
        int maxIdx = nums[leftChild] > nums[rightChild] ? leftChild : rightChild;

        //Now we will replace the ind with the maxIdx value and maxIdx with ind val
        replace(nums, ind, maxIdx);

        heapifyUp(nums, maxIdx, nums[maxIdx]);
    }

    private static void replace(final int[] nums, final int ind, final int maxIdx) {
        int temp = nums[ind];
        nums[ind] = nums[maxIdx];
        nums[maxIdx] = temp;
    }
}
