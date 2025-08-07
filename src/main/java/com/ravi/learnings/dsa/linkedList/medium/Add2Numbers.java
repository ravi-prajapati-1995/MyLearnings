package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.ListNode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">problem link</a>
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class Add2Numbers {
    public static void main(String[] args) {
        final var integers = List.of(1, 2);
        final var head1 = ListNode.from(List.of(2, 4, 3));
        final var head2 = ListNode.from(List.of(5, 6, 4));
        final var listNode = addTwoNumbers(head1, head2);
        ListNode.print(listNode);
    }

    /**
     * Remember: When we need to create a new list or return a new list please keep 1st node as dummy node it makes life
     * easier
     *
     * 1. Iterate lists till both list reaches to the end
     * 2. Track the carry when we add elements
     * 3. Increase the sum when we get value
     * 4. When creating new node divide the sum by 10 as we can store till 9
     * 5. Get module of sum to calculate carry
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            newList.next = new ListNode(sum % 10);
            newList = newList.next;
            carry = sum / 10;
        }

        if (carry > 0) {
            newList.next = new ListNode(1);
        }
        return head.next;
    }
}
