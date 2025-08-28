package com.ravi.learnings.dsa.bit_manipulation.easy;

public class BinaryOperators {
    public static void main(String[] args) {
        //        System.out.println(AND(13, 7));
        //        System.out.println(OR(13, 7));
        //        System.out.println("XOR : " + XOR(13, 13));
        //        System.out.println(rightShift(13, 2));
        //        System.out.println(not(-6));
        //        swap(1, 3);
        //13 = b(1101)
        //        System.out.println(checkithBitSetUsingRightShift(13, 1));
        //        System.out.println(checkithBitSetUsingLeftShift(13, 2));

//        System.out.println(setIthBit(9, 2));
//        System.out.println(clearIthBitUsingNotOperator(1312345, 2));
        System.out.println(toggleithBit(9, 2));
    }

    public static int AND(int a, int b) {
        return a & b;
    }

    public static int OR(int a, int b) {
        return a | b;
    }

    public static int XOR(int a, int b) {
        return a ^ b;
    }

    public static int rightShift(int a, int b) {
        return a >> b;
    }

    public static int leftShift(int a, int b) {
        return a << b;
    }

    public static int not(int a) {
        return ~a;
    }

    /**
     * For swapping we need temp variable so that we can store value of a and after assigning we can assign temp
     * value to b
     * temp = a;
     * a = b;
     * b = temp;
     * <p>
     * We can swap numbers without using third variable and using bitwise XOR operator
     * in XOR event numbers of 1's equal to 0 and odd numbers of 1's equal to 1 so
     * XOR of same number will be alway 0 ie. 5 ^ 5 => b(101) ^ b(101) => 0
     * a = a ^ b
     * b = a ^ b here a will be (a ^ b) ^ b so XOR of b and b become 0 and a value will be assigned to b
     * a = a ^ b  => (a ^ b) ^ a  here a value will be a ^ b and b value will bill a
     */
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("value of a is: " + a + " and b is: " + b);
    }

    /**
     * In this problem we have given a number n and i variable we need to check if the ith bit in number n is set or not
     * n = 13, i = 2 in this we need to check if 2nd bit in 13 is set or not
     * 13 = b(1101) so from right to left we check 2nd bit starting from 0 index so 2nd bit 1 so it is set
     * <p>
     * Brute Force: We can convert the number into its binary and the traverse from right to left till the ith bit and
     * figure out if it is set or not
     * <p>
     * Using Binary operator:
     * using Right shift operator: 13 = b(1101)
     * We can right shift givent number ith times
     * After doing that do & with 1
     * if result is non zero then bit is set
     * Otherwise bit is not set
     */
    public static boolean checkithBitSetUsingRightShift(int n, int i) {
        n = n >> i;
        return (n & 1) != 0;
    }

    /**
     * In left shift operator we will left shift 1 by n
     * After that do & with n
     * <p>
     * 13 = b(1101), i = 2
     * 1 << 2 = 100
     * 1101 & 100 = 0100
     * which is not 0
     */
    public static boolean checkithBitSetUsingLeftShift(int n, int i) {
        i = 1 << i;
        return (n & i) != 0;
    }

    /**
     * left shift 1 ith times, 1<<2 --> 100
     * then make or with the given number i.e 9 = b(1001) | 100 -> 1101 -> 13
     */
    public static int setIthBit(int n, int i) {
        i = 1 << i;
        return (n | i);
    }

    /**
     * 13 = b(1101) if we do & it with 1011, we will do & it with all 1 just 0 at ith place
     * first 1<< i we will get 100 in case of i is 2
     * Then do ~ so that it became 1111111011
     * And then do & with number
     */
    public static int clearIthBitUsingNotOperator(int n, int i) {
        int temp = 1 << i;
        temp = ~temp;
        return n & temp;
    }

    /**
     * 13 = b(1101) if we do ^(XOR) it with 0100, then on 2nd index it will toggle bit
     * first 1<< i we will get 100 in case of i is 2
     * And then do ^ with number
     */
    public static int toggleithBit(int n, int i) {
        return n ^ (1 << i);
    }
}
