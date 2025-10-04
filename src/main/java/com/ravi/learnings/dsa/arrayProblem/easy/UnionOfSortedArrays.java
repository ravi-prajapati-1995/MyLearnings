package com.ravi.learnings.dsa.arrayProblem.easy;

import java.util.ArrayList;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        int a[] = {1, 2, 2, 3, 10};
        int b[] = {7, 8, 8};
        ArrayList<Integer> union = findUnion(a, b);
        System.out.println(union);
    }

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        // add your code here
        int aIdx = 0;
        int bIdx = 0;
        int currentElement = 0;
        while (aIdx < a.length && bIdx < b.length) {
            int nextElement;
            if (a[aIdx] == b[bIdx]) {
                nextElement = a[aIdx];
                aIdx++;
                bIdx++;
            } else if (a[aIdx] < b[bIdx]) {
                nextElement = a[aIdx];
                aIdx++;
            } else {
                nextElement = b[bIdx];
                bIdx++;
            }

            if (currentElement != nextElement) {
                result.add(nextElement);
                currentElement = nextElement;
            }
        }

        for (int i = aIdx; i < a.length; i++) {
            if (currentElement != a[i]) {
                result.add(a[i]);
                currentElement = a[i];
            }
        }

        for (int i = bIdx; i < b.length; i++) {
            if (currentElement != b[i]) {
                result.add(b[i]);
                currentElement = b[i];
            }
        }
        return result;
    }
}
