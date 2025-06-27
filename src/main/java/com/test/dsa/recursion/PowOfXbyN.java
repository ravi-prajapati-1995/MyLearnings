package com.test.dsa.recursion;

public class PowOfXbyN {

    public static void main(String[] args) {
        final var v = myPow(2.0, -200000000);
        System.out.println(v);
    }

    /**
     *
     * Using Iterative approach
     * 1. Simple multiplying x , n times in for loop
     * 2. In case of number is negative update x to 1/x and multiply n *-1 so that it can converted to positive number
     * 3. return the result
     * @param x -- Number for which we required power
     * @param n --- How many time number should be multiply can be in negative
     * @return
     * TC - O(n) we are using loop
     * SC - O(1) as we are not using any extra space
     */
    public static double myPowBruteForce(double x, int n) {
        double res = 1;
        if(n < 0) {
            n = n * -1;
            x = 1/x;
        }

        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }


    public static double myPow(double x, int n) {
        if(n == 0) {
            return x;
        } else if(n > 0) {
            return myPowPositive(x, n);
        } else {
            final var i = ~n + 1;
            final var v = myPowPositive(1/x, i);
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
