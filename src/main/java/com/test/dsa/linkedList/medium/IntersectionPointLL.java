package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.ListNode;

import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">here</a>
 * <a href="https://takeuforward.org/plus/dsa/problems/find-the-intersection-point-of-y-ll">here</a>
 * Given the heads of two linked lists A and B, containing positive integers.
 * Find the node at which the two linked lists intersect. If they do intersect, return the node at which the intersection begins, otherwise return null.
 * The Linked List will not contain any cycles. The linked lists must retain their original structure,
 * given as per the input, after the function returns.
 *
 *
 * */
public class IntersectionPointLL {

    public static void main(String[] args) {
        final var integers = List.of(3, 2, 1, 0, -1, -2, 8);
        final var head = ListNode.from(integers);
        final var zeroNode = head.next.next.next;
        final var head1 = ListNode.from(List.of(5, 6));
        head1.next.next = zeroNode;
        System.out.println("------------------------");
        System.out.println(Math.subtractExact(5, 7));
        final var listNode = intersectionPointBetter(head, head1);
        ListNode.print(listNode);
    }

    /**
     * in brute force approach we will
     * 1. store all the nodes of list1 in hashset
     * 2. traverse list2 and check if element is exist in the hashset
     * 3. If yes, then return the temp
     * 4. Else return null
     *
     * TC --- O(n1) + 0(n2)
     * SC -- O(n1) --- we are storing in hashset
     * */
    private static ListNode intersectionPointBruteForce(final ListNode headA, final ListNode headB) {
        final var hashSet = new HashSet<ListNode>();

        ListNode temp  = headA;
        while (temp != null) {
            hashSet.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if(hashSet.contains(temp)) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }


    /**
     * In brute force approach we are using extra space we need to remove it
     * For this solution idea is that we will find the difference between length of two linked list and will remove
     * the move step ahead so that both LL has same element i.e
     * LL1 - 3 - 1 - 4 - 6 - 2
     * LL2 - 1 - 2 - 4- 5 - 4 - 6 - 2
     * in above example 4 is intersection point so will will move LL2 to 2 point ahead so that both linked list
     * length would be same
     * */
    private static ListNode intersectionPointBetter(final ListNode headA, final ListNode headB) {
        final var sizeA = getSize(headA);
        final var sizeB = getSize(headB);

        ListNode tempA = headA;
        ListNode tempB = headB;
        if(sizeA > sizeB) {
            var diff = sizeA - sizeB;
            while (diff>0) {
                tempA = tempA.next;
                diff--;
            }
        } else {
             var diff = sizeB - sizeA;
            while (diff>0) {
                tempB = tempB.next;
                diff--;
            }
        }

        while (tempA != null) {
            if(tempA == tempB){
                return tempA;
            }

            tempA = tempA.next;
            tempB = tempB.next;
        }


        return null;
    }

    private static int getSize(ListNode listNode) {
        int result = 0;
        ListNode temp = listNode;
        while(temp != null) {
            result++;
            temp = temp.next;
        }
        return result;
    }
}
