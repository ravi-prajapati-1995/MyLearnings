package com.ravi.learnings.dsa.stack.monotonic_stack;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/description/">Problem Link</a>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class TrappingWater {

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trapOptimalStriver(height));
    }

    /**
     * So we are using extra space where we are calculating the prefix and postfix max, we need to avoid that
     * 1. we need only one min either from left or right -- only need smaller max
     * 2. So we take two pointer l and r , from left l and from right r
     * 3. Take leftMax and rightMax, and start traversing from 0
     * 4. We are working with on the smaller on i.e {4, 2, 0, 3, 2, 5}
     * 5. Then we will use the same formula to calculate the trap water min(leftmax, rightmax) - arr[i]
     */
    public static int trapOptimal(int[] height) {
        // We need to get left and right max as water is trap between these towers
        int l = 0;
        int r = height.length - 1;

        int leftMax = height[l];
        int rightMax = height[r];
        int res = 0;
        while (r > l) {
            if (height[l] <= height[r]) {
                res = res + (Math.min(leftMax, rightMax) - height[l]);
                l++;
                leftMax = Math.max(leftMax, height[l]);
            } else {
                res = res + (Math.min(leftMax, rightMax) - height[r]);
                r--;
                rightMax = Math.max(rightMax, height[r]);
            }
        }
        return res;
    }

    public static int trapOptimalStriver(int[] height) {
        // We need to get left and right max as water is trap between these towers
        int l = 0;
        int r = height.length - 1;

        int leftMax = height[l];
        int rightMax = height[r];
        int res = 0;
        while (r > l) {
            // We are working with the smaller element so that's why it worked
            if (height[l] <= height[r]) {
                if (leftMax > height[l]) { // In case left max is greater than the current element in that case we can
                    // store water
                    res = res + (leftMax - height[l]);
                } else {
                    leftMax = height[l];
                }

                l++;
            } else {
                if (rightMax > height[r]) {
                    res = res + (rightMax - height[r]);
                } else {
                    rightMax = height[r];
                }
                r--;
            }
        }
        return res;
    }

    /**
     * To store the water in the building there should be taller building in the left and taller in the right
     * And how much water we can store between these taller building is the min(leftMax, rightMax)
     * Now for calculate the water we will decrease the current building hight from left and right taller building
     * so formula will be: min(leftMax, rightMax) - arr[i], where i is the current building
     * Keep in mind if both the left max and right max are greater than arr[i] in that case only
     * if I have 3 building and all have 2 height then water will not be stored
     * <p>
     * TC - O(N) (suffixmax) + O(N) (prefix max) + O(n) to get the trap water  == O(3N)
     * SC - O(3N) --> O(N) -- For get prefix max + O(N) get suffix Max + O(N) to return the result
     */
    public static int trap(int[] height) {
        // To store the total water
        int result = 0;
        int[] prefixMax = getPrefixMax(height);
        int[] suffixMax = getSuffixMax(height);

        for (int i = 0; i < height.length; i++) {

            //water will be stored only if current element is less than from left and right building
            if (height[i] < prefixMax[i] && height[i] < suffixMax[i]) {
                result = result + Math.min(prefixMax[i], suffixMax[i]) - height[i];
            }
        }

        return result;
    }

    /**
     * So this will help us to find out building max building size in the left from the current element
     */
    private static int[] getPrefixMax(final int[] height) {
        int[] prefix = new int[height.length];
        prefix[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        return prefix;
    }

    /**
     * This will helps us to find the taller tower in the right side of the current element
     */
    private static int[] getSuffixMax(final int[] height) {
        final var length = height.length;
        int[] suffix = new int[length];
        suffix[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }
        return suffix;
    }
}
