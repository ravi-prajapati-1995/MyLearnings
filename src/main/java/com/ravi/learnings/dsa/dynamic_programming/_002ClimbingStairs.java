package com.ravi.learnings.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * <a href="https://takeuforward.org/plus/dsa/problems/climbing-stairs?source=strivers-a2z-dsa-track">Link</a></br>
 * Given an integer n, there is a staircase with n steps, starting from the 0th step.
 * Determine the number of unique ways to reach the nth step, given that each move can be either 1 or 2 steps at a time.
 *
 */
public class _002ClimbingStairs {
    public static void main(String[] args) {
        climbStairs(5);
    }

    public static void climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(climb(0, n, dp));
        System.out.println(Arrays.toString(dp));
        System.out.println(climb1(n, n));
        System.out.println("Using tabulation "+ UsingTabulation.climb(n));
        System.out.println("Space optimization tabulation "+ SpaceOptimization.climb(n));
    }

    /*
     * In this implementation I took steps from 1 to n, like I am standing at ground and first step will be 1 then 2 then 3
     * and goes on till n, We can do the reverse also like I will be at nth step and see below climb1
     * */
    public static int climb(int currStep, int n, final int[] dp) {
        // Base case when we reached beyond the stairs
        if (currStep > n) {
            return 0;
            // When we are first step
        } else if (currStep == n) {
            return 1;
        }

        if (dp[currStep] != -1) {
            return dp[currStep];
        }


        int totalSteps = climb(currStep + 1, n, dp) + climb(currStep + 2, n, dp);
        dp[currStep] = totalSteps;

        return totalSteps;
    }

    public static int climb1(int currStep, int n) {
        // Base case when we reached to top
        if (currStep == 0) {
            return 1;
            // When we took more steps then reached to top
        } else if (currStep < 0) {
            return 0;
        }

        return climb1(currStep - 1, n) + climb1(currStep - 2, n);
    }

}

class UsingTabulation {
    public static int climb(int n) {
//        Creating array of n+1 elements
        int[] tb = new int[n + 1];

//        Setting base cases
        tb[0] = 1;
        tb[1] = 1;

//        solving the big problem
        for (int i = 2; i <= n; i++) {
            tb[i] = tb[i-1] + tb[i-2];
        }

        System.out.println(Arrays.toString(tb));
        return tb[n];
    }
}

// In space optimization we don't need to create tb array as we just needed 2 variables
class SpaceOptimization {
    public static int climb(int n) {
//        Creating array of n+1 elements

//        Setting base cases
        int prev1 = 1;
        int prev2 = 1;
        int result = 0;
//        solving the big problem
        for (int i = 2; i <= n; i++) {
            result = prev2 + prev1;
            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }
}
