package com.ravi.learnings.dsa.bit_manipulation.easy;

import lombok.val;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(decimalToBinary(654321));
        System.out.println(binaryToDecimal("10011111101111110001"));
    }

    /**
     * 1. Take a while loop till we h
     */
    public static String decimalToBinary(int val) {
        StringBuilder sb = new StringBuilder();
        while (val != 1) {
            sb.append(val % 2);
            val = val / 2;
        }
        sb.append(1);

        return sb.reverse().toString();
    }

    public static int binaryToDecimal(String bs) {
        var charArray = bs.toCharArray();
        var idx = charArray.length - 1;
        int num = 0;
        int _2pow = 1;
        while(idx >= 0) {
            final var ch = charArray[idx];
            int val = 0;
            if(ch == '1') {
                val = 1;
            }

            num = num + (_2pow * val);
            _2pow = _2pow * 2;
            idx--;
        }
        return num;
    }
}
