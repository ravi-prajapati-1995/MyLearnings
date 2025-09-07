package com.ravi.learnings.dsa.bit_manipulation.easy;

/**
 * <a href="https://leetcode.com/problems/divide-two-integers/description/">Problem Link</a>
 *Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be
 * truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer
 * range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and
 *   if the quotient is strictly less than -231, then return -231.
 *
 * */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
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
        int d = 1;
        if(dividend < 0) {
            dividend = dividend * -1;
            d = -1;
        }

        int di = 1;
        if(divisor < 0) {
            divisor = divisor * -1;
            di = -1;
        }

        while(number + divisor <= dividend) {
            number += divisor;
            count++;
        }

        if(count > Integer.MAX_VALUE) {
            count = Integer.MAX_VALUE;
        }

        if(count < Integer.MIN_VALUE) {
            count = Integer.MIN_VALUE;

        }
        return Long.valueOf(count).intValue() * d * di;
    }
}
