package com.ravi.learnings.dsa.bit_manipulation.advance_maths;

import java.util.Set;
import java.util.TreeSet;

public class DivisorsOfNumber {
    public static void main(String[] args) {
        optimal(36);
    }

    /**
     * In brute force approach we are just dividing the number from 1 - n/2
     * and at last adding the number itself as that will be also divisor
     *
     * TC - O(N/2) as we traversing till n/2
     * SC - O(sqrt(N)) as numbers will not be greater than sqrt
     * */
    public static void print_divisors(int n) {
       for(int i = 1;i <= n/2; i++) {

           if(n % i == 0) {
               System.out.println(i);
           }
       }
        System.out.println(n);
    }

    /**
     * In this solution we use the trick if we have and divisor , if we divide number with it we will get another
     * divisor i.e lets take example for 36
     * 1 * 36
     * 2 * 18
     * 3 * 12
     * 4 * 9
     * 6 * 6
     * ------
     * 9 * 4
     * 12 * 3
     * 18 * 2
     * 36 * 1
     * Carefully observe that after  6 * 6 we start repeating number
     * TC:
     * */
    public static void optimal(int n) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        set.forEach(v -> System.out.print(v + " "));
    }
}
