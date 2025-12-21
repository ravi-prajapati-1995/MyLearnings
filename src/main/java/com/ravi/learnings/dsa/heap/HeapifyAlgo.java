package com.ravi.learnings.dsa.heap;

import java.util.Arrays;

/**
 * We have given a max heap and need to update the value at particular index
 * int[] arr = {10, 7, 6, 4, 5, 4, 5, 3, 2};
 * 10
 * /    \
 * 7      6
 * / \    / \
 * 4   5  4   5
 * / \
 * 3   2
 * <p>
 * In above max heap we need to replace value at certain places
 */
public class HeapifyAlgo {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 5, 7, 6};
        heapify(arr, 5, 2);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {3, 4, 7, 5, 6, 11, 9, 10};
        heapifyMinHeap(arr1, 0, 7);
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


    /***
     * when we got a element that value is greater than the current value i.e nums[ind] then we need to do
     * heapify UP
     * if(val > nums[ind]) --- Then do the heapify up other do heapify down
     * */
    public static void heapify(int[] nums, int ind, int val) {
        if(val < nums[ind]) {
            nums[ind] = val;
            heapifyDown(nums, ind);
        } else {
            nums[ind] = val;
            heapifyUp(nums, ind);
        }
    }

    /**
     * This method will be called for heapify
     * In case @val will be greater than the existing element in the heap I need to do heapify UP
     * In case val is smaller we need to heapify down
     */
    public static void heapify(int[] nums, int ind, int val) {
        if (val < nums[ind]) {
            nums[ind] = val;
            heapifyUpMinHeap(nums, ind, val);
        } else {
            nums[ind] = val;
            heapifyDown(nums, ind);
        }
    }

    /**
     * When we set a value that is smaller than the current value i.e if at index 0 we set 1 , then we need to do
     * heapify down till it follow the heap properties.
     * 1. we will check left and right child, and get the child which has higher value
     * 2. Swap that child with the root value
     * 3. Repeat this process till it follow the heap properties
     * */
    public static void heapifyDown(int[] nums, int ind) {
        int smallest = ind;
        int leftChild = ind * 2 + 1;

        // We will check if the left child is greater than the root then make left smallest
        if(leftChild < nums.length && nums[leftChild] > nums[smallest]) {
            smallest = leftChild;
        }


        int rightChild = ind * 2 + 2;
        // So here if the left child is less than the root, then we compare left child with the right child
        // This also helps in case we have only left child and there is no right child
        if (rightChild < nums.length && nums[rightChild] > nums[smallest]) {
            smallest = rightChild;
        }

        // Meaning smallest element is either left or right child, if that is the case we need to swap the numbers
        if(smallest != ind) {
            swap(nums, ind, smallest);
            // Now we need to check if we can move this item further in tree
            heapifyDown(nums, smallest);

        }
        //Now we will replace the ind with the maxIdx value and maxIdx with ind val

    }

    /**
     * If we want to set 15 at index 7 , then we need to move that element to the root till heap properties are not
     * satisfied
     *
     * To find the parent of any index we need to do ceil(idx/2) - 1
     * @param nums
     * @param ind
     */
    public static void heapifyUp(int[] nums, int ind) {

        // Meaning we are at top don't need to process anything further
        if(ind == 0) {
            return;
        }
        // Got the parent of current element, now we need to check if the parent value is greater than if yes swap
        int parentIdx = (int) Math.floor((ind-1) / 2);

        // Meaning parent is smaller than the child
        if(nums[parentIdx] < nums[ind]) {
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
