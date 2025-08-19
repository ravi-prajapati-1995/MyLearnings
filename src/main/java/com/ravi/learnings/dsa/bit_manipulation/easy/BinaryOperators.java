package com.ravi.learnings.dsa.bit_manipulation.easy;

public class BinaryOperators {
    public static void main(String[] args) {
        System.out.println(AND(13, 7));
        System.out.println(OR(13, 7));
        System.out.println(XOR(13, 7));
    }


    public static int AND(int a, int b) {
        return a & b;
    }

    public static  int OR(int a, int b) {
        return a | b;
    }
    public static  int XOR(int a, int b) {
        return a ^ b;
    }
}
