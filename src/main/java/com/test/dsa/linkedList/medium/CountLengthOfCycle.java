package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.ListNode;
import com.test.dsa.linkedList.Node;

import java.util.*;

/**
 * Given the head of a linked list, determine whether the list contains a loop.
 * If a loop is present, return the number of nodes in the loop, otherwise return 0.
 * <p>
 * Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist.
 * If c is 0, then there is no loop.
 */
public class CountLengthOfCycle {
    public static void main(String[] args) {
        final var integers = List.of(3, 2, 1, 0, -1, -2, 8);
        final var head = ListNode.from(integers);
        ListNode.print(head);
        System.out.println(countNodesinLoop(head));
    }

    public static int countNodesinLoop(ListNode head) {
        int count = 1;
        Map<ListNode, Integer> set = new HashMap<>();
        ListNode temp = head;

        while (temp != null) {
            final var add = set.put(temp, count);
            if (add != null && add < count) {
                return count - add;
            }
            count++;
            temp = temp.next;
        }
        return -1;
    }

    public static int countNodesinLoopOptimze(Node head) {
        Node slow = head;
        Node fast = head;

        boolean isLoop = false;

        while (fast != null || fast.next != null) {

            if (slow == fast) {
                isLoop = true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        int count = 0;
        if (isLoop) {
            while (fast != slow) {
                count++;
                fast = fast.next;
            }

            return count;
        }
        return 0;
    }
}
