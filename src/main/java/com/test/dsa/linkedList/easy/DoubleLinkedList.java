package com.test.dsa.linkedList.easy;

public class DoubleLinkedList {
    public static void main(String[] args) {
        final var ints = new int[]{1, 2, 3, 4, 5};
        final var integerNode = Node.fromArray(ints);

//        final var integerNode1 = Node.insertHead(integerNode, 22);
        final var integerNode1 = Node.insertTail(integerNode, 232);

        Node.print(integerNode1);

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

    Node(final T data) {
        this.data = data;
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

    static <T> Node<T> insertHead(Node<T> head, T data) {
       if(head == null) {
           return new Node<>(data);
       }

        final var newNode = new Node<T>(null, data, null);
        newNode.next = head;
        return newNode;
    }

    static <T> Node<T> insertTail(Node<T> head, T data) {
        if(head == null) {
            return new Node<>(data);
        }

        var temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        final var newNode = new Node<T>(temp, data, null);
        temp.next = newNode;
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