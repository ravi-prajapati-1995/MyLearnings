package com.ravi.learnings.dsa;

import java.util.Arrays;

public class BackTrackBinaryString {
    public static void main(String[] args) {
        final var binaryStrings = new BinaryStrings(4);
        binaryStrings.binary(4);
    }
}

class BinaryStrings {
    int[] A;

    public BinaryStrings(final int n) {
        A = new int[n];
    }

    public void binary(int n) {
        if (n <= 0) {
            System.out.println(Arrays.toString(A));
        } else {
            A[n - 1] = 0;
            binary(n - 1);
            A[n - 1] = 1;
            binary(n - 1);
        }
    }
}
