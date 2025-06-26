package com.test.dsa.recursion;

public class PowOfXbyN {

    public static void main(String[] args) {
        final var v = myPow(2.0, -200000000);
        System.out.println(v);
    }

    public static double myPow(double x, int n) {
        if(n == 0) {
            return x;
        } else if(n > 0) {
            return myPowPositive(x, n);
        } else {
            final var i = ~n + 1;
            final var v = myPowPositive(x, i);
            return 1 / v;
        }
    }

    private static double myPowNegative(final double x, final int n) {
        if(n == 0) {
            return 1;
        }

        return 0;
    }

    public static double myPowPositive(double x, int n) {
        if(n == 0) {
            return 1;
        }

        return x * myPowPositive(x, n - 1);
    }
}
