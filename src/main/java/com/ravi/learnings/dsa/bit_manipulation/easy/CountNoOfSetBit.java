package com.ravi.learnings.dsa.bit_manipulation.easy;

/**
 * Given a number count the number of set bit for that number
 */
public class CountNoOfSetBit {

    public static void main(String[] args) {
        System.out.println(countSetBitsUsingBitWiseOperators(6));
    }

    /**
     * Brute Force: Divide the number by 2 each time I get 1 then will increase the count variable
     */
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }

            n = n / 2;
        }
        return count;
    }

    public static int countSetBitsUsingBitWiseOperators(int n) {
        int count = 0;
        while (n > 0) {
            // Here I can user count = n & 1, because n & 1 give 1 if  n is odd and 0 if n is event
            count += n & 1;

            // we can write n = n/2  ->> n>>1
            n = n >> 1;
        }
        return count;
    }
}
