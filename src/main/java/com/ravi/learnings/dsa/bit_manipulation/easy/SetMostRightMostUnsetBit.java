package com.ravi.learnings.dsa.bit_manipulation.easy;

/**
 * Given a non-negative number n . The problem is to set the rightmost unset bit in the binary representation of n.
 * Input: n = 6
 * Output: 7
 * Explanation: The binary representation of 6 is 110. After setting right most bit it becomes 111 which is 7.
 * <p>
 * Input: n = 15
 * Output: 31
 * Explanation: The binary representation of 15 is 01111. After setting right most bit it becomes 11111 which is 31.
 */
public class SetMostRightMostUnsetBit {
    public static void main(String[] args) {
        System.out.println(setMostRightMostUnsetBit(9));
        System.out.println(DecimalToBinary.decimalToBinary(49972));
    }

    public static int setMostRightMostUnsetBit(final int n) {
        /**
         * 6 = 110
         * 7 = 111
         * --------
         * 86 = 1010110
         * 87 = 1010111
         *
         * ---------------------
         * 49971 = 1100001100110011
         * 49972 = 1100001100110100
         *
         * From above observation if we add one in the element of it will set the the rightmost unset bit
         * So we do OR(|) with the current number then we can set the most rightmost bit of the number
         *
         */
        return n | n + 1;
    }
}
