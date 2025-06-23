package com.test.dsa.linkedList.hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/description/">Problem Link</a>
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * For this we need to create deep copy , and return that node head
 */
public class CloneLinkedList {

    public static void main(String[] args) {
        final var integers = List.of(5, 10, 19, 28);
        final var randoms = List.of(28, 0, 5, 19);

        final var head = Node.from(integers, randoms);
        printWithRandom(head);
    }

    private static void printWithRandom(final Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if(temp.random != null) {
                System.out.print("---------> " + temp.random.data);
            }

            System.out.println();
            temp = temp.next;
        }
    }
}

class Node {
    int data;
    Node next;
    Node random;

    Node() {
        data = 0;
        next = null;
        random = null;
    }

    Node(int data1) {
        data = data1;
        next = null;
        random = null;
    }

    Node(int data1, Node next1, Node next2) {
        data = data1;
        next = next1;
        random = next2;
    }

    public static Node from(List<Integer> list, List<Integer> random) {
        Node head = new Node(-1);
        Node prev = head;
        Map<Integer, Node> valueByNode = new HashMap<>(random.size());
        for (int i = 0; i < list.size(); i++) {
            final var data1 = list.get(i);
            final var listNode = new Node(data1);
            valueByNode.put(data1, listNode);
            prev.next = listNode;
            prev = listNode;
        }
        Node temp = head.next;

        int idx = 0;
        while (temp != null) {
            temp.random = valueByNode.get(random.get(idx));
            idx++;
            temp = temp.next;
        }

        return head.next;
    }

    public static Node from(List<Integer> list) {
        Node head = new Node(-1);
        Node prev = head;
        for (int i = 0; i < list.size(); i++) {
            final var listNode = new Node(list.get(i));
            prev.random = listNode;
            prev = listNode;
        }
        return head.random;
    }

    public static void print(Node head) {
        var temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            Node child1 = temp.random;
            System.out.print("=====> ");
            while (child1 != null) {
                System.out.print(child1.data + " ");
                child1 = child1.random;
            }
            temp = temp.next;
            System.out.println();
        }
    }
}
