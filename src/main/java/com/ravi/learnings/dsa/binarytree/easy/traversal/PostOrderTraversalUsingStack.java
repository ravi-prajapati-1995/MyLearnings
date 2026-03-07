package com.ravi.learnings.dsa.binarytree.easy.traversal;

import com.ravi.learnings.dsa.binarytree.TreeNode;

import java.util.ArrayList;
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

    }

    public List<Integer> postorder(TreeNode root) {

        List<Integer> li = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            if(root.right != null) {
                st.push(root.right);
            }

            if(root.left != null) {
                st.push(root.left);
            }



        }
        return li;
    }
}
