package com.ravi.learnings.dsa.stack.learning;

import java.util.LinkedList;

/**
 * I am having Queue DS and need to use it as Stack
 * in stack Last-In-First-Out and in Queue First-In-First-Out
 * So I will have some elements and will push it into queue and lets see it work as queue or not
 * st.push(4)
 * st.top -- It will give 4
 * st.push(9)
 * st.top() --- Now as it is queue FIFO it will give us 4 so we will need to make adjustment so that it return 9
 * to make it work as stack we will move all the elements before 9 after the 9
 * So after moving when we call st.top() then it will return 9 queue look like [9, 4]
 * st.push(2) -- [9, 4, 2]
 * st.top() -- 9
 * So move all the element before to after 2 -- [2, 9, 4]
 * st.push(5)
 * st.top() --- 5
 * move items after 5 --- [5, 2, 9, 4]
 * st.pop() -- 5
 * st.pop() -- 2
 * st.top() -- 9 -- [9, 4 ]
 */
public class StackUsingQueue {

    public static void main(String[] args) {
        final var myStack = new MyNewStack();
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);

        //        System.out.println(myStack.top());
        myStack.pop();
        //        System.out.println(myStack.top());

        myStack.push(2);
        myStack.push(1);

        System.out.println(myStack.top());
    }
}

/**
 * TC - push operation taking O(n) other taking O(1)
 */

class MyNewStack {
    private final LinkedList<Integer> queue;

    MyNewStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.push(x); // adding current element in the queue

        for (int i = 0; i < queue.size(); i++) {
            queue.push(queue.pop());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
