package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.DoubleLinkedList.Node;

/**
 * <a href="https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1">Problem</a>
 * <p>
 * You are given the head_ref of a doubly Linked List and a Key.
 * Your task is to delete all occurrences of the given key if it is present and return the new DLL.
 * <p>
 * Input:
 * 2<->2<->10<->8<->4<->2<->5<->2
 * 2
 * Output:
 * 10<->8<->4<->5
 * Explanation:
 * All Occurences of 2 have been deleted.
 */
public class DeleteAllOccurenceIn_DLL {
    public static void main(String[] args) {
        final var ints = new int[]{9, 1, 3, 4, 5, 1, 8, 4};
        final var integerNode = Node.fromArray(ints);
        Node.print(integerNode);
        System.out.println("=====================");
        final var node = deleteAllOccurOfX(integerNode, 9);
        Node.print(node);
    }

    /**
     * To solve this we will iterate the DLL steps:
     * 1. While iterate check if the current node value is equal to given value
     * 2. If yes then make current node prev and next to null and point prev node to next node break the link of
     * current node
     * 3. Need to handle edge cases where prevNode and nextNode can be null if element is present in start or end of DLL
     * 4. In case not equal then move then we will check if new head is null and set if null
     */
    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        Node newHead = null;
        while (temp != null) {

            if (temp.data == x) {
                Node nextNode = temp.next;
                Node prevNode = temp.prev;

                if ((nextNode != null)) {
                    nextNode.prev = prevNode;
                }
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
                temp.next = null;
                temp.prev = null;
                temp = nextNode;
            } else {
                if (newHead == null) {
                    newHead = temp;
                }
                temp = temp.next;
            }
        }
        return newHead;
    }
}
