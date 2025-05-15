package com.test.dsa.binartree.traversal;

import com.test.dsa.binartree.Node;

public class TraversalBT {
    public static void main(String[] args) {
        final var root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inOrderTraversal(root);


    }

    /**
     * Inorder traversal (Left Root Right): 4 2 5 1 6 3 7
            1
          /  \
         2    3
        / \  / \
       1`  5  6  7
     * */
    public static void inOrderTraversal(Node node) {
        if(node.left == null) {
            System.out.print(node.getData() +" ");
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.getData() +" ");
        System.out.print(node.getRight().getData() + " ");

    }
}
