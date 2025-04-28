package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.ListNode;

import java.util.*;

public class CountLengthOfCycle {
    public static void main(String[] args) {
        final var integers = List.of(3, 2, 1, 0, -1, -2, 8);
        final var head = ListNode.from(integers);
        ListNode.print(head);
    }

    public ListNode getCycleCount(ListNode head) {
        int count = 1;
        Map<ListNode, Integer> set = new HashMap<>();
        ListNode temp = head;

        while(temp != null) {
            final var add = set.put(temp, count);
            if(add < count) {
                return temp;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }
}
