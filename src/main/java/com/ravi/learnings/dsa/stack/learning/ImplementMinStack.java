package com.ravi.learnings.dsa.stack.learning;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/min-stack/description/">Problem Link</a> </br>
 * Need to design a stack that will return the min element in the O(1) time
 * We can also go through all the elements of the stack and check for min but that will take O(N) TC for each getMin operation
 */
public class ImplementMinStack {
    public static void main(String[] args) {
        final var minStack = new MinStackOptimal();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

/**
 * In brute force approach we are using space 2N
 * To optimize that we will use the formula
 * 1. If any element which we are inserting is smaller than the minValue then we will update the current value
 * and update the current minimum
 * newValue = 2*value - min
 * lets take example minValue = MIN_VALUE, st = stack
 * st.push(4) --- minValue = 4
 * st.push(5) --- minValue = 4
 * st.push(3) --- So when pushing 3 we will change this to val = 2*3-4 = 2 so we will store or push 2
 * and replace minValue to 3
 * Formula is: newVal = 2 * val - previousMin
 * To get prevMin = 2 * val - newVal
 * When we pop and check if the current number is less than the minVal then it is modified number we need to
 * revert it
 * Above formula drived from
 * when we are pushing 3 then minVal = 4
 * val < minval => val-minVal < 0  => adding val both sides => val+val-minVal < val  => 2Val-minVal < val
 * 2*val - minVal = newVal so when newVal<val we modified value
 */
class MinStackOptimal {
    private final LinkedList<Long> stack;
    private long minVal;

    public MinStackOptimal() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            minVal = val;
            stack.push((long) val);
            return;
        }

        if (val < minVal) {
            long newVal = (2 * val) - minVal; // Need to remember this formula
            stack.push(newVal);
            minVal = val;
        } else {
            stack.push((long) val);
        }
    }

    /*
     * While pop element
     * */
    public void pop() {
        final var pop = stack.pop();
        if (pop < minVal) {
            minVal = 2 * minVal - pop;
        }
    }

    public int top() {
        final long peek = stack.peek();
        if (peek < minVal) { //Then it is modified value we need to revert it
            return (int) minVal;
        }
        return (int) peek;
    }

    public int getMin() {
        return (int) minVal;
    }
}

/**
 * So solve this problem we can take a pair that will contain Pair<Integer, Integer> first element will the the number
 * that is pushed to the stack and second is the min element that we have seen till now
 * In push operation are checking if stack is already empty then directly push to the stack
 * or else push val and min value of current or top element
 * <p>
 * TC = O(1) -- Doing all operations in one go
 * SC = O(2*N) -- Storing value and min value in pair
 */
class MinStack {
    private final LinkedList<Entry> stack;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
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
