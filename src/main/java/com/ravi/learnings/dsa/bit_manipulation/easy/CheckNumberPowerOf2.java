package com.ravi.learnings.dsa.bit_manipulation.easy;

public class CheckNumberPowerOf2 {
    public static void main(String[] args) {
        System.out.println(DecimalToBinary.decimalToBinary(666998857));
        System.out.println(isodd(122));
    }

    /**
     * If any number is power of 2 then it will be only having 1 set bit
     * i.e 16 = 10000, 13 = 1101
     * <p>
     * if can use n & n-1 formula as for 16 = 10000 15 = 01111
     * if we do 16 & 15  -> 10000 & 01111 = 0, if it is zero then it is power of 2 otherwise not
     * <p>
     * n = 12  -> 1100  n-1 = 11 -> 1011
     * 1100
     * &1011
     * -----------
     * 1000
     * ---------
     * so 12 is not power of 2
     */
    public static boolean isNumberPowerOf2(int n) {

        return (n & n - 1) == 0;
    }

    public static boolean isodd(int n) {
        return (n & 1) != 0;
    }
}
