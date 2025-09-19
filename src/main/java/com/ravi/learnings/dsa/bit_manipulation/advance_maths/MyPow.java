package com.ravi.learnings.dsa.bit_manipulation.advance_maths;

/**
 * <a href="https://leetcode.com/problems/powx-n/submissions/1775622916/">Problem Link</a>
 *
 * <a href="https://takeuforward.org/plus/dsa/problems/pow(x,n)?tab=editorial">Solution</a>
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPowOptimal(2, -2));
    }

    /**
     * For optimal solution lets take an example 2^48
     * We can write it as:
     * 2^48 = (2^2)^24 = (4)^24 --- In this way I am able to reduce the power significantly then
     * 4^24 = (4^2)^12 = 16^12 => (16^2)^6 = (256)^6
     * (256)^6 = (256 ^ 2)^3 => (65536)^3
     * Steps:
     * When power is odd like: 2^49 then we will take out number like 2 * 2 ^ 48
     * When power is event I can break the number in 2^48 = (2 ^ 2) ^ 24 => 4 ^ 24
     * In this way don't need to multiply number with power times
     */
    public static double myPowOptimal(double x, int n) {
        long num = n;
        if (num < 0) {
            x = 1 / x;
            num = -1 * num;
        }

        double res = 1;
        while (num > 0) {
            //when we have odd number
            if (num % 2 != 0) {
                res = res * x;
                num = num - 1;
            } else {
                x = (x * x);
                num = num / 2;
            }
        }
        return res;
    }

    /**
     * TC = O(n)
     * SC: O(1)
     */
    public static double myPow(double x, int n) {
        // We need to handle min value case when we multiply min value with -1 it  didn't give right result
        if (n == Integer.MIN_VALUE) {
            x = 1 / x;
            n = Integer.MAX_VALUE;
        }

        if (n < 0) {
            x = 1 / x;
            n = -1 * n;
        }

        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }

        return result;
    }
}
