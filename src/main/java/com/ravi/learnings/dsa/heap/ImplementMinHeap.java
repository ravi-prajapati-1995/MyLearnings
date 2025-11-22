package com.ravi.learnings.dsa.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *          3
 *        /    \
 *       4      7
 *      / \    / \
 *     5   6  11   9
 *    /
 *   10
 * */
public class ImplementMinHeap {
    public static void main(String[] args) {
        final var myMinHeap = new MyMinHeap();
        myMinHeap.insert(10);
        myMinHeap.insert(5);
        myMinHeap.insert(6);
        myMinHeap.insert(11);
        myMinHeap.insert(9);
        myMinHeap.insert(4);
        myMinHeap.insert(7);
        myMinHeap.insert(3);

        System.out.println(myMinHeap.getHeap());
    }
}

/**
 * In Min heap smallest element will be at top so when we are adding a element if parent is smaller than the child
 * we will not do nothing
 * In case parent is greater than the child we need to do heapifyUp to make it heap
 */
class MyMinHeap {
    private List<Integer> elements;
    private int size;

    public MyMinHeap() {
        elements = new ArrayList<>();
        size = 0;
    }

    public void insert(int val) {
        elements.add(val);
        heapifyUP(size);
        size++;
    }

    /**
     * In min heap if parent is greater than the current element we need to swap
     */
    private void heapifyUP(int idx) {
        if (idx == 0) {
            return;
        }

        int parent = (int) Math.floor((idx - 1) / 2);
        final var parentVal = this.elements.get(parent);
        final var currentVal = this.elements.get(idx);
        if (parentVal > currentVal) {
            Collections.swap(elements, parent, idx);
            heapifyUP(parent);
        }
    }

    public List<Integer> getHeap() {
        return elements;
    }
}
