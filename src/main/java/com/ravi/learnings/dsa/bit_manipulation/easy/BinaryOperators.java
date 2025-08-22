package com.ravi.learnings.dsa.bit_manipulation.easy;

public class BinaryOperators {
    public static void main(String[] args) {
        //        System.out.println(AND(13, 7));
        //        System.out.println(OR(13, 7));
//        System.out.println("XOR : " + XOR(13, 13));
        //        System.out.println(rightShift(13, 2));
        //        System.out.println(not(-6));
        swap(1, 3);
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
     *
     * Brute Force: We can convert the number into its binary and the traverse from right to left till the ith bit and
     * figure out if it is set or not
     *
     * Using Binary operator:
     *  using Right shift operator:
     * */
    public static void checkithBitSet(int n, int i) {

    }
}
