package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.ListNode;

import java.util.List;

public class FindMiddleOfLinkedList {
    public static void main(String[] args) {
        final var integers = List.of(3, 2, 1, 0, -1, -2, 8);
        final var head = ListNode.from(integers);
        final var listNode = middleNodeOtpimal(head);
        ListNode.print(listNode);
    }

    /**
     * Using Hare and Tortoise Algo (slow and fast pointer)
     * we will have a slow pointer which move one step at a time
     * and fast pointer which moves 2 steps at a time
     * When fast pointer will at end low will be at mid
     * we need to check if fastPointer != null and fastPointer.next != null because in case of odd number .next
     * points to null and in case of even number of elements it will stand fastPointer to null
     * <p>
     * TC = O(n/2)
     * SC -> O(1)
     */
    public static ListNode middleNodeOtpimal(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    /**
     * <a href="https://www.youtube.com/watch?v=7LjQ57RqgEc">Video link</a>
     * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Problem Link</a>
     * This is brute force solution in which we will first calculation the length of linked list
     * And after that we will traversing linked list again and stop at the mid
     * we are calculation mid  = n/2 + 1, because if there are even numbers we need to give second node
     * <p>
     * TC - O(n) + O(n/2)
     * SC - O(1)
     */
    public static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = (count / 2) + 1;

        temp = head;
        count = 0;

        while (temp != null) {
            count++;

            if (count == mid) {
                return temp;
            }

            temp = temp.next;
        }
        return head;
    }
}
