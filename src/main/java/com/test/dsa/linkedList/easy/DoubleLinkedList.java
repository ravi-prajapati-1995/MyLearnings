package com.test.dsa.linkedList.easy;

public class DoubleLinkedList {
    public static void main(String[] args) {
        final var ints = new int[]{1, 2, 3, 4, 5};
        final var integerNode = Node.fromArray(ints);
        Node.print(integerNode);

    }
}

/// ading comment test 1
class Node<T> {
    private Node prev;
    private T data;
    private Node next;

    Node(final Node prev, final T data, final Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    static Node<Integer> fromArray(int[] array) {
        Node head = new Node(null, array[0], null);
        Node prev = head;
        Node curr = null;
        for (int i = 1; i < array.length; i++) {
            curr = new Node(prev, array[i], null);
            prev.next = curr;

            prev = curr;
        }
        return head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}