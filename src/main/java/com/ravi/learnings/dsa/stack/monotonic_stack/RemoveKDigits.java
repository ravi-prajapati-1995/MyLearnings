package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/remove-k-digits/description/">Problem Link</a>
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 *
 *Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * */
public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("112", 1));
    }

    /**
     * To get the minimum I need to remove larger numbers from the left side as these number contribute more in sum
     * 1. Take a stack and start adding number in stack
     * 2. When we get smaller element then the peek element
     * 3. Remove the top element and push the current element
     * 4. Track the number we have removed
     *
     * if we have 112 and k = 1, In that case while we add this in stack and check if any element is greater than val
     * but we didn't found in stack and add that in stack
     * And overall we didn't remove any number
     * */
    public static String removeKdigits(String num, int k) {
        if(num.length() == k) {
            return "0";
        }

        final var st = new Stack<Integer>();

        for(char i: num.toCharArray()) {
            final var value = i - '0';

            while(!st.isEmpty() && st.peek() > value && k > 0) {
                st.pop();
                k--;
            }

            st.push(value);
        }

        // To handle edge case where we have 12345 in string and k = 2 in that case we are not able to remove any number
        while(k > 0) {
            st.pop();
            k--;
        }

        System.out.println(st);
        StringBuilder rs = new StringBuilder(st.size());
        for (final Integer val : st) {
            if (val == 0 && rs.isEmpty()) {
                continue;
            }
            rs = rs.append(val);
        }

        // if stack is having 00000 and then we need to return single 0 onlye
        if(rs.isEmpty()) {
            return "0";
        }

        return rs.toString();
    }
}
