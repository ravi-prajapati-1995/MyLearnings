package com.ravi.learnings.dsa.stack.learning;

import javax.print.DocFlavor.INPUT_STREAM;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

/**
 * <a href="https://leetcode.com/problems/min-stack/description/">Problem Link</a> </br>
 * Need to design a stack that will return the min element in the O(1) time
 * We can also go through all the elements of the stack and check for min but that will take O(N) TC for each getMin operation
 *
 * */
public class ImplementMinStack {
    public static void main(String[] args) {
        final var minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());
        minStack.push(-20);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();

        minStack.push(10);
        minStack.push(-7);

        System.out.println(minStack.getMin());


    }
}

/**
 * So solve this problem we can take a pair that will contain Pair<Integer, Integer> first element will the the number
 * that is pushed to the stack and second is the min element that we have seen till now
 * In push operation are checking if stack is already empty then directly push to the stack
 * or else push val and min value of current or top element
 * */
class MinStack {
    private  final LinkedList<Entry> stack;
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new Entry(val, val));
        } else {
            stack.push(new Entry(val, Math.min(stack.peek().min, val)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    class Entry {
        int val;
        int min;

        private Entry(final int val, final int min) {
            this.val = val;
            this.min = min;
        }
    }
}