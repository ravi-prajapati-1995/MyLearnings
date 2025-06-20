package com.test.dsa.linkedList.hard;

import com.test.dsa.linkedList.ListNode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">Problem link</a>
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */
public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        final var integers = List.of(1, 2, 3, 4, 5, 6);
        final var head = ListNode.from(integers);
        final var listNode = reverseKGroup(head, 2);
        ListNode.print(listNode);
    }

    /**
     * Striver's Method
     * 1. getKth node, the function returns null if kth node not present
     * 2. If kth node is null break the loop as we reached in the last
     * 3. Store nextNode from kth node as we will mark kthNode.next = null
     * 4. Till now we didn't update temp it is pointing to head only
     * 5. Now reverse the temp, after reverse we need to update head for the first time
     * 6. for second group, after reverse we need to join first group last element to the second group first element
     */
    public static ListNode reverseKGroupStriver(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode temp = head;
        ListNode preNode = null;

        while (temp != null) {
            // because each time temp node will become the last node after reverse
            final var kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (preNode != null) {
                    preNode.next = temp;
                }
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            final var listNode = reverseRecursion(temp);

            //for the first time we need to update head,
            if (head == temp) {
                head = listNode;
            } else {
                preNode.next = listNode;
            }
            preNode = temp;
            temp = nextNode;
        }

        return head;
    }

    /**
     * To get the Kth node, if k element is not present then we will return null
     */
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

    /**
     * I did this code before watching the solution by striver, here is the steps
     * 1. I took start and end node which will contain start of group and end of group
     * 2. Then take count with will count the element I traverse , if count == k, then I will reverse that group
     * 3. Took lastNode to store the last element of the final node
     * 4. While traversing check for count if it is zero then assign temp to start
     * 5. if count == k, Store the nextNode, reverse this group , set count to and assign nextNode to temp that we
     * have stored
     * 6. In last if we have count >0 then to the last node assign the start
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode start = null;
        int count = 0;
        ListNode newHead = new ListNode(-1);
        ListNode lastNode = null;
        ListNode temp = head;
        while (temp != null) {
            if (count == 0) {
                start = temp;
            }
            count++;
            if (count == k) {
                ListNode nextNode = temp.next;
                temp.next = null;
                final var reverseNode = reverseRecursion(start);
                if (lastNode == null) {
                    lastNode = getLastNode(newHead);
                } else {
                    lastNode = getLastNode(lastNode);
                }

                lastNode.next = reverseNode;

                temp = nextNode;
                count = 0;
            } else {
                temp = temp.next;
            }
        }
        if (count > 0) {
            lastNode = getLastNode(lastNode);
            lastNode.next = start;
        }
        return newHead.next;
    }

    private static ListNode getLastNode(ListNode reverseNode) {
        while (reverseNode.next != null) {
            reverseNode = reverseNode.next;
        }
        return reverseNode;
    }

    public static ListNode reverseRecursion(ListNode head, ListNode to) {
        if (head == null || head == to) {
            return head;
        }

        ListNode newHead = reverseRecursion(head.next, to);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRecursion(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
