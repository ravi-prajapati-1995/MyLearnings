package com.ravi.learnings.dsa.bit_manipulation.easy;

/**
 * <a href="https://leetcode.com/problems/divide-two-integers/description/">Problem Link</a>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be
 * truncated to 8, and -2.7335 would be truncated to -2.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer
 * range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and
 * if the quotient is strictly less than -231, then return -231.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divideOptimal(2147483647, -1));
    }

    /**
     * In optimal solution lets take we have 22/3 , where dividend = 22 and divisor = 3
     * in brute force approach we are adding divisor till it become greater than of dividend
     * so quotient for 22/3 = 7,
     * <p>
     * we  can write (3*7) = 21
     * 3*(2^2 + 2^1 +2^0) => (3*4) + (3*2) + (3*1) = 21
     * So we will try to remove bigger part of the dividend so that we can reduce the complexity
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divideOptimal(int dividend, int divisor) {
        //base case when we divide 3/3
        if (dividend == divisor) {
            return 1;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        //Handle isPositive
        boolean isPositive = true;
        if (dividend < 0 && divisor >= 0) {
            isPositive = false;
        }
        if (dividend >= 0 && divisor < 0) {
            isPositive = false;
        }

        int n = Math.abs(dividend);
        int d = Math.abs(divisor);

        int ans = 0;

        while (n >= d) {
            // this n will help us to get power of 2
            int count = 0;

            // after that I need to check if number (n) is greater than equal to d * 2^count+1
            // here d << count +1  = d * 2^count+1
            while (n >= (d << (count + 1))) {
                count++;
            }

            //Now we will store and increase the ans till 2^count time as we can remove this number from dividened
            ans += (1 << count);
            //Now we need to decrease that number from the actual number
            n = n - (d * (1 << count));
        }

        // Handling overflowing condition
        if (ans > Integer.MAX_VALUE && isPositive)
            return Integer.MAX_VALUE;
        if (ans > Integer.MAX_VALUE && !isPositive)
            return Integer.MIN_VALUE;

        if (isPositive) {
            return ans;
        }
        return ans * -1;
    }

    public static int divide1(int dividend, int divisor) {

        // Base case
        if (dividend == divisor)
            return 1;

        // Variable to store the sign of result
        boolean isPositive = true;

        // Updating the sign of quotient
        if (dividend >= 0 && divisor < 0)
            isPositive = false;
        else if (dividend < 0 && divisor > 0)
            isPositive = false;

        // Storing absolute dividend & divisor
        int n = Math.abs(dividend);
        int d = Math.abs(divisor);

        // Variable to store the answer
        int ans = 0;

        /* Looping while dividend is
        greater than equal to divisor */
        while (n >= d) {
            int count = 0;

            /* Finding the required
            largest power of 2 */
            while (n >= (d << (count + 1))) {
                count++;
            }

            // Updating the answer & dividend
            ans += (1 << count);
            n -= d * (1 << count);
        }

        // Handling overflowing condition
        if (ans > Integer.MAX_VALUE && isPositive)
            return Integer.MAX_VALUE;
        if (ans > Integer.MAX_VALUE && !isPositive)
            return Integer.MIN_VALUE;

        /* Returning the quotient
        with proper sign */
        return isPositive ? ans : -1 * ans;
    }

    /*
     * To get the Quotient without use of multiplication, division and mod operator
     * we can use + operator
     * we can add divisor in itself till we get a number that is greater than dividend
     *
     * */
    public static int divide(int dividend, int divisor) {
        long count = 0;
        int number = 0;
        int sign = 1;
        if (dividend < 0) {
            sign = -1;
        }

        if (divisor < 0) {
            sign = sign * -1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (number + divisor <= dividend) {
            number += divisor;
            count++;
        }

        if (count > Integer.MAX_VALUE) {
            count = Integer.MAX_VALUE;
        }

        if (count < Integer.MIN_VALUE) {
            count = Integer.MIN_VALUE;
        }
        return Long.valueOf(count).intValue() * sign;
    }
}
