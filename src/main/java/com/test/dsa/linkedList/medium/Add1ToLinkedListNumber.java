package com.test.dsa.linkedList.medium;

import com.test.dsa.linkedList.Node;

import java.util.List;

public class Add1ToLinkedListNumber {

    public static void main(String[] args) {
        final var integers = List.of(9, 9, 9);
        final var head = Node.from(integers);
        final var listNode = addOne(head);
        Node.print(listNode);
    }

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
            if(result > 9) {
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

        if(carry == 1) {
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
