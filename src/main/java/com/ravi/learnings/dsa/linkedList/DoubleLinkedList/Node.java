package com.ravi.learnings.dsa.linkedList.DoubleLinkedList;

import java.util.ArrayDeque;

/// ading comment test 1
public class Node {
    public Node prev;
    public int data;
    public Node next;

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public Node(final Node prev, final int data, final Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public Node(final int data) {
        this.data = data;
    }

    public static Node fromArray(int[] array) {
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

    /*
     * https://www.youtube.com/watch?v=0eKMU10uEDI&t=2684s
     * */
    public static Node insertHead(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        final var newNode = new Node(null, data, null);
        newNode.next = head;
        return newNode;
    }

    public static Node insertTail(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        var temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        final var newNode = new Node(temp, data, null);
        temp.next = newNode;
        return head;
    }

    public static Node insertBeforeTail(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        var temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        final var prev = temp.prev;
        final var newNode = new Node(prev, data, temp);
        prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    public static Node insertAtPosition(Node head, int data, int position) {
        if (head == null) {
            return new Node(data);
        }

        if (position == 1) {
            return new Node(null, data, head);
        }

        Node temp = head;
        int count = 1;
        while (temp != null) {

            if (count == position) {
                var prevNode = temp.prev;
                var newNode = new Node(prevNode, data, temp);
                prevNode.next = newNode;
                temp.prev = newNode;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static Node insertAtValue(Node head, int data, int value) {
        if (head == null) {
            return new Node(data);
        }

        if (head.data == value) {
            return new Node(null, data, head);
        }

        Node temp = head;

        while (temp != null) {

            if (temp.data == value) {
                var prevNode = temp.prev;
                var newNode = new Node(prevNode, data, temp);
                prevNode.next = newNode;
                temp.prev = newNode;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteTail(Node head) {
        if (head == null) {
            return null;
        }
        var temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        final var prev = temp.prev;
        temp.prev = null;
        prev.next = null;

        return head;
    }

    public static Node deleteHead(Node head) {
        if (head == null) {
            return null;
        }

        var temp = head;
        head = temp.next;
        temp.next = null;
        head.prev = null;
        return head;
    }

    /**
     * Here we will delete the kth given element from the linked list
     */
    public static Node deleteKthElement(Node head, int k) {
        if (head == null) {
            return null;
        }

        int count = 1;
        var temp = head;

        if (k == 1) {
            head = head.next;
            temp.next = null;
            return head;
        }

        while (temp != null) {

            if (count == k) {
                break;
            }
            temp = temp.next;
            count++;
        }

        if (count == k) {
            var prev = temp.prev;
            var next = temp.next;
            prev.next = next;
            if (next != null) {
                next.prev = prev;
            }

            temp.prev = null;
            temp.next = null;
        }

        return head;
    }

    public static void deleteNode(Node deleteNode) {

        final var prev = deleteNode.prev;
        final var next = deleteNode.next;

        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }

        deleteNode.next = null;
        deleteNode.prev = null;
    }

    /**
     * Reversing double linked list using stack,
     * first we add elements in stack
     * after that we pop element one by one and set in data
     * <p>
     * TC -> O(2n) --- O(n) to getting the data in stack + O(n) to modify linked list with the element
     * SC -->  O(n) --- As we are storing data in stack
     */
    public static Node reverse(Node head) {
        if (head == null) {
            return null;
        }

        final var stack = new ArrayDeque<Integer>();

        var temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    /*
     * So here we are doing reverse in single run,
     * we are taking two variable pre and next and storing current element pre and next
     * then doint temp.next = pre and temp.prev = next to swap the pointers
     * in this way for each element we will swap the pointer
     * while moving next we need to take care as we swapped element we will move now current.prev
     *
     * then at last  we will got prev which will pe pointing on pointer behide so returing prev.prev
     * as we are doing temp = temp.prev
     * */
    public static Node reverseOptimized(Node head) {
        if (head == null) {
            return null;
        }

        var temp = head;
        Node prev = null;
        while (temp != null) {
            prev = temp.prev;
            var next = temp.next;

            temp.next = prev;
            temp.prev = next;

            temp = temp.prev;
        }

        return prev.prev;
    }
}