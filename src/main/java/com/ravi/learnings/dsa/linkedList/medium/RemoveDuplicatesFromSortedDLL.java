package com.ravi.learnings.dsa.linkedList.medium;

import com.ravi.learnings.dsa.linkedList.DoubleLinkedList.Node;

/**
 *
 * <a href="https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1">Problem Link</a>
 * Given a doubly linked list of n nodes sorted by values,
 * the task is to remove duplicate nodes present in the linked list.
 *
 * Input:
 * n = 6
 * 1<->1<->1<->2<->3<->4
 * Output:
 * 1<->2<->3<->4
 * Explanation:
 * Only the first occurance of node with value 1 is
 * retained, rest nodes with value = 1 are deleted.
 * */
public class RemoveDuplicatesFromSortedDLL {
    public static void main(String[] args) {
        final var ints = new int[]{1, 1, 2, 2, 3, 3, 5, 6};
        final var integerNode = Node.fromArray(ints);
        Node.print(integerNode);
        System.out.println("=====================");
        final var pairs = removeDuplicatesStriverMethod(integerNode);
        Node.print(pairs);
    }

    /**
     * As we have sorted DLL so duplicate element will be present next to the element so we do
     * 1. Take temp1 and temp2 this will point to the next from temp1
     * 2. if temp1 and temp2 val will be equal then remove that element and move temp2 next
     * 3. Else we will move temp1 and temp2 to next element
     * 4. In this way we will remove all the duplicates from DLL
     * TC - O(N)
     * SC - O(1)
     * */
    private  static Node removeDuplicates(Node head) {
        Node temp1 = head;
        Node temp2 = head.next;

        while(temp2 != null) {

            if(temp1.data == temp2.data) {
                Node nextNode = temp2.next;
                if(nextNode != null) {
                    nextNode.prev = temp1;
                }

                temp1.next = nextNode;
                temp2.next = null;
                temp2.prev = null;
                temp2 = nextNode;
            } else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        return head;
    }

    /**
     * In this method we will take temp1 then while traversing we will add another while loop till we get duplicate
     * elements
     * Then we will move links of temp1 and nextNode
     * TC - O(N)
     * SC - O(1)
     * @param head
     * @return
     */
    private  static Node removeDuplicatesStriverMethod(Node head) {
        Node temp1 = head;

        while(temp1 != null && temp1.next != null) {

            Node nextNode = temp1.next;

            while(nextNode!= null && temp1.data == nextNode.data) {
                nextNode = nextNode.next;
            }

            temp1.next = nextNode;
            if(nextNode != null) {
                nextNode.prev = temp1;
            }

            temp1 = temp1.next;
        }

        return head;
    }
}
