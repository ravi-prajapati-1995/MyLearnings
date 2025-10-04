package com.ravi.learnings.dsa.stack.learning;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {
        final var stackQueue = new StackQueue2();
        stackQueue.push(3);
        stackQueue.push(4);
        stackQueue.push(2);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());

        stackQueue.push(1);
        stackQueue.push(0);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
    }
}

/**
 * below approach is useful when we have more push and less pop/peek
 * So in this approach I will not do anything while push
 * While pop and peek , if tempStack is empty if yes the transfer all the element from stack to that
 * and return the top element
 * <p>
 * If we have still elements in tempStack then return the top/pop
 * <p>
 * <p>
 * TC  - in top/pop operation we are transferring element occasionally so O(n)
 * SC - O(2N)
 */

class StackQueue2 {
    final Stack<Integer> stack;
    final Stack<Integer> tempStack;

    public StackQueue2() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        // If empty move all stack elements in tempstack
        if (tempStack.isEmpty()) {
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
        }
        return tempStack.pop();
    }

    public int peek() {
        if (tempStack.isEmpty()) {
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
        }
        return tempStack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Three method will be used to make stack as queue
 * Take a new stack s2, and original stack is s1
 * 1. move all element from s1 to s2
 * 2. Push the element in stack
 * 3. Move all elements from s2 to s1 back
 * <p>
 * TC -> O(2N) iterating via s1 and s2
 * SC -> O(2N) having extra stack and orignal stack for storing data
 */
class StackQueue {
    final Stack<Integer> stack;
    final Stack<Integer> tempStack;

    public StackQueue() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        // Move all elements from S1 to S2
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        // Add the element in original stack
        stack.push(x);

        //Push back elements in original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

