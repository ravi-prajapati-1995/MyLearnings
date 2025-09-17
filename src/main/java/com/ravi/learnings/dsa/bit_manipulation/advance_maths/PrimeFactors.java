package com.ravi.learnings.dsa.bit_manipulation.advance_maths;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array queries of length n.
 *
 * Return the prime factorization of each number in array queries in sorted order.
 * Input : queries = [2, 3, 4, 5, 6]
 *
 * Output : [ [2], [3], [2, 2], [5], [2, 3] ]
 *
 * Explanation : The values 2, 3, 5 are itself prime numbers.
 *
 * The prime factorization of 4 will be --> 2 * 2.
 *
 * The prime factorization of 6 will be --> 2 * 3.
 * */
public class PrimeFactors {
    public static void main(String[] args) {
       int[] queries = {2, 3, 4, 5, 6};
        System.out.println(primeFactors(queries));

    }

    /**
     * Using Sieve Algorithm according to this algo:
     * 1. Take an array with n+1 numbers where n is the maximum number for which we want to calculate prime factor
     * 2. Start from 0-n+1 and mark element with their respective number
     * 3. Again start the loop from 2 and start marking all the divisor of number with that number if already not marked
     *  i.e: for 2, mark 4, 6, 8, 10, 12, 14, 16.... with 2 as smallest prime factor will be 2 for all of these
     *      for 3 , we can't mark 6 again with 3 as it is already marked with 2 so mark 9, 15, 21, 27, ....
     * In this way pre calculate all the prime factor for all the numbers
     * 4. let we have n = 60, directly go 60 and get smallest prime factor which is 2, then divide it by 2 which will
     * become 30 then go to 30 and check smallest factor again 2, then divide which become 15, then go to arr[15]
     * check spf which is 3
     * */
    public static List<List<Integer>> primeFactorsOptimal(int[] queries) {
            return null;
    }

    public static List<List<Integer>> primeFactors(int[] queries) {
        final var lists = new ArrayList<List<Integer>>();
        for(int i: queries) {
            lists.add(getPrimFactor(i));
        }
        return lists;
    }

    public static List<Integer> getPrimFactor(int number) {
        final var result = new ArrayList<Integer>();
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {

                while (number % i == 0) {
                    result.add(i);
                    number = number / i;
                }
            }
        }

        // Case when there are no number which can divide this number like 11
        if(number >1) {
            result.add(number);
        }
        return result;
    }
}
