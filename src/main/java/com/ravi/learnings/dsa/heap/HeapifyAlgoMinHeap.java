package com.ravi.learnings.dsa.heap;

import java.util.Arrays;

/**
 * We have given a heap and need to update the value at particular index
 * int[] arr = {3, 4, 7, 5, 6, 11, 9, 10};
 *          3
 *        /    \
 *       4      7
 *      / \    / \
 *     5   6  11   9
 *    /
 *   10
 *
 *   In above min heap we need to replace value at certain places
 * */
public class HeapifyAlgoMinHeap {
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 7, 5, 6, 11, 9, 10};
        heapifyMinHeap(arr1, 7, 1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * In min heap least value element will be at top, then child we will be increasing
     * */
    public static void heapifyMinHeap(int[] nums, int ind, int val) {
        if(val > nums[ind]) {
            nums[ind] = val;
            heapifyDown(nums, ind);
        } else {
            nums[ind] = val;
            heapifyUp(nums, ind);
        }
    }


    public static void heapifyDown(int[] nums, int ind) {
        int smallest = ind;
        int leftChild = ind * 2 + 1;

        if(leftChild < nums.length && nums[leftChild] < nums[smallest]) {
            smallest = leftChild;
        }

        int rightChild = ind * 2 + 2;
        if(rightChild < nums.length && nums[rightChild] < nums[smallest]) {
            smallest = rightChild;
        }

        if(smallest != ind) {
            swap(nums, ind, smallest);
            heapifyDown(nums, smallest);

        }
    }

    public static void heapifyUp(int[] nums, int ind) {

        if(ind == 0) {
            return;
        }
        int parentIdx = (int) Math.floor((ind-1) / 2);

        if(nums[parentIdx] > nums[ind]) {
            swap(nums, ind, parentIdx);
            heapifyUp(nums, parentIdx);
        }
    }

    private static void swap(final int[] nums, final int ind, final int maxIdx) {
        int temp = nums[ind];
        nums[ind] = nums[maxIdx];
        nums[maxIdx] = temp;
    }
}
