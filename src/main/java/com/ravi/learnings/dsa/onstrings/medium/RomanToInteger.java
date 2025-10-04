package com.ravi.learnings.dsa.onstrings.medium;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        //        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(intToRoman(3749));
    }

    public static int romanToInt(String s) {
        int total = 0;
        int preValue = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {

            int val = switch (c) {
                case 'M' -> 1000;
                case 'D' -> 500;
                case 'C' -> 100;
                case 'L' -> 50;
                case 'X' -> 10;
                case 'V' -> 5;
                case 'I' -> 1;
                default -> 0;
            };

            if (val > preValue) {
                val = val - (2 * preValue);
            }

            total = total + val;
            preValue = val;
        }
        return total;
    }

    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        if (num >= 1000) {
            final var i = num / 1000;
            sb.append("M".repeat(i));
            num = num % 1000;
        }

        if (num >= 500) {
            if (num >= 900) {
                sb.append("CM");
                num = num - 900;
            } else {
                sb.append("D");
                num = num - 500;
            }
        }

        if (num >= 100) {
            if (num >= 400) {
                sb.append("CD");
                num = num - 400;
            } else {
                final var i = num / 100;
                sb.append("C".repeat(i));
                num = num % 100;
            }
        }

        if (num >= 50) {
            if (num >= 90) {
                sb.append("XC");
                num = num - 90;
            } else {
                sb.append("L");
                num = num - 50;
            }
        }

        if (num >= 10) {
            if (num >= 40) {
                sb.append("XL");
                num = num - 40;
            } else {
                final var i = num / 10;
                sb.append("X".repeat(i));
                num = num % 10;
            }
        }

        if (num >= 5) {
            if (num >= 9) {
                sb.append("IX");
                num = num - 9;
            } else {
                sb.append("V");
                num = num - 5;
            }
        }

        if (num >= 4) {
            sb.append("IV");
            num = num - 4;
        }
        if (num > 0) {

            sb.append("I".repeat(num));
        }
        return sb.toString();
    }
}
