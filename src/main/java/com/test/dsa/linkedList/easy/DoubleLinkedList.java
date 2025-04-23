package com.test.dsa.linkedList.easy;

import java.util.ArrayDeque;

/*
* https://www.youtube.com/watch?v=0eKMU10uEDI
* */
public class DoubleLinkedList {
    public static void main(String[] args) {
        final var ints = new int[]{1, 2, 3, 4, 5};
        final var integerNode = Node.fromArray(ints);

//        final var integerNode1 = Node.insertHead(integerNode, 22);
//        final var integerNode1 = Node.insertTail(integerNode, 232);
//        final var integerNode1 = Node.insertAtPosition(integerNode, 232, 6);
//        final var integerNode1 = Node.insertAtValue(integerNode, 232, 36);
//        final var integerNode1 = Node.insertBeforeTail(integerNode, 232);
//        final var integerNode1 = Node.deleteTail(integerNode);
//        final var integerNode1 = Node.deleteHead(integerNode);
//        final var integerNode1 = Node.deleteKthElement(integerNode, 5);
//        Node.deleteNode(integerNode.getNext().getNext());

//        final var reverse = Node.reverse(integerNode);
        final var reverse = Node.reverseOptimized(integerNode);

        Node.print(reverse);
    }
}

/// ading comment test 1
class Node<T> {
    private Node prev;
    private T data;
    private Node next;

    Node getPrev() {
        return prev;
    }

    T getData() {
        return data;
    }

    Node getNext() {
        return next;
    }

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

    /*
     * https://www.youtube.com/watch?v=0eKMU10uEDI&t=2684s
     * */
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

    static <T> Node<T> insertBeforeTail(Node<T> head, T data) {
        if(head == null) {
            return new Node<>(data);
        }

        var temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        final var prev = temp.prev;
        final var newNode = new Node<T>(prev, data, temp);
        prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    static <T> Node<T> insertAtPosition(Node<T> head, T data, int position) {
        if(head == null) {
            return new Node<>(data);
        }

        if(position == 1) {
            return new Node<>(null, data, head);
        }

        Node<T> temp = head;
        int count = 1;
        while(temp != null) {

            if(count == position) {
                var prevNode = temp.prev;
                var newNode = new Node<T>(prevNode, data, temp);
                prevNode.next = newNode;
                temp.prev = newNode;
            }
            temp = temp.next;
            count++;
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

    static <T> Node<T> insertAtValue(Node<T> head, T data, T value) {
        if(head == null) {
            return new Node<>(data);
        }

        if(head.data == value) {
            return new Node<>(null, data, head);
        }

        Node<T> temp = head;

        while(temp != null) {

            if(temp.data == value) {
                var prevNode = temp.prev;
                var newNode = new Node<T>(prevNode, data, temp);
                prevNode.next = newNode;
                temp.prev = newNode;
            }
            temp = temp.next;
        }
        return head;
    }

    static <T> Node<T> deleteTail(Node<T> head) {
        if(head == null) {
            return null;
        }
        var temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        final var prev = temp.prev;
        temp.prev = null;
        prev.next = null;

        return head;
    }

    static <T> Node<T> deleteHead(Node<T> head) {
        if(head == null) {
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
     * */
    static <T> Node<T> deleteKthElement(Node<T> head, int k) {
        if(head == null) {
            return null;
        }

        int count = 1;
        var temp = head;

        if(k == 1) {
            head = head.next;
            temp.next = null;
            return head;
        }

        while(temp != null) {

            if(count == k) {
                break;
            }
            temp = temp.next;
            count++;
        }

        if(count == k) {
            var prev = temp.prev;
            var next = temp.next;
            prev.next = next;
            if(next != null) {
                next.prev = prev;
            }

            temp.prev = null;
            temp.next = null;
        }

        return head;
    }

    static <T> void deleteNode(Node<T> deleteNode) {

        final var prev = deleteNode.prev;
        final var next = deleteNode.next;

        prev.next = next;
        if(next != null) {
            next.prev = prev;
        }

        deleteNode.next = null;
        deleteNode.prev = null;
    }

    /**
     * Reversing double linked list using stack,
     * first we add elements in stack
     * after that we pop element one by one and set in data
     *
     * TC -> O(2n) --- O(n) to getting the data in stack + O(n) to modify linked list with the element
     * SC -->  O(n) --- As we are storing data in stack
     * */
    static <T> Node<T> reverse(Node<T> head) {
        if(head == null) {
            return null;
        }

        final var stack = new ArrayDeque<T>();

        var temp = head;
        while(temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
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
    static <T> Node<T> reverseOptimized(Node<T> head) {
        if(head == null) {
            return null;
        }


        var temp = head;
        Node<T> prev = null;
        while(temp != null) {
             prev = temp.prev;
            var next = temp.next;

            temp.next = prev;
            temp.prev = next;

            temp = temp.prev;
        }


        return prev.prev;
    }
}