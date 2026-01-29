package com.ravi.learnings.dsa.heap;

import java.util.Arrays;

import static com.ravi.learnings.dsa.sorting.InsertionSort.swap;

/**
 * https://takeuforward.org/plus/dsa/problems/convert-min-heap-to-max-heap
 * Given a min-heap in array representation named nums, convert it into a max-heap and return the resulting array.
 * <p>
 * <p>
 * <p>
 * A min-heap is a complete binary tree where the key at the root is the minimum among all keys present in a binary min-heap and the same property is recursively true for all nodes in the Binary Tree.
 * <p>
 * A max-heap is a complete binary tree where the key at the root is the maximum among all keys present in a binary max-heap and the same property is recursively true for all nodes in the Binary Tree.
 * <p>
 * <p>
 * <p>
 * Since there can be multiple answers, the compiler will return true if it's correct, else false.
 * Input: nums = [10, 20, 30, 21, 23]
 * <p>
 * Output: [30, 21, 23, 10, 20]
 */
public class ConvertMinHeapToMaxHeap {

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 21, 23};
        System.out.println(Arrays.toString(minToMaxHeap(nums)));
    }

    public static int[] minToMaxHeap(int[] nums) {
        int lastParentNode = nums.length / 2 - 1; // as leaf nodes starts from n/2
        for (int i = lastParentNode; i >= 0; i--) {
            check(nums, i);
        }
        return nums;
    }

    private static void check(int[] nums, int idx) {
        int leftChild = 2 * idx + 1;
        // There may be case that I am on leaf node and there are not left and right child so checking that
        int largestIdx = idx;

        // checking if we have left side element and if yes, then we compare if left side element is greater than root
        if (leftChild < nums.length && nums[leftChild] > nums[largestIdx]) {
            largestIdx = leftChild;
        }

        int rightChild = 2 * idx + 2; // Same here it can be also out of index

        // checking if we have right side element and if yes, then we compare largest element is greater than root
        if (rightChild < nums.length && nums[rightChild] > nums[largestIdx]) {
            largestIdx = rightChild;
        }

        // Meaning largest element is not the parent so need to swap it with largest element
        if (largestIdx != idx) {
            swap(nums, idx, largestIdx);
            //Since we changed the parent of other child on largestIdx need to check/heapify down for that too
            check(nums, largestIdx);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
