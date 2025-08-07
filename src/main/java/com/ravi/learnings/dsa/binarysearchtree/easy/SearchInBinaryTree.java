package com.ravi.learnings.dsa.binarysearchtree.easy;

import com.ravi.learnings.dsa.binartree.TreeNode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/description/">problem link</a>
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
public class SearchInBinaryTree {
    public static void main(String[] args) {
        final var treeNode = TreeNode.from(List.of(4, 2, 6, 1, 3, 5, 7));

        final var integers = searchBST(treeNode, 2);
        System.out.println(integers);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        while(root != null) {
            if(root.val == val) {
                return root;
            }
            if(root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }
}
