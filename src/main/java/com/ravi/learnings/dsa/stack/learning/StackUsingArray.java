package com.ravi.learnings.dsa.stack.learning;

import java.util.EmptyStackException;

/**
 * Stack is the data structure in which element last-in-first-out
 * You can assume stack of plate in which top plate came in last and out first
 * */
public class StackUsingArray {
    public static void main(String[] args) {
        final var myStackUsingArray = new MyStack(5);
        myStackUsingArray.push(5);
        myStackUsingArray.push(4);
        myStackUsingArray.push(3);

        System.out.println(myStackUsingArray.size());

        System.out.println(myStackUsingArray.top());

    }
}

class MyStack {
    private final int size;
    private int top;
    private final int[] arr;

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
        this.top = -1;
    }

    public void push(int element) {
        top++;
        if (top >= size) {
            top--;
            throw new StackOverflowError("Stack is fully filled");
        }

        arr[top] = element;
    }

    public int pop() {
        if(top == -1) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    public int size() {
        return top + 1;
    }

    public int top() {
        if(top != -1) {
            return arr[top];
        }
        throw new EmptyStackException();
    }

}
