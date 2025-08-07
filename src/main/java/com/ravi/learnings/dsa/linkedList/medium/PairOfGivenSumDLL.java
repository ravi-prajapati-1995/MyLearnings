package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.DoubleLinkedList.Node;

import java.util.ArrayList;

/**
 * <a href="https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1">Problem Link</a>
 * Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list
 * whose sum is equal to given value target.
 * <p>
 * Input:
 * 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
 * target = 7
 * Output: (1, 6), (2,5)
 * Explanation: We can see that there are two pairs
 * (1, 6) and (2,5) with sum 7.
 */
public class PairOfGivenSumDLL {
    public static void main(String[] args) {
        final var ints = new int[]{1, 5, 6};
        final var integerNode = Node.fromArray(ints);
        Node.print(integerNode);
        System.out.println("=====================");
        final var pairs = findPairsWithGivenSum(6, integerNode);
        System.out.println(pairs);
    }

    /**
     * To resolve this problem we will use two pointer as DLL is sorted
     * 1. Find the tail of DLL
     * 2. Traverse till we have head data < tail data, because DLL is sorted
     * 3. Calculate sum for head and tail data, then check it with target
     * 4.If sum is equal then save those elements in the list
     * 5. If sum is greater thant the target then we move tail previous because we will find small element in backward
     * 6. If sum is less that target then we move head to forward, as DLL is sorted
     *
     * @param target
     * @param head
     * @return
     */
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(
            int target,
            Node head
    ) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        while (head.data < tail.data) {
            final var sum = head.data + tail.data;
            if (sum == target) {

                final var elements = new ArrayList<Integer>();
                elements.add(head.data);
                elements.add(tail.data);

                list.add(elements);

                head = head.next;
            } else if (sum > target) {
                tail = tail.prev;
            } else {
                head = head.next;
            }
        }

        return list;
    }
}
