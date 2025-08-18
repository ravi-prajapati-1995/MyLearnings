package com.ravi.learnings.dsa.bit_manipulation.easy;

import lombok.val;

public class DecimalToBinary {
    public static void main(String[] args) {
        final var decimalToBinary = decimalToBinary(1501);
        System.out.println(decimalToBinary);
        System.out.println(binaryToDecimal(decimalToBinary));
//        decimalToBinary2(14);

    }

    /**
     * 1/2 = 0
     * 1. Take a while loop till we have Quotient is greater than 0 take string builder and append reminder
     * 2.Then store remainder in string builder
     * 3. after completion of the loop we will reverse the string
     *
     */
    public static String decimalToBinary(int val) {
        StringBuilder sb = new StringBuilder();
        while (val > 0) {
            sb.append(val % 2);
            val = val / 2;
        }

        return sb.reverse().toString();
    }

    /**
     * str = "10101"
     * We start from the right to left and start multiplying with 2^0 , 2^1, 2^2... so on till we reaches at the end
     * Take a sum variable and increase it in while loop
     * For each iteration multiply _2pow with 2 as power of 2 getting increase from right to left
     * 
     * */
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
