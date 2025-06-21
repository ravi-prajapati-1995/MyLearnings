package com.test.dsa.linkedList.hard;

import com.test.dsa.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1">Problem Link</a>
 * Given a linked list containing n head nodes where every node in the linked list contains two pointers:
 * (i) next points to the next node in the list.
 * (ii) bottom pointer to a sub-linked list where the current node is the head.
 * Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data.
 * Your task is to flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.
 * <p>
 * Note:
 * 1. ↓ represents the bottom pointer and -> represents the next pointer.
 * 2. The flattened list will be printed using the bottom pointer instead of the next pointer.
 */
public class FlattingTheLL {

    public static void main(String[] args) {
        final var integers = List.of(5, 10, 19, 28);
        final var childs = List.of(List.of(7, 8, 30), List.of(20), List.of(22, 50), List.of(35, 40, 45));

        final var head = Node.from(integers, childs);
        Node.print(head);
        final var listNode = flattenBruteForce(head);
        System.out.println(listNode);
    }

    /**
     * In Brute force approach
     * 1. Parse list for each next node and add value in list
     * 2. For each next node parse all the child and store it in list
     * 3. Sort the list
     * 4. Write a convert function that will convert list of integers to Node
     * */
    public static Node flattenBruteForce(Node root) {
        // code here
        List<Integer> list = new ArrayList<>();
        Node temp = root;
        while (temp != null) {
            list.add(temp.val);
            Node temp1 = temp.child;
            while (temp1 != null) {
                list.add(temp1.val);
                temp1 = temp1.child;
            }
            temp = temp.next;
        }

        System.out.println(list);
        list.sort(Integer::compareTo);

        return convertToNode(list);
    }

    private static Node convertToNode(final List<Integer> sorted) {
        Node node = new Node(-1);
        Node prev = node;
        for(int i: sorted) {
            final var curr = new Node(i);
            prev.child = curr;
            prev = curr;
        }
        return node.child;
    }

    static class Node {
        int val;
        Node next;
        Node child;

        Node() {
            val = 0;
            next = null;
            child = null;
        }

        Node(int data1) {
            val = data1;
            next = null;
            child = null;
        }

        Node(int data1, Node next1, Node next2) {
            val = data1;
            next = next1;
            child = next2;
        }

        public static Node from(List<Integer> list, List<List<Integer>> childs) {
            Node head = new Node(-1);
            Node prev = head;
            for (int i = 0; i < list.size(); i++) {
                final var listNode = new Node(list.get(i));
                listNode.child = from(childs.get(i));
                prev.next = listNode;
                prev = listNode;
            }
            return head.next;
        }

        public static Node from(List<Integer> list) {
            Node head = new Node(-1);
            Node prev = head;
            for (int i = 0; i < list.size(); i++) {
                final var listNode = new Node(list.get(i));
                prev.child = listNode;
                prev = listNode;
            }
            return head.child;
        }

        public static void print(Node head) {
            var temp = head;

            while (temp != null) {
                System.out.print(temp.val + " ");
                Node child1 = temp.child;
                System.out.print("=====> ");
                while (child1 != null) {
                    System.out.print(child1.val + " ");
                    child1 = child1.child;
                }
                temp = temp.next;
                System.out.println();
            }
        }
    }
}
