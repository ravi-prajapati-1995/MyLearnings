package com.ravi.learnings.dsa.stack.learning;

import java.util.EmptyStackException;

/**
 * In Queue it will be First-in-First-Out
 * Example of queue is simple bank line waiting for their turn
 * */
public class QueueUsingArray {
    public static void main(String[] args) {
        final var myQueue = new MyQueue(5);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println("Size is: " + myQueue.size());
        System.out.println("---------------------------------");
        myQueue.push(5);
        myQueue.push(6);
        myQueue.push(7);

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println("Size is: " + myQueue.size());
        myQueue.push(8);
        myQueue.push(9);
        myQueue.push(10);

        System.out.println("Size is: " + myQueue.size());
        System.out.println(myQueue.pop());


    }

}

class MyQueue {
    private final int size;
    private int start; // To track where is the current start point if someone pops the element
    private int end; // To track where we need to put last element if someone push element
    private int currSize; // For tracking if size exceed from actual size
    private final int[] arr;

    public MyQueue(int size) {
        this.size = size;
        arr = new int[size];
        this.currSize = 0;
        this.start = -1;
        this.end = -1;
    }

    public void push(int element) {
        if (currSize >= size) {
            throw new StackOverflowError("Stack is fully filled");
        }
        // We are adding first element in the stack
        if(start == -1 && end == -1) {
            start ++;
            end++;
            arr[end] = element;
        } else { // We are already having element in the stack
            end = (end + 1) % size; // When we are adding element when end is at last position, and currsize is not equal to size
            arr[end] = element;
        }

        currSize++;

    }

    public int pop() {
        if(currSize == 0) {
            throw new EmptyStackException();
        }
        start = (start) % size;
        int res = arr[start % size];
        start++;
        currSize--;
        return res;
    }

    public int size() {
        return currSize;
    }

    public int top() {
        if(currSize != 0) {
            return arr[start];
        }
        throw new EmptyStackException();
    }

}
