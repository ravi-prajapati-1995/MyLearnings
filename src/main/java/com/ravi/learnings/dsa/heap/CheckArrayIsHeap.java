package com.ravi.learnings.dsa.heap;

/*
*Given an array of integers nums. Check whether the array represents a binary min-heap or not. Return true if it does,
* otherwise return false.
* A binary min-heap is a complete binary tree where the key at the root is the minimum among all keys present in a binary
* min-heap and the same property is recursively true for all nodes in a Binary Tree.
* */
public class CheckArrayIsHeap {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 21, 23, 9};
        System.out.println(isHeap(nums));
    }

    public static boolean isHeap(int[] nums) {
        return isHeap(0, nums);
    }

    public static boolean isHeap(int idx, int[] nums) {
        final var num = nums[idx];
        final var leftChild = 2 * idx + 1;
        final var rightChild = 2 * idx + 2;

        if(leftChild < nums.length && rightChild < nums.length) {
            if(nums[leftChild] >= num && nums[rightChild] >= num) {
                return isHeap(leftChild, nums) && isHeap(rightChild, nums);
            } else {
                return false;
            }
        } else if(leftChild < nums.length) { // when we have only left node no right node
            if(nums[leftChild] >= num) {
                return isHeap(leftChild, nums);
            } else {
                return false;
            }
        } else { // This is the case when we reached the leaf node
            return true;
        }

    }
}
