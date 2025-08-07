package com.ravi.learnings.dsa.binartree.easy;

import com.ravi.learnings.dsa.binartree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public static void main(String[] args) {
        final var root = new TreeNode(1);
        root.left = new TreeNode(-1);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        final var integers = preorderTraversal(root);
        System.out.println(integers);

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        final var arrayList = new ArrayList<Integer>();
        preOrderTraversal(root, arrayList);
        return arrayList;
    }
    public static List<Integer> preorderTraversalItrative(TreeNode root) {
        final var arrayList = new ArrayList<Integer>();

        return arrayList;
    }

    public static void preOrderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        preOrderTraversal(treeNode.left, list);
        preOrderTraversal(treeNode.right, list);
    }
}
