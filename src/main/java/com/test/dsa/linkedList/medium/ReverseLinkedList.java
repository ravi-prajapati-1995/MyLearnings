package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.ListNode;

import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        final var integers = List.of(3, 2, 1, 0, -1, -2, 8);
        final var head = ListNode.from(integers);
        final var listNode = reverseUsingPointers(head);
        ListNode.print(listNode);
    }

    /**
     * Using stack we can reverse a linked list
     * */
    public static ListNode reverseList(ListNode head) {
        final var list = new LinkedList<Integer>();

        ListNode temp = head;
        while(temp != null ) {
            list.push(temp.val);
            temp = temp.next;
        }


        temp = head;
        while(temp != null ) {
            temp.val = list.poll();
            temp = temp.next;
        }

        return head;
    }

    /**
     * Here we will change the pointer we are pointing current next to the previous for all the elements
     *
     * TC - o(n)
     * SC - O(1)
     * */
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
        return  curr;
    }

}
