package com.test.dsa.linkedList;

import java.util.List;

public class Node {

    public int data;

    public Node next;

    public Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static Node from(List<Integer> list) {
        Node head = new Node(list.getFirst());
        Node prev = head;
        for (int i = 1; i < list.size(); i++) {
            final var listNode = new Node(list.get(i));
            prev.next = listNode;
            prev = listNode;
        }
        return head;
    }

    public static void print(Node head) {
        var temp = head;

        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
