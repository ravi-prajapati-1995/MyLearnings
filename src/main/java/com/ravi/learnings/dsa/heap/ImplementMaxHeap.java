package com.ravi.learnings.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class ImplementMaxHeap {
    public static void main(String[] args) {
        final var myMaxHeap = new MyMaxHeap();
        myMaxHeap.insert(5);
        myMaxHeap.insert(6);

        System.out.println(myMaxHeap.getHeap());
    }
}

class MyMaxHeap {
    private List<Integer> elements;
    private int size;

    public MyMaxHeap() {
        elements = new ArrayList<>();
        size = 0;
    }

    public void insert(int val) {
        elements.add(val);
        size++;
        heapifyUP(size-1);
    }

    /**
     * In this function we will check if the parent of current element is greater than the current element
     * if Yes we will not change anything
     * If Not then we need to swap current element with the root element till the maximum element is not at the top
     * */
    private void heapifyUP(int idx) {
        if(idx == 0) {
            return;
        }

        final var parent = ((idx + 1)/ 2) - 1;
        final var parentVal = elements.get(parent);
        final var currentVal = elements.get(idx);
        if(parentVal < currentVal) {
            elements.add(parent, currentVal);
            elements.add(idx, parentVal);
            heapifyUP(parent);
        }
    }

    public List<Integer> getHeap() {
        return elements;
    }
}
