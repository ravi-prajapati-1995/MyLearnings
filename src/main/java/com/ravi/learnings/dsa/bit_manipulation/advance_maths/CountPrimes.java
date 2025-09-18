package com.ravi.learnings.dsa.bit_manipulation.advance_maths;

/**
 * <a href="https://leetcode.com/problems/count-primes/description/">Problem Link</a>
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * */
public class CountPrimes {
    private static final int[] SIEVE_PRECALCULATED_ARRAY = getSievePrecalculatedArray(10000000);

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int maxIdx = 1000;
        final var precalculatedArray = getSievePrecalculatedArray(maxIdx);
        return precalculatedArray[n];
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

        int primeNumberCount = 0;
        for (int i = 2; i <= maxIdx; i++) {
            if(i == arr[i]) {
                primeNumberCount++;
            }

            arr[i] = primeNumberCount;
        }
        return arr;
    }
}
