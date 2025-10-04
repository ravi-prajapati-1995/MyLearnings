package com.ravi.learnings.dsa.recursion.strong_hold;

public class PowOfXbyN {

    public static void main(String[] args) {
        final var v = myPowOptimalIterative(2, 4);
        System.out.println(v);
    }

    /**
     * Using Iterative approach
     * 1. Simple multiplying x , n times in for loop
     * 2. In case of number is negative update x to 1/x and multiply n *-1 so that it can converted to positive number
     * 3. return the result
     *
     * @param x -- Number for which we required power
     * @param n --- How many time number should be multiply can be in negative
     * @return TC - O(n) we are using loop
     * SC - O(1) as we are not using any extra space
     */
    public static double myPowBruteForce(double x, int n) {
        double res = 1;
        if (n < 0) {
            n = n * -1;
            x = 1 / x;
        }

        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }

    /**
     * in  optimal approach we use math properties that 2^26 = 4^13 = like this
     */
    public static double myPowOptimalIterative(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = n * -1;
            x = 1 / x;
        }
        double res = 1;
        if (n % 2 == 0) {
            res = x;
            n = n - 1;
        }

        while (n > 0) {

            if (n % 2 == 1) {
                res = res * x;
                n = n - 1;
            } else {

                res = res * res;
                n = n / 2;
            }
        }

        return res;
    }

    public static double myPowOptimal(double x, int n) {
        if (n == 0) {
            return 1;
        }
        //base case when n is 1
        if (n == 1) {
            return x;
        }

        long num = n;
        if (n < 0) {
            num = (long) (n * -1);
            x = 1 / x;
        }
        //when n is 3  or any od number we need to manually multipy
        var oddVal = num % 2 * x;
        oddVal = oddVal != 0 ? oddVal : 1;
        final var tmp = myPowOptimal(x, (int) num / 2);
        return (tmp * tmp) * (oddVal);
    }

    public static double myPowOptimalStriverImprovment(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long num = n;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            num = (long) n * -1;
            x = 1 / x;
        }
        //when n is 3  or any od number we need to manually multipy
        if (num % 2 == 1) {
            return x * myPowOptimalStriverImprovment(x, n - 1);
        }

        return myPowOptimalStriverImprovment(x * x, (int) num / 2);
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return x;
        } else if (n > 0) {
            return myPowPositive(x, n);
        } else {
            final var i = ~n + 1;
            final var v = myPowPositive(1 / x, i);
            return 1 / v;
        }
    }

    private static double myPowNegative(final double x, final int n) {
        if (n == 0) {
            return 1;
        }

        return 0;
    }

    public static double myPowPositive(double x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * myPowPositive(x, n - 1);
    }
}
