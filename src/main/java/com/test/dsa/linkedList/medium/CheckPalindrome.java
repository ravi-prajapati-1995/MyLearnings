package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.youtube.com/watch?v=lRY_G-u_8jk">Video Link</a>
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">Problem link</a>
 * */
public class CheckPalindrome {
    public static void main(String[] args) {
        final var integers = List.of(1, 2);
        final var head = ListNode.from(integers);
        System.out.println(isPalindromeOptimal(head));
//        ListNode.print(reverse);
//        System.out.println(isPalindrome(head));
    }

    /**
     * In this solution we used stack and storing element in stack
     * 1. In stack add element one by one
     * 2. Reset temp to head, and start traversing
     * 3. From stack pop() each element and compare it wil current temp.data
     * 4. If it is not same return false and in last return false
     * <p>
     * TC - O(n) + O(n)
     * SC - O(n)
     */
    public static boolean isPalindrome(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        if (head.next == null) {
            return true;
        }
        ListNode temp = head;

        while (temp != null) {
            linkedList.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (linkedList.pop() != temp.val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    /**
     * For optimal solution we have steps
     * 1. Find mid using Hare and Tortoise way, In even number of element stop at first mid
     * 2. Slow pointer will be at mid, Then revert linked list from slow.next
     * 3. After reverse we will get updated pointer
     * 4. Then we will move temp till meet with slow and moving new pointer by one by comparing
     */
    public static boolean isPalindromeOptimal(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //Move fast till last
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var reverse = reverse(slow.next);

        ListNode temp = head;

        while (reverse != null) {
            if (temp.val != reverse.val) {
                return false;
            }

            temp = temp.next;
            reverse = reverse.next;
        }
        return true;
    }

    private static ListNode reverse(final ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode curr = temp;
            temp = temp.next;
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}
