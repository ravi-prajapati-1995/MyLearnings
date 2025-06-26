package com.test.dsa.recursion;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/">Problem Link</a>
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or
 * the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range.
 * Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 * */
public class StringToInteger_Atoi {

    public static void main(String[] args) {
//        final var myAtoi = atoi("   -042");
//        System.out.println(myAtoi);
        final var atoi = getAtoi("42".toCharArray(), 0);
        System.out.println(atoi);
    }



    public static int myAtoiIterative(String s) {

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

    public static int atoi(String s) {
        if(s.isBlank()) {
            return 0;
        }

        final var charArray = s.toCharArray();
        int sign = 1;
        int idx = 0;
        while(charArray[idx] == ' ') {
            idx++;
        }
        if(charArray[idx] == '-') {
            sign = -1;
            idx++;
        } else if(charArray[idx] == '+') {
            idx++;
        }

        while(charArray[idx] == '0') {
            idx++;
        }

        System.out.println(idx + "\t" +s);
        System.out.println(s.substring(idx));
        return 0;
    }

    private static int getAtoi(final char[] charArray, final int i) {
        if(i == charArray.length) {
            return 0;
        }
        final var ch = charArray[i];
        if(ch >= 48 && ch <= 57) {
            int number = Integer.parseInt(ch + "");
            System.out.println(number+"-----------------------------");
            final var res = number * 10 + getAtoi(charArray, i + 1);
            System.out.println(res);
            return res;
        } else {
            return 0;
        }
    }
}
