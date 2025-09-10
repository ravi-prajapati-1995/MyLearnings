package com.ravi.learnings.dsa.bit_manipulation.interview_problems;

/**
 * <a href="https://leetcode.com/problems/minimum-bit-flips-to-convert-number/submissions/1766141902/">Here</a>
 * A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from
 * either 0 to 1 or 1 to 0.
 * <p>
 * For example, for x = 7, the binary representation is 111 and we may choose any bit (including any
 * leading zeros not shown) and flip it. We can flip the first bit from the right to get 110,
 * flip the second bit from the right to get 101, flip the fifth bit from the right (a leading zero) to get 10111, etc.
 * Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
 */
public class CountNoOfBitFliped {

    public static void main(String[] args) {
        System.out.println(minBitFlips(3, 4));
    }

    /**
     * So to solve this problem:
     * 1. To get the different bit between start and goal we did XOR
     * 2. After getting xor we count the no of set bit, using while loop till value become zero
     *
     * SC = O(1)
     * TC = O(log(xor))
     * */
    public static int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;
        while (xor > 0) {
            count = count + (xor & 1);
            xor = xor >> 1;
        }
        return count;
    }
}
