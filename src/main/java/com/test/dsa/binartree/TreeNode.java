package com.test.dsa.binartree;

import com.sun.source.tree.Tree;
import lombok.Getter;

import java.util.List;

@Getter
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int val) {
        this.val = val;
    }

    public static TreeNode from(List<Integer> data) {
        TreeNode root = null;
        for(int val: data) {
            root = insertIntoBST(root, val);
        }
        return root;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;

        while (true) {
            if (temp.val >= val) {
                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    temp.left = new TreeNode(val);
                    break;
                }
            } else {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
