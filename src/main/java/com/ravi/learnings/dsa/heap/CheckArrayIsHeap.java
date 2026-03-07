package com.ravi.learnings.dsa.heap;

/*
https://takeuforward.org/plus/dsa/problems/check-if-an-array-represents-a-min-heap-?tab=submissions
*Given an array of integers nums. Check whether the array represents a binary min-heap or not. Return true if it does,
* otherwise return false.
* A binary min-heap is a complete binary tree where the key at the root is the minimum among all keys present in a binary
* min-heap and the same property is recursively true for all nodes in a Binary Tree.
* */
public class CheckArrayIsHeap {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 21, 23, 9};
        System.out.println(isHeapStriver(nums));
    }

    /**
     * In Brute force approach we used recursion and check for each element if its below element are following min heap
     * properties
     *
     * We can also do it by traversing from arrays last
     * As leaf nodes are always follow the min heap properties so we need to check for internal nodes
     * In heap internal nodes are from 0 to (n/2)-1
     * */
    public static boolean isHeapStriver(int[] nums) {
        int lastParentNode = (nums.length / 2) - 1;

        for (int i = lastParentNode; i >= 0; i--) {
            int leftNode = nums[(i * 2) + 1];
            if(leftNode < nums[i]){
                return false;
            }

            int rightNode = (i * 2) + 2;
            if(rightNode < nums.length && nums[rightNode] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHeapBruteForce(int[] nums) {
        return isHeapBruteForce(0, nums);
    }

    public static boolean isHeapBruteForce(int idx, int[] nums) {
        final var num = nums[idx];
        final var leftChild = 2 * idx + 1;
        final var rightChild = 2 * idx + 2;

        if(leftChild < nums.length && rightChild < nums.length) {
            if(nums[leftChild] >= num && nums[rightChild] >= num) {
                return isHeapBruteForce(leftChild, nums) && isHeapBruteForce(rightChild, nums);
            } else {
                return false;
            }
        } else if(leftChild < nums.length) { // when we have only left node no right node
            if(nums[leftChild] >= num) {
                return isHeapBruteForce(leftChild, nums);
            } else {
                return false;
            }
        } else { // This is the case when we reached the leaf node
            return true;
        }

    }
}
