package com.test.dsa.linkedList;

import java.util.List;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode from(List<Integer> list) {
        ListNode head = new ListNode(list.getFirst());
        ListNode prev = head;
        for (int i = 1; i < list.size(); i++) {
            final var listNode = new ListNode(list.get(i));
            prev.next = listNode;
            prev = listNode;
        }
        return head;
    }

    public static void print(ListNode head) {
        var temp = head;

        while(temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
