package com.test.dsa.bit_manipulation.easy;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(decimalToBinary(321));
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
        while(idx >= 0) {

        }
        return 0;
    }
}
