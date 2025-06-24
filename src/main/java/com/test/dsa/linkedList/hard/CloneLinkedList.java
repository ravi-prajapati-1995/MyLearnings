package com.test.dsa.linkedList.hard;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/description/">Problem Link</a>
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * <p>
 * For this we need to create deep copy , and return that node head
 */
public class CloneLinkedList {

    public static void main(String[] args) {
        final var integers = List.of(7, 13, 11, 10, 1);
        final var randoms = List.of(0, 7, 1, 11, 7);

        final var head = Node.from(integers, randoms);
        printWithRandom(head);
        final var node = copyRandomList(head);
        System.out.println("-----------------------");
        printWithRandom(node);
    }


    /**
     * This is brute force by striver:
     * 1. Create a Map<Node, Node> which will have old node as key and new node as value
     * 2. Traverse the old node and create a new node
     * 3. After creating new node put old node and new node in the map
     * 4. After map created now its time to put links, again traverse the list
     * 5. Get the newNode corresponding to temp
     * 6. Assign new node next to the map.get(temp.next)
     * 7. Assign new node random to map.get(tem.random)
     *
     * SC - O(N) +-O
     * */
    public static Node copyRandomListStriverBruteForce(Node head) {
        Node temp = head;
        Map<Node, Node> map = new HashMap<>();
        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            final var newNode = map.get(temp);
            newNode.next = map.get(temp.next);
            newNode.random = map.get(temp.random);

            temp = temp.next;
        }
        return map.get(head);
    }
    /**
     * My code is not worked need to figure out why???
     * */
    public static Node copyRandomList(Node head) {

        Node newHead = new Node(-1);
        Map<Integer, Node> map = new HashMap<>();
        Node newh = newHead;
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newh.next = new Node(newNode.val);
            map.put(newNode.val, newNode);
            newh = newh.next;
            temp = temp.next;
        }

        System.out.println(map);
        newh = newHead.next;
        temp = head;

        while (temp != null) {
            final var random = temp.random;

            if(random != null) {
                System.out.println(random.val);
                newh.random = map.get(random.val);
            }
            newh = newh.next;
            temp = temp.next;
        }

        return newHead.next;
    }

    private static void printWithRandom(final Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.random != null) {
                System.out.print("---------> " + temp.random.val + "("+temp.random+")");
            }

            System.out.println();
            temp = temp.next;
        }
    }
}

class Node {
    int val;
    Node next;
    Node random;

    Node() {
        val = 0;
        next = null;
        random = null;
    }

    Node(int data1) {
        val = data1;
        next = null;
        random = null;
    }

    Node(int data1, Node next1, Node next2) {
        val = data1;
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
            System.out.print(temp.val + " ");
            Node child1 = temp.random;
            System.out.print("=====> ");
            while (child1 != null) {
                System.out.print(child1.val + " ");
                child1 = child1.random;
            }
            temp = temp.next;
            System.out.println();
        }
    }
}
