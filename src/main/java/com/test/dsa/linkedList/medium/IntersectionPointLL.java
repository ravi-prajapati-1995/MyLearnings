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
 */
public class IntersectionPointLL {

    public static void main(String[] args) {
        final var integers = List.of(3, 2, 1, 0, -1, -2, 8);
        final var head = ListNode.from(integers);
        final var zeroNode = head.next.next.next;
        final var head1 = ListNode.from(List.of(5, 6));
        head1.next.next = zeroNode;
        System.out.println("------------------------");
        System.out.println(Math.subtractExact(5, 7));
        final var listNode = intersectionPointOptimalApproach(head, head1);
        ListNode.print(listNode);
    }

    /**
     * in brute force approach we will
     * 1. store all the nodes of list1 in hashset
     * 2. traverse list2 and check if element is exist in the hashset
     * 3. If yes, then return the temp
     * 4. Else return null
     * <p>
     * TC --- O(n1) + 0(n2)
     * SC -- O(n1) --- we are storing in hashset
     */
    private static ListNode intersectionPointBruteForce(final ListNode headA, final ListNode headB) {
        final var hashSet = new HashSet<ListNode>();

        ListNode temp = headA;
        while (temp != null) {
            hashSet.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (hashSet.contains(temp)) {
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
     * <p>
     * TC -- O(N1) -- to get size of l1 + O(N2) -- To get size of l2 + O(N1-N2) -- TO move header  + O(N1)-- to check
     * collision in case collision no exit
     * SC - O(1)
     */
    private static ListNode intersectionPointBetter(final ListNode headA, final ListNode headB) {
        final var sizeA = getSize(headA);
        final var sizeB = getSize(headB);

        if (sizeA > sizeB) {
            return collisionPoint(headB, headA, sizeA - sizeB);
        } else {
            return collisionPoint(headA, headB, sizeB - sizeA);
        }
    }

    /**
     * In optimal approach we will do below steps:
     * 1. take temp1 for headA and temp2 for headB
     * 2. Increment both temp1 and temp2 one by one till one of them read to null
     * 3. If temp1 reach to null then assign headB to it
     * 4. Move temp2 till it reaches to null when it reach assign temp2 = headA
     * 5. with each step also increase temp1 by one step
     * 6. when temp2 reach to null and we assign it headA you will find temp1 will be ahead with size2 - size1 that we
     * are calculating in better approach
     * i.e
     * LL1 - 3 - 1 - 4 - 6 - 2
     * LL2 - 1 - 2 - 4- 5 - 4 - 6 - 2
     */
    private static ListNode intersectionPointOptimalApproach(final ListNode headA, final ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1 != null && temp2 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if(temp1 == null) {
            temp1 = headB;
            while(temp2 != null) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            temp2 = headA;
        } else {
            temp2 = headA;
            while(temp1 != null) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            temp1 = headB;
        }

        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }


/**
 * TC = O(n1 + n2)
 *
 *
 * */
    private static ListNode intersectionPointOptimalStriverMethod(final ListNode headA, final ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2) {
                return  temp1;
            }

            if(temp1 == null) {
                temp1 = headB;
            }

            if(temp2 == null) {
                temp2 = headA;
            }
        }


        return temp1;
    }

    private static ListNode collisionPoint(ListNode smallList, ListNode largeList, int diff) {
        ListNode tempA = smallList;
        ListNode tempB = largeList;
        while (diff > 0) {
            tempB = tempB.next;
            diff--;
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }

    private static int getSize(ListNode listNode) {
        int result = 0;
        ListNode temp = listNode;
        while (temp != null) {
            result++;
            temp = temp.next;
        }
        return result;
    }
}
