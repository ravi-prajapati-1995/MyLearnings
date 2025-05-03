package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.ListNode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/odd-even-linked-list/description/">Problem Link</a>
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by
 * the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 * */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        final var integers = List.of(1, 2, 3, 4, 5, 6);  // 1 3 5 2 4 6
        final var head = ListNode.from(integers);
        ListNode.print(head);
    }


    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;

        ListNode even = head.next;
        ListNode eventBackup = even;
        int count = 3;

        ListNode temp = even.next;
        while(temp != null) {

        }

        return  null;
    }
}
