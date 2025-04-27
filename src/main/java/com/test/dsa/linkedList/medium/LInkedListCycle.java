package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *<a href="https://leetcode.com/problems/linked-list-cycle/description/">Problem Link</a>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * */
public class LInkedListCycle {
    public static void main(String[] args) {
        final var integers = List.of(3, 2, 1, 0, -1, -2, 8);
        final var head = ListNode.from(integers);
        ListNode.print(head);
    }

    public static boolean hasCycle(ListNode head) {
        Set<Integer> hascodes = new HashSet<>();

        ListNode temp = head;
        while(temp != null) {
            final var add = hascodes.add(temp.hashCode());
            if(!add) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    /**
     * We can use slow and fast pointer approach to find the cycle in the linked list
     * if slow pointer become equal to each other then we can say there is loop in linked list
     *
     * But there may be change they can override each other, how they we can ensure they are equal
     *
     * if there are cycle in linked list there with each step gap will be decrease by 1, in cycle
     * */
    public static boolean hasCycleUsingTortoiseAndHareAlgo(ListNode head) {
        Set<Integer> hascodes = new HashSet<>();

        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null) {
            final var add = hascodes.add(slow.hashCode());
            final var add2 = hascodes.add(fast.hashCode());
            if(!add || !add2) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
