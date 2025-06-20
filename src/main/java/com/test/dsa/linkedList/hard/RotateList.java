package com.test.dsa.linkedList.hard;

import com.test.dsa.linkedList.ListNode;

import java.util.List;

import static com.test.dsa.linkedList.ListNode.from;
import static com.test.dsa.linkedList.ListNode.print;

/**
 * <a href="https://leetcode.com/problems/rotate-list/description/">Problem Link</a> </br>
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places.
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */
public class RotateList {
    public static void main(String[] args) {
        final var integers = List.of(1, 2, 3, 4, 5);  // 1 3 5 2 4 6
        final var head = from(integers);
        final var listNode = rotateRightStriver(head, 2);
        print(listNode);
    }

    /**
     * This solution is without watching solution
     * 1. Edge case head can be null, and length can 0 and k can be larger than actual length
     * 2. After that we iterate the list till k
     * 3. When we reached to k then put next element to nextHead,
     * 4. Then temp.next to null because it will be last element after rotation and break the loop
     * 5. after that from the new head got the last element then we assigned lastNode.next to head and return new head
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int listLength = getListLength(head);
        if (k == 0) {
            return head;
        }
        k = k % listLength;

        if (listLength == k) {
            return head;
        }

        ListNode temp = head;
        ListNode newHead = null;
        while (temp != null) {
            listLength--;
            if (listLength == k) {
                newHead = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }

        final var lastNode = getLastNode(newHead);
        lastNode.next = head;
        return newHead;
    }

    /**
     * 1. Check for the edge cases
     * 2. Calculate the length of list and got the tail element as we need it
     * 3. Assign tail.next to head
     * 4. Traverse list till to find the kth element
     * 5. Update head to kthNode.next
     * 6. Then mark kthNode.next = null, to break the circle
     * */
    public static ListNode rotateRightStriver(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        if (k % len == 0) return head;

        k = k % len;

        tail.next = head;

        final var kthNode = getKthNode(head, len - k);
        head = kthNode.next;
        kthNode.next = null;

        return head;
    }

    private static ListNode getKthNode(final ListNode head, final int k) {
        ListNode temp = head;
        int count = 1;
        while (temp.next != null && count != k) {
            count++;
            temp = temp.next;
        }

        if (count < k) {
            return null;
        }

        return temp;
    }

    private static int getListLength(final ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    private static ListNode getLastNode(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}
