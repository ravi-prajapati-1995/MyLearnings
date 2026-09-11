package com.ravi.learnings.dsa.dynamic_programming;

/**
 * <a href="https://takeuforward.org/plus/dsa/problems/climbing-stairs?source=strivers-a2z-dsa-track">Link</a></br>
 * Given an integer n, there is a staircase with n steps, starting from the 0th step.
 * Determine the number of unique ways to reach the nth step, given that each move can be either 1 or 2 steps at a time.
 * */
public class _002ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n) {
        return climb(0, n);
    }

    public static int climb(int currStep, int n) {
        if(currStep > n) {
            return 0;
        } else if(currStep == n) {
            return 1;
        }

        return climb(currStep + 1, n) + climb(currStep + 2, n);
    }
}
