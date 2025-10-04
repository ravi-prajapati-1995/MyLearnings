package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.ListNode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/">Problem Link</a></br>
 */
public class RemoveNthNodeFromLast {
    public static void main(String[] args) {
        final var integers = List.of(1, 2, 3);  // 1 3 5 2 4 6
        final var head = ListNode.from(integers);
        final var listNode = removeNthFromEndOptimal(head, 3);
        ListNode.print(listNode);
    }

    /**
     * 1. In first iteration count the total number of nodes
     * 2. Then subtract n from total number then we will get which node should be removed
     * 3. When reaching the node change the pointer to next to next
     * 3. return head
     * SC - O(N)
     * TC - O(N) + O(N) it would be approximately ~O(2n)
     */
    public static ListNode removeNthFromEndBruteForce(ListNode head, int n) {
        int total = 0;
        ListNode temp = head;

        while (temp != null) {
            total++;
            temp = temp.next;
        }

        // Edge case when we need to remove head
        if (total == n) {
            return head.next;
        }

        int removedIdx = total - n;

        int count = 0;

        temp = head;
        while (temp != null) {
            count++;
            if (removedIdx == count) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    /**
     * Given: 1 -> 2 -> 3 -> 4 -> 5 -> 6   n=2
     * Result: 1 -> 2 -> 3 -> 4 -> 6
     * <p>
     * 1. Take a fast pointer and moved it to till n, in our example it will point to 3
     * 2. Take a slow pointer that will initially point to head
     * 3. Move slow and fast simultaneously one by one till fast.next != null
     * 4. so slow pointer will reach at 4 when fast reach at 6
     * 5. we will make slow.next = slow.next.next
     */
    public static ListNode removeNthFromEndOptimal(ListNode head, int n) {
        ListNode fast = head;

        // Moving fast pointer to the given number
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (fast == null) {
            return slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
