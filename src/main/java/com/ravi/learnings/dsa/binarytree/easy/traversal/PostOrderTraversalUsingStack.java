package com.ravi.learnings.dsa.binarytree.easy.traversal;

import com.ravi.learnings.dsa.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Post order meaning Left Right Root
 * */

/*
            3
           / \
          9   20
         / \  / \
        1   2 15  7
*/
public class PostOrderTraversalUsingStack {
    public static void main(String[] args) {
        final var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(postorder(root));

    }

    // read Logic from info.md file
    public static List<Integer> postorder(TreeNode root) {

        List<Integer> li = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            final var pop = st.pop();
            li.add(pop.val);
            if(pop.left != null) {
                st.push(pop.left);
            }

            if(pop.right != null) {
                st.push(pop.right);
            }
        }
        Collections.reverse(li);
        return li;
    }
}
