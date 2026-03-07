package com.ravi.learnings.dsa.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private List<Integer> elements;
    private int size;

    public void initializeHeap() {
        elements = new ArrayList<>();
        size = 0;
    }

    public void insert(int key) {
        elements.add(key);
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

    private void heapifyDown(int ind) {
        int smallest = ind;
        int leftChild = ind * 2 + 1;

        if (leftChild < elements.size() && elements.get(leftChild) < elements.get(smallest)) {
            smallest = leftChild;
        }

        int rightChild = ind * 2 + 2;
        if (rightChild < elements.size() && elements.get(rightChild) < elements.get(smallest)) {
            smallest = rightChild;
        }

        if (smallest != ind) {
            Collections.swap(elements, ind, smallest);
            heapifyDown(smallest);
        }
    }

    public void changeKey(int index, int newVal) {
        final var currentVal = elements.get(index);

        elements.remove(index);
        elements.add(index, newVal);

        if (newVal > currentVal) {
            heapifyDown(index);
        } else {
            heapifyUP(index);
        }
    }

    public void extractMin() {
        Collections.swap(elements, 0, elements.size() - 1);
        elements.remove(elements.size() - 1);
        heapifyDown(0);
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMin() {
        return elements.getFirst();
    }

    public int heapSize() {
        return size;
    }
}
