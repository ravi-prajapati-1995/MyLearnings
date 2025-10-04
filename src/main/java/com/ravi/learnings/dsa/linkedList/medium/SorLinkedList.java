package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

import static com.ravi.learnings.dsa.linkedList.ListNode.from;
import static com.ravi.learnings.dsa.linkedList.ListNode.print;

/**
 * <a href="https://leetcode.com/problems/sort-list/description/">Problem Link</a>
 * <p>
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 */
public class SorLinkedList {
    public static void main(String[] args) {
        final var integers = List.of(1, 3, 4, 2, 2);  // 1 3 5 2 4 6
        final var head = from(integers);
        final var listNode = sortList(head);
        print(listNode);
    }

    /**
     * Brute Force:
     * 1. Traverse the list and store it in and Array
     * 2. After storing the array sort the array
     * 3. Now traverse the array and list one by one and push the values in the linked list
     * <p>
     * TC - O(N + NlogN + N)
     * SC - O(N)
     */
    public static ListNode sortListBruteForce(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        final var sortedList = list.stream().sorted().toList();

        temp = head;
        for (int value : sortedList) {
            temp.val = value;
            temp = temp.next;
        }

        return head;
    }

    /**
     * In optimal solution we will use merge sort technique steps are below:
     * 1. Find the mid
     * 2. Sort the left half
     * 3. Sort the right half
     * 4. Merge left and right half
     * 5. Return the merged linked list
     */
    public static ListNode sortList(ListNode head) {
        //base case when head is null or head.next is null meaning list contains only one element
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;
        final var sortedHead = sortList(leftHead);
        final var sortedRightHead = sortList(rightHead);

        return merge(sortedHead, sortedRightHead);
    }

    private static ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode listNode = new ListNode(-1);
        ListNode temp = listNode;
        while (leftHead != null && rightHead != null) {
            int leftVal = leftHead.val;
            int rightVal = rightHead.val;

            if (leftVal > rightVal) {
                temp.next = rightHead;
                rightHead = rightHead.next;
            } else {
                temp.next = leftHead;
                leftHead = leftHead.next;
            }

            temp = temp.next;
        }

        if (leftHead != null) {
            temp.next = leftHead;
        } else {
            temp.next = rightHead;
        }

        return listNode.next;
    }

    private static ListNode findMiddle(final ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //[todo] Why here we start fast with head.next previously we are starting it with head only
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
