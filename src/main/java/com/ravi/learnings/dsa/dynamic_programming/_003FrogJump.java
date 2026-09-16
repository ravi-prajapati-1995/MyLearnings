package com.ravi.learnings.dsa.dynamic_programming;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/*
* https://takeuforward.org/plus/dsa/problems/frog-jump?source=strivers-a2z-dsa-track&tab=editorial
* A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.
* To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes
* the absolute difference. The frog can jump from any step (ith) either one (i+1) or two (i+2) steps, provided it exists.
* Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
*
*input: heights = [2, 1, 3, 5, 4]
* Output: 2
Explanation:
One possible route can be,
0th step -> 2nd Step = abs(2 - 3) = 1
2nd step -> 4th step = abs(3 - 4) = 1
Total = 1 + 1 = 2.
*  */
public class _003FrogJump {
    // In this problem we need to get the minium amount of energy so we need to find all the ways to get minimum amount of
//    energy so will apply recursion to traverse all the paths
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 3, 5, 4};
        final var i = frogJump(heights);
        System.out.println(i);
    }

    public static int frogJump(int[] heights) {
        final var i = frogJump(heights, heights.length-1);
        return i;
    }

    public static int frogJump(int[] heights, int currStep, int nextStep) {
        System.out.println("Running for: " + currStep + "\t" + nextStep);

        // base case when frog reaches to the end
        if (nextStep == heights.length - 1) {
            return abs(heights[nextStep] - heights[currStep]);
        } else if (nextStep >= heights.length) {
            return 0;
        }

        final var step1 = frogJump(heights, nextStep, nextStep + 1);
        final var step2 = frogJump(heights, nextStep, nextStep + 2);

        System.out.println("step 1: " + step1);
        System.out.println("step 2: " + step2);

        return step1 + step2;
    }

    /*
     * We will consider base step is nth step and we will decrease it
     * */
    public static int frogJump(int[] heights, int currentStep) {
        System.out.println("Running for: " + currentStep);

        // Base case where we reached at the end of the jumps
        if (currentStep == 0)
            return 0;

        int energyForOneJump = frogJump(heights, currentStep - 1) + abs(heights[currentStep] - heights[currentStep - 1]);
        int energyFor2ndJump = Integer.MAX_VALUE;
        if(currentStep > 1) {
            energyFor2ndJump = frogJump(heights, currentStep - 2) + abs(
                    heights[currentStep] - heights[currentStep - 2]);
        }

        return min(energyForOneJump, energyFor2ndJump);
    }

}
