package com.ravi.learnings.dsa.bit_manipulation.easy;

/**
 * Remove last set bit right most from the given number
 * i.e n = 16 --> 10000 we need to remove 4th  bit in the case so result will be ->  00000
 * n=13 = 1101  ->> 1100 , here we remove 0th set vit
 * n = 40 = 101000  -> here we need to remove 3rd bit so result will be: 100000
 * <p>
 * To remove the last set bit observation:
 * 40 = 101000      84 = 1010100
 * 39= 100111       83 = 1010011
 * <p>
 * 16 = 10000
 * 15 = 01111
 * <p>
 * In above example observe that n-1 of any n number mark right most set bit to 0
 * and if we take & of N & N-1 then it will make most right set bit to
 */
public class RemoveLastSetBit {
    public static void main(String[] args) {
        System.out.println(removeMostRightSetBit(84));
    }

    public static int removeMostRightSetBit(int n) {
        return n & n - 1;
    }
}
