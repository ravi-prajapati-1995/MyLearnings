package com.test.dsa.recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://takeuforward.org/plus/dsa/problems/combination-sum-iii">Problem Link</a>
 * <p>
 * Determine all possible set of k numbers that can be added together to equal n while meeting the following requirements:
 * There is only use of numerals 1 through 9. A single use is made of each number.
 * Return list of every feasible combination that is allowed. The combinations can be returned in any order,
 * but the list cannot have the same combination twice.
 * <p>
 * Input : k = 3 , n = 7
 * Output : [ [1, 2, 4] ]
 * Explanation :
 * 1 + 2 + 4 = 7
 * <p>
 * There are no other valid combinations.
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        combinationSum3(3, 9);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        final var l2 = new ArrayList<List<Integer>>();
        getNumberStriverWay(k, new ArrayList<>(), l2, 1, 0, n);

        System.out.println("number of times recursion runs: " + count);
        System.out.println(l2);
        return null;
    }

    /**
     * I followed below steps to get this done
     * 1. Start from 1 then follow the take and not take recursion
     * 2. In base case when list reaches to the n then checking the sum of elements
     * 3. If element sum is equal to target sum then storing it in l2
     */
    static int count = 0;

    private static void generateNumberWithSize(
            int k, List<Integer> l1, List<List<Integer>> l2, int number, int sum,
            int targetSum
    ) {
        count++;
        if (number > 10) {
            return;
        }

        if (l1.size() == k) {
            if (sum == targetSum) {
                l2.add(new ArrayList<>(l1));
            }
            return;
        }

        l1.add(number);
        sum = sum + number;

        generateNumberWithSize(k, l1, l2, (number + 1), sum, targetSum);

        l1.removeLast();
        sum = sum - number;

        generateNumberWithSize(k, l1, l2, (number + 1), sum, targetSum);
    }

    private static void getNumberStriverWay(
            int k,
            List<Integer> l1,
            List<List<Integer>> l2,
            int number,
            int sum,
            int targetSum
    ) {
        count++;
        if(number > 9) {
            return;
        }
        if (sum > targetSum || l1.size() > k) {
            return;
        }

        if (l1.size() == k) {
            if(sum == targetSum)
                l2.add(new ArrayList<>(l1));
            return;
        }

        number = l1.isEmpty() ? 1 : number + 1;

        for (int i = number; i < 10; i++) {
            if (sum < targetSum && l1.size() <= k) {
                l1.add(i);
                sum = sum + i;
                getNumberStriverWay(k, l1, l2, i , sum, targetSum);

                sum = sum - i;
                l1.removeLast();
            } else {
                break;
            }
        }
    }
}
