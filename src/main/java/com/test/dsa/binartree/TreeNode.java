package com.test.dsa.binartree;

import lombok.Getter;

@Getter
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int val) {
        this.val = val;
    }
}
