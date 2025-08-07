package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCycle2 {
    public static void main(String[] args) {
        final var integers = List.of(3, 2, 1, 0, -1, -2, 8);
        final var head = ListNode.from(integers);
        ListNode.print(head);
    }

    /**
     * We can use hashing technique to find the first node where cycle starts,
     * if while storing we get node
     *
     * */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;

        while(temp != null) {
            final var add = set.add(temp);
            if(!add) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * <a href="https://takeuforward.org/data-structure/starting-point-of-loop-in-a-linked-list/">Post LInk</a>
     * 1. Check if the list has cycle using slow and fast pointer
     * 2. if yes, slow and fast pointer will point to the collision node
     * 3. Then in next step we will move one pointer to head, i.e slow = head
     * 4. Then again move iterate slow and fast by one by one
     * */
    public static ListNode hasCycleUsingTortoiseAndHareAlgo(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasLoop = false;

        //for odd number we have fast.next = null and for even number we have fast=null
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                hasLoop = true;
                break;
            }
        }

        if(hasLoop) {
            slow = head;

            while(fast != null) {
                slow = slow.next;
                fast = fast.next;

                if(slow == fast) {
                    return slow;
                }
            }
        }

        return null;
    }
}
