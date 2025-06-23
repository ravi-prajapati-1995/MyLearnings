package com.test.dsa.linkedList.hard;

import com.test.dsa.linkedList.Node;

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
        final var listNode = flattenOptimalUsingRecursion(head);
        printBottom(listNode);
    }

    /**
     * In this solution we take the two nodes and merge them using two pointer in sorted order
     * 1. Create a merge function that will took two nodes and merge them in sorted order
     * 2. Result that is returned by this function will be sorted in merged and and in next call we call function with
     * merged node
     * TC - O(N) + O(n1+n2) (to merge the elements)
     * */
    public static Node flattenOptimal(Node root) {
        Node temp = root;
        Node mergedNode = null;
        while(temp != null) {
            mergedNode = mergeNode(mergedNode, temp);
            printBottom(mergedNode);
            temp = temp.next;
        }
        return mergedNode;
    }

    /**
     * In recursion we used the same function mergeNode
     * 1. We call flatten function recursively
     * 2. Add base case we will return node if node.next will be null
     * 3. Then we will use return value and current node and merge them
     * 4. In last we will return the merged node
     *
     * TC -> N(for recursion) + O(n1+n2) (for merging the nodes)
     * SC -> O(n) (recursive stack space)
     * */
    public static Node flattenOptimalUsingRecursion(Node root) {
        if(root.next == null) {
            return root;
        }

        final var node = flattenOptimalUsingRecursion(root.next);
        return mergeNode(root, node);
    }

    private static void printBottom(final Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data +" ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    private static Node mergeNode(final Node l1, final Node l2) {
        if(l1 == null) {
            return  l2;
        }
        if(l2 == null) {
            return l1;
        }
        Node dummyNode = new Node(-1);
        Node newHead = dummyNode;
        Node t1 = l1;
        Node t2 = l2;

        while(t1 != null && t2 != null) {
            int val;
            if(t1.data < t2.data) {
                val = t1.data;
                t1 = t1.bottom;
            } else {
                val = t2.data;
                t2 = t2.bottom;
            }

            dummyNode.bottom = new Node(val);
            dummyNode = dummyNode.bottom;
            dummyNode.next = null;
        }

        if(t1 != null) {
            dummyNode.bottom = t1;
        }

        if(t2 != null) {
            dummyNode.bottom = t2;
        }

        return newHead.bottom;
    }

    /**
     * In Brute force approach
     * 1. Parse list for each next node and add value in list
     * 2. For each next node parse all the child and store it in list
     * 3. Sort the list
     * 4. Write a convert function that will convert list of integers to Node
     *
     * TC -> O(n*m) (Traverse the List) + O(XLogX) (To sort the list where x is no of total nodes) +O(n*m) (for
     * convert function taking all the elements)
     * SC -> O(n*m) (to store the elements in the list) + O(n*m) ( As we creating new linked list that will be returned)
     * */
    public static Node flattenBruteForce(Node root) {
        // code here
        List<Integer> list = new ArrayList<>();
        Node temp = root;
        while (temp != null) {
            list.add(temp.data);
            Node temp1 = temp.bottom;
            while (temp1 != null) {
                list.add(temp1.data);
                temp1 = temp1.bottom;
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
            prev.bottom = curr;
            prev = curr;
        }
        return node.bottom;
    }

    static class Node {
        int data;
        Node next;
        Node bottom;

        Node() {
            data = 0;
            next = null;
            bottom = null;
        }

        Node(int data1) {
            data = data1;
            next = null;
            bottom = null;
        }

        Node(int data1, Node next1, Node next2) {
            data = data1;
            next = next1;
            bottom = next2;
        }

        public static Node from(List<Integer> list, List<List<Integer>> childs) {
            Node head = new Node(-1);
            Node prev = head;
            for (int i = 0; i < list.size(); i++) {
                final var listNode = new Node(list.get(i));
                listNode.bottom = from(childs.get(i));
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
                prev.bottom = listNode;
                prev = listNode;
            }
            return head.bottom;
        }

        public static void print(Node head) {
            var temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                Node child1 = temp.bottom;
                System.out.print("=====> ");
                while (child1 != null) {
                    System.out.print(child1.data + " ");
                    child1 = child1.bottom;
                }
                temp = temp.next;
                System.out.println();
            }
        }
    }
}
