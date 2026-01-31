package com.ravi.learnings.dsa.binarytree.traversal;

import com.ravi.learnings.dsa.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * In pre-order traversal we traverse: Root left right
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 1   5  6  7
 * Result would be: 1 2 1 5 3 6 7
 * So instead of recursive solution we need to implement it using iterative way
 * Intuition behind it that we will keep adding node in stack, then first check for right node if exist add in stack
 * Then check for left if exist then push to stack -- We need to check right first after that left because in stack when
 * we will get element we get it from top
 */
public class PreOrderTraversalIterative {
    public static void main(String[] args) {
        final var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(preorder(root));
    }

    /**
     * 1. Add root in the stack
     * 2. Then add right and left node in stack
     * */
    public static List<Integer> preorder(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        if (root == null) {
            return li;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.empty()) {
            final var pop = st.pop();
            li.add(pop.val);

            if(pop.right != null) {
                st.push(pop.right);
            }

            if(pop.left != null) {
                st.push(pop.left);
            }

        }
        return li;
    }
}
