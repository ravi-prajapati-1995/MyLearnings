package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.ListNode;

import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        final var integers = List.of(3, 2, 1, 0, -1, -2, 8);
        final var head = ListNode.from(integers);
        final var listNode = reverseUsingPointers(head);
//        final var listNode = reverseRecursion(head);
        ListNode.print(listNode);
    }

    /**
     * Using stack we can reverse a linked list
     */
    public static ListNode reverseList(ListNode head) {
        final var list = new LinkedList<Integer>();

        ListNode temp = head;
        while (temp != null) {
            list.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.val = list.poll();
            temp = temp.next;
        }

        return head;
    }

    /**
     * Here we will change the pointer we are pointing current next to the previous for all the elements
     *
     * <p>
     * TC - o(n)
     * SC - O(1)
     */
    public static ListNode reverseUsingPointers(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;
        ListNode curr = null;

        while (temp != null) {
            curr = temp;
            temp = temp.next;
            curr.next = prev;
            prev = curr;
        }
        return curr;
    }

    /**
     * We can do it using recursion if we have
     * 1 2 3 4 5
     * we call for 2 3 4 5 and  3 4 5 so on till head.next can't be null
     * After that we make link 5.next = 4 and 4.next = null
     * and return newHead which will be 5 -> 4
     * then in recursion head -> 3, newHead = 5, 4
     *
     * In this way we can reverse it
     *
     * <a href="https://takeuforward.org/data-structure/reverse-a-linked-list/">SOlution Article</a>
     * [TODO] Revisit it after recursion completion
     * */
    public static ListNode reverseRecursion(ListNode head) {
        if(head == null || head.next == null) {
             return head;
        }

        ListNode newHead = reverseRecursion(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
