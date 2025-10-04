package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.ListNode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/">Problem Link</a>
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        final var integers = List.of(1, 2, 3, 4);  // 1 3 5 2 4 6
        final var head = ListNode.from(integers);
        final var listNode = deleteMiddle(head);
        ListNode.print(listNode);
    }

    /**
     * Base on slow and fast pointer approach
     */
    public static ListNode deleteMiddle(ListNode head) {

        /* If the list is empty or has only one node,
         * return null as there is no middle node to delete
         */
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = prev.next.next;
        return head;
    }
}
