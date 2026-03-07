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
        myMinHeap.initializeHeap();
        myMinHeap.insert(4);
        myMinHeap.insert(1);
        myMinHeap.insert(10);

        myMinHeap.insert(11);
        myMinHeap.insert(9);
        myMinHeap.insert(7);
        myMinHeap.insert(3);

        System.out.println(myMinHeap.getHeap());
        myMinHeap.changeKey(3, 2);
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

    public void initializeHeap() {
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

    public int getMin() {
        return elements.getFirst();
    }

    public int heapSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Remove the minimum element fromm the heap in our case top element
    /*
    * 1. Get the top element and swap it with the last element of heap
    * 2. Then call the heapify down algo as we have greater element at the top
    * */
    public void extractMin() {
        Collections.swap(elements, 0, elements.size() - 1);
        elements.removeLast();
        heapifyDown(0);
        size--;
    }

    private void heapifyDown(int ind) {
        int smallest = ind;
        int leftChild = ind * 2 + 1;

        if(leftChild < elements.size() && elements.get(leftChild) < elements.get(smallest)) {
            smallest = leftChild;
        }

        int rightChild = ind * 2 + 2;
        if(rightChild < elements.size() && elements.get(rightChild) < elements.get(smallest)) {
            smallest = rightChild;
        }

        if(smallest != ind) {
            Collections.swap(elements, ind, smallest);
            heapifyDown(smallest);
        }
    }

    public void changeKey(int index, int newVal) {
        final var currentVal = elements.get(index);

        elements.remove(index);
        elements.add(index, newVal);

        if(newVal > currentVal) {
            heapifyDown(index);
        } else {
            heapifyUP(index);
        }
    }
}
