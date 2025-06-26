package com.test.dsa.binarysearchtree.easy;

import com.test.dsa.binartree.TreeNode;

/**
 * <a href="https://www.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1">Problem Link</a>
 * Given a Binary Tree, find maximum and minimum elements in it.
 */
public class FindMinAndMax {

    public static int findMax(TreeNode root) {

        int max = 0;
        while (root != null) {
            max = root.val;
            root = root.right;
        }

        return max;
    }

    public static int findMin(TreeNode root) {

        int min = 0;
        while (root != null) {
            min = root.val;
            root = root.left;
        }

        return min;
    }
}
