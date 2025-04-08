package com.test.dsa.onstrings.medium;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached.
 * If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range.
 * Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 * */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String s) {
        long result = 0;
        int sign = 1;
        s = s.trim(); // trim leading
        if(s.isEmpty()) return 0;
        final var _1stChar = s.charAt(0);
        if (_1stChar == '-') {
            sign = -1;
            s = s.substring(1);
        } else if (_1stChar == '+') {
            s = s.substring(1);
        }

        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') break;

            final var value = Integer.valueOf(c + "");
            result = (result * 10 + value);
            if ((result * sign) > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if ((result * sign) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) result * sign;
    }
}
