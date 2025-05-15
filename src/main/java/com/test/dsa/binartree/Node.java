package com.test.dsa.binartree;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Node {
    private int data;
    public Node left;
    public Node right;

    public Node(final int data) {
        this.data = data;
    }
}
