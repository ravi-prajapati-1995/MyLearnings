package com.ravi.learnings.dsa.binartree;

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

    /**
     * While inserting any element in BST
     *
     *        4
     *      /   \
     *     2     6
     *    / \   / \
     *   1   3 5   7
     *
     * Suppose we have above BST and need to insert 8
     * 1. Start with root check if coming value is greater than root.val if yes
     * 2. Move Right, then check if right is not null, if yes create a new node and point temp.right to that
     * 3. if right not null then move till we found null
     * 4. If current val is less than val then move left and check left and val again in same way
     * 5. When we found null value then insert current node there
     *
     * */
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
