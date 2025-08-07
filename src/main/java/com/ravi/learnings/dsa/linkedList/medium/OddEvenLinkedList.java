package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/odd-even-linked-list/description/">Problem Link</a>
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by
 * the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        final var integers = List.of(1, 2, 3, 4, 5, 6);  // 1 3 5 2 4 6
        final var head = ListNode.from(integers);
        final var listNode = oddEvenListOptimal(head);
        ListNode.print(listNode);
    }

    /**
     * We will create two list one will contain odd number and another contain even then concat
     * those list
     * 1. Create two list one will have odd position elements and second will have even position element
     * 2. Then first iterate odd List and replace linked list element with each element
     * 3. Do same for even list
     * 4. Finally we will have list that will first have odd number of element and after that elements that are
     * on even number
     */
    public static ListNode oddEvenListBruteForce(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final List<Integer> odd = new ArrayList<>();
        final List<Integer> even = new ArrayList<>();
        int count = 1;

        ListNode temp = head;

        while (temp != null) {
            if (count % 2 == 0) {
                even.add(temp.val);
            } else {
                odd.add(temp.val);
            }
            count++;
            temp = temp.next;
        }

        temp = head;

        for (Integer intVal : odd) {
            temp.val = intVal;
            temp = temp.next;
        }

        for (Integer intVal : even) {
            temp.val = intVal;
            temp = temp.next;
        }
        return head;
    }

    /**
     * Given: 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * Result: 1 -> 3 -> 5 -> 2 -> 4 -> 6
     * */
    public static ListNode oddEvenListOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // Here why we are checking event: Because even will be always remain ahead of odd,
        // Why checking even.next: Because we are jumping 2 point if even.next will be null it will throw NullPointerException
        while (even != null && even.next != null) {
            // in starting odd will at 1 and 1.next = 3 after that moving odd = 1.next which will be 3 now odd will point to 3
            odd.next = odd.next.next;
            odd = odd.next;

            // even point to 2 2.next = 4 and then we are doing even = 2.next which will point to 4
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
