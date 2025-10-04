package com.ravi.learnings.dsa.binartree.traversal;

import com.ravi.learnings.dsa.binartree.TreeNode;

public class TraversalBT {
    public static void main(String[] args) {
        final var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        inOrderTraversal(root);
    }

    /**
     * Inorder traversal (Left Root Right): 4 2 5 1 6 3 7
     * 1
     * /  \
     * 2    3
     * / \  / \
     * 1`  5  6  7
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node.left == null) {
            System.out.print(node.val + " ");
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        System.out.print(node.getRight().val + " ");
    }
}
