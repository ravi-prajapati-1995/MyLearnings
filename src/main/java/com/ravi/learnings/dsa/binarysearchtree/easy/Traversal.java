package com.ravi.learnings.dsa.binarysearchtree.easy;

import com.ravi.learnings.dsa.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.ravi.learnings.dsa.binarytree.easy.PreOrderTraversal.preOrderTraversal;

public class Traversal {
    public static void main(String[] args) {
        final var treeNode = TreeNode.from(List.of(4, 2, 6, 1, 3, 5, 7));

        final var integers = preorderTraversal(treeNode);
        System.out.println(integers);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        final var arrayList = new ArrayList<Integer>();
        preOrderTraversal(root, arrayList);
        return arrayList;
    }
}
