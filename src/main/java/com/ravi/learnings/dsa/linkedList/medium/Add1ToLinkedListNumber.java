package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.Node;

import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1">here</a>
 * You are given a linked list where each element in the list is a node and have an integer data.
 * You need to add 1 to the number formed by concatinating all the list node numbers together and return
 * the head of the modified linked list.
 * <p>
 * Note: The head represents the first element of the given array.
 */
public class Add1ToLinkedListNumber {

    public static void main(String[] args) {
        final var integers = List.of(9, 9, 9);
        final var head = Node.from(integers);
        final var listNode = addOneUsingRecursion(head);
        Node.print(listNode);
    }

    /**
     * In recursive solution we will create helper method that we will call
     * 1. In base condition if node is null we will add 1
     * 2. Then we will check if carry is greater than 0 then we will add that in current node and check
     * 3. If by adding one number becaome become 10 as max number per node is 9, then we make it 0 and carry 1
     * 4. in last we will return carry
     * 5. If carry 1 then we will add node with val 1 and return newly node
     * <p>
     * TC - O(n)
     * SC - O(n) -  we are calling method n time in stack
     */
    public static Node addOneUsingRecursion(Node head) {
        final var carry = helper(head);
        if (carry > 0) {
            final var node = new Node(carry);
            node.next = head;
            return node;
        }
        return head;
    }

    public static int helper(Node node) {
        if (node == null) {
            return 1;
        }

        int carrry = helper(node.next);

        if (carrry > 0) {
            final var val = node.data + 1;
            if (val > 9) {
                node.data = 0;
                return 1;
            } else {
                node.data = val;
            }
        }
        return 0;
    }

    /**
     * 6 -> 7 -> 9  ------Return --> 6 -> 8 -> 0
     * 7 -> 9 -> 9  ------Return --> 8 -> 0 -> 0
     * 9 -> 9 -> 9  ------Return --> 1 -> 0 -> 0 -> 0
     * In this solution we need to add 1 in the last node
     * As we don't have access of previous node in the single linked list and we can't go back so we need to reverse
     * the LL and add one and keep track of carry if at last it is one then add one new node
     * steps:
     * 1. Reverse the given LL
     * 2. Add one to element till we have carry 1 if carry 0 then return from loop
     * 3. After that check if we have carry 1 then add new node
     * 4. After that reverse again LL
     *
     * TC - O(n) (Reverse LL) + O(n) (Traversing) + O(n) (reversing) ----> o(3n)
     * SC - O(1)
     */
    public static Node addOne(Node head) {

        if (head.next == null) {
            return new Node(head.data + 1);
        }

        final var node = reverseUsingPointers(head);

        int carry = 1;

        Node temp = node;
        Node prev = null;
        while (temp != null) {
            final var result = temp.data + carry;
            if (result > 9) {
                temp.data = 0;
                carry = 1;
            } else {
                temp.data = result;
                carry = 0;
                break; //Break the loop when we will get  carry 0 as there is no use to run loop
            }

            prev = temp;
            temp = temp.next;
        }

        if (carry == 1) {
            prev.next = new Node(1);
        }

        return reverseUsingPointers(node);
    }

    public static Node reverseUsingPointers(Node head) {

        Node temp = head;
        Node prev = null;
        Node curr = null;

        while (temp != null) {
            curr = temp;
            temp = temp.next;
            curr.next = prev;
            prev = curr;
        }
        return curr;
    }
}
