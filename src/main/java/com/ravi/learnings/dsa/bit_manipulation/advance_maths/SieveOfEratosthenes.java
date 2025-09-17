package com.ravi.learnings.dsa.bit_manipulation.advance_maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

/**
 * <a href="https://www.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1">Problem Link</a>
 * Given a positive integer n, calculate and return all prime numbers less than or equal to n using
 * the Sieve of Eratosthenes algorithm.
 * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 *Input: n = 10
 * Output: [2, 3, 5, 7]
 * Explanation: Prime numbers less than equal to 10 are 2, 3, 5 and 7.
 */
public class SieveOfEratosthenes {
    private static final int[] array = getSievePrecalculatedArray(100000);
    /**
     * According to this Algorithm
     * 1. take and array with 10^5 (constraint given) + 1
     * 2. Fill all the element with the index
     * 3. After that start from 2, and mark all 2's multiple with 2 as it is the prime factor
     * 4. Follow this step for all number
     * 5. Use that precalculated array to calculate the get prime number
     * */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieve(10)));
    }

    public static int[] sieve(int n) {
        final var maxIdx = 100000;
        final var array = getSievePrecalculatedArray(maxIdx);
        final var integers = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            if(array[i] == i) {
                integers.add(i);
            }
        }

        return integers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getSievePrecalculatedArray(int maxIdx) {
        int[] arr = new int[maxIdx + 1];
        // Filing array with default value
        for (int i = 1; i <= maxIdx; i++) {
            arr[i] = i;
        }

        //now marking all divisor of number
        for (int i = 2; i * i < maxIdx; i++) {

            // if this number is already has some factor then all its divisor must have same factor
            if (arr[i] != i) {
                continue;
            }
            for (int j = i; j <= maxIdx; j = j + i) {
                if (arr[j] % i == 0 && arr[j] == j) {
                    arr[j] = i;
                }
            }
        }

        return arr;
    }
}
