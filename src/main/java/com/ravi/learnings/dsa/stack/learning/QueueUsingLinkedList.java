package com.ravi.learnings.dsa.stack.learning;

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        final var linkedListStack = new LinkedListQueueStriver();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.push(4);

        System.out.println(linkedListStack.top());

        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());

        System.out.println(linkedListStack.top());

        linkedListStack.push(5);
        linkedListStack.push(6);

        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());

    }
}
/**
 * According to striver we have node and to use it as stack below steps needs to be done:
 * 1. Create a new node on push operation: 5 | null
 * 2. push(4) : So 4.next should be 5 to do it: after creating new node we will 4.next = node
 *  and node = newNode
 * */
class LinkedListQueueStriver {
    private Node head;
    private Node tail;
    private int size;

    LinkedListQueueStriver() {
        head = null;
        size = 0;
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x);
            tail = head;
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
        size++;
    }

    /**
     * So we are always referencing to the top element so directly get the top and move the node to next
     * */
    public int pop() {
        final var data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int top() {
        if(isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    static class Node {
        int data;
        Node next;

        private Node(final int data) {
            this.data = data;
        }
        private Node() {}
    }
}





