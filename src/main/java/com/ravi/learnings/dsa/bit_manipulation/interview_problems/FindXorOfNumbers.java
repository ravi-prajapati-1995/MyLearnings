package com.ravi.learnings.dsa.bit_manipulation.interview_problems;

/**
 * You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].
 * <p>
 * Input:
 * L = 4, R = 8
 * Output:
 * 8
 * Explanation:
 * 4 ^ 5 ^ 6 ^ 7 ^ 8 = 8
 */
public class FindXorOfNumbers {
    public static void main(String[] args) {
        final var xor = findXOR(4, 8);
        System.out.println(xor);
    }

    /**
     * Lets find XOR till
     * 2 = 1^2 = 01 ^ 10 = 11 = 3
     * 3 = 1^2^3 = 01 ^ 10 ^ 11 = 00 = 0
     * 4 = 1^2^3^4 = 001 ^ 010 ^ 011 ^ 100 = 100 = 4
     * 5 = 1^2^3^4^5 = 001 ^ 010 ^ 011 ^ 100 ^ 101 = 001 = 1
     * <p>
     * So from above we can drive a formuls
     * n%4 = 1 then XOR will be 1
     * n%4 = 2 then XOR will be n+1
     * n%4 = 3 then XOR will be 0
     * n%4 = 0 then XOR will be n
     * So if we want to calculate the XOR from 4 to 8 then we will calculate xor for 1 to 3 and then 1 to 8
     * after that XOR both again to get final xor
     */
    public static int findXOR(int l, int r) {
        return xor(l - 1) ^ xor(r);
    }

    private static int xor(int n) {
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        if (n % 4 == 3)
            return 0;

        return n;
    }
}
