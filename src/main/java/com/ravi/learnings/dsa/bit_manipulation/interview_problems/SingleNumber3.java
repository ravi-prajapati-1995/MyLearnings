package com.ravi.learnings.dsa.bit_manipulation.interview_problems;

import com.ravi.learnings.dsa.bit_manipulation.easy.DecimalToBinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/single-number-iii/">Problem Link</a>
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements
 * appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
 *
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 * */
public class SingleNumber3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    /**
     * In brute force technique we can use hashing and store the number and corresponding times it appears
     * TC - O(n) (Traversing Array) + O(n) (filter result and convert them to array)
     * SC - O(1)
     * */
    public static int[] singleNumberBruteForce(int[] nums) {
        final var integerLongMap = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return integerLongMap.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Entry::getKey).mapToInt(Integer::intValue).toArray();
    }

    /**
     * In optimal solution we do the following steps:
     * 1. traverse the array and get the XOR of numbers
     * 2. After getting XOR,  we will divide numbers in two buckets
     *      a. Where 1st bit is set
     *      b. where 1st bit is not set
     * 3. After that from first bucket do XOR of all number we will get first number
     * 011 - 3
     * 101 - 5
     * ----------
     * 110 - 6
     * */
    public static int[] singleNumber(int[] nums) {
        // To calculate the XOR, in the xor i am having numbers only which are distinct or only once
        //{1, 2, 1, 3, 2, 5} From this 3 and 5 are once and xor of them is 3 = 011 ^ 101 = 110 which is 6 in decimal
        final var xor = Arrays.stream(nums).reduce(0, (i, j) -> i ^ j);

        // To get the rightmost set bit number we will do n & (n-1) this will give first set bit
        //[note] If we do n & n-1 then most right bit turn into 0
        /*
        * num =     1010100
        * num-1 =   1010011
        * ------------------
        * &         1010000
        * --------------------
        * Then its most right bit turned to 0
        * Then XOR this and with original number so we will get only most rightmost set bit number
        *
        * */
        int firstSetBit = (xor & (xor - 1)) ^ xor;

        int b1 = 0;
        int b2 = 0;

        for(int i: nums) {
            if((i & firstSetBit) == 0) {
                b1 = b1 ^ i;
            } else {
                b2 = b2 ^ i;
            }
        }

//        System.out.println(b1);
//        System.out.println(b2);

        return new int[]{b1, b2};
    }
}
