package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.Node;

import java.util.List;

/**
 * Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only.
 * Your task is to rearrange the list so that all 0s appear at the beginning,
 * followed by all 1s, and all 2s are placed at the end.
 * <a href="https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1">Problem</a>
 */
public class SortLinkedList0s1s2s {
    public static void main(String[] args) {
        final var integers = List.of(0, 1, 0, 2, 1, 0, 0);  // 1 3 5 2 4 6
        final var head = Node.from(integers);
        final var listNode = segregateOptimal(head);
        Node.print(listNode);
    }

    /**
     * In Brute force approach we can maintain 3 variable which will count 0, 1, 2 after that we will iterate the head
     * and add element till the count of each
     * <p>
     * TC - O(2n) -- Because we need to iterate linkedlist two times
     * SC - O(1) -- we are using constants only
     */
    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        int _0sCount = 0;
        int _1sCount = 0;
        int _2sCount = 0;
        while (temp != null) {
            int val = temp.data;
            if (val == 0) {
                _0sCount++;
            } else if (val == 1) {
                _1sCount++;
            } else {
                _2sCount++;
            }
            temp = temp.next;
        }

        temp = head;

        while (_0sCount > 0) {
            temp.data = 0;
            temp = temp.next;
            _0sCount--;
        }

        while (_1sCount > 0) {
            temp.data = 1;
            temp = temp.next;
            _1sCount--;
        }

        while (_2sCount > 0) {
            temp.data = 2;
            temp = temp.next;
            _2sCount--;
        }

        return head;
    }

    /**
     * Here we took three nods and initialize them with -1 because if we are not initializing them with -1 we need to add
     * check if(head0 == null) do this else same for head1 and head2 by using extra node we reduced extra if else
     * This also solves issue when we are connecting head with dummy otherwise we need to add multiple checks
     * 1. Take three node and initialize all with -1
     * 2. Take dummy0, dummy1 and dummy2 to track the head
     * 3. Add elements in each node depending on value
     * 4. after all iteration connect head0 with dummy1 and head1 with dummy 2 based on conditions
     * */
    static Node segregateOptimal(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        Node head0 = new Node(-1);
        Node dummy0 = head0;

        Node head1 = new Node(-1);
        Node dummy1 = head1;

        Node head2 = new Node(-1);
        Node dummy2 = head2;

        while (temp != null) {
            final var data = temp.data;
            if (data == 0) {
                head0.next = temp;
                head0 = head0.next;
            } else if (data == 1) {
                head1.next = temp;
                head1 = head1.next;
            } else {
                head2.next = temp;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        //When we don't have any 1s we will directly add dummy2.next,
        if(dummy1.next == null) {
            head0.next = dummy2.next;
        } else {
            head0.next = dummy1.next;
            head1.next = dummy2;
        }
        head2.next = null;

        return dummy0;
    }
}
