package com.test.dsa.onstrings.basicandeasy;

public class LargestOddNumber {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("4206"));
    }

    public static String largestOddNumber(String num) {
        int idx = 0;
        final var charArray = num.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            final var temp = Integer.valueOf(charArray[i]);
            if (temp % 2 == 1) {
                idx = i + 1;
                break;
            }
        }
        return num.substring(0, idx);
    }
}
