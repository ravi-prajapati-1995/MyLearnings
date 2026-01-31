package com.ravi.learnings.dsa.binarytree.traversal;

import com.ravi.learnings.dsa.binarytree.TreeNode;

import java.util.List;

public class TraversalBT {
    public static void main(String[] args) {
        final var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
                inOrderTraversal(root);
//        preOrderTraversal(root);
    }

    /**
     * Inorder traversal (Left Root Right): 4 2 5 1 6 3 7
     * 1
     * /  \
     * 2    3
     * / \  / \
     * 1   5  6  7
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

    /**
     * In pre-order traversal we traverse: Root left right
     * 1
     * /  \
     * 2    3
     * / \  / \
     * 1   5  6  7
     * Result would be: 1 2 1 5 3 6 7
     */
    public static void preOrderTraversal(TreeNode node, List<Integer> integers) {
        if (node == null) { // when parent is null
            return;
        }
        integers.add(node.val);
        preOrderTraversal(node.left, integers);
        preOrderTraversal(node.right, integers);
    }

    /**
     * In post order traversal: Left Right Root
     * */
    public static void postOrderTraversal(TreeNode node, List<Integer> li) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left, li);
        postOrderTraversal(node.right, li);
        li.add(node.val);
    }
}
