package com.ravi.learnings.dsa.stack.learning;

import java.util.LinkedList;

public class StackUsingLinkedList {
    public static void main(String[] args) {
        final var linkedListStack = new LinkedListStackStriver();
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
class LinkedListStackStriver {
    private Node node;
    private int size;

    LinkedListStackStriver() {
        node = null;
        size = 0;
    }

    public void push(int x) {
        final var newNode = new Node(x);
        newNode.next = node;
        node = newNode;
        size++;
    }

    /**
     * So we are always referencing to the top element so directly get the top and move the node to next
     * */
    public int pop() {
        final var data = node.data;
        node = node.next;
        size--;
        return data;
    }

    public int top() {
        if(isEmpty()) {
            return -1;
        }
        return node.data;
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

class LinkedListStack {
    private final LinkedList<Integer> list;
    private int lastIdx;

    LinkedListStack() {
        list = new LinkedList<>();
        lastIdx = 0;
    }

    public void push(int x) {
        list.add(lastIdx, x);
        lastIdx++;
    }

    public int pop() {
        final var element = list.get(lastIdx-1);
        list.remove(lastIdx-1);
        lastIdx--;
        return element;
    }

    public int top() {
        if(isEmpty()) {
            return -1;
        }
        return list.get(lastIdx-1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}




