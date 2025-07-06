package com.test.dsa.recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1">Problem Link</a>
 * Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.
 *
 * A binary string is that string which contains only 0 and 1.
 * Example 1:
 *
 * Input:
 * N = 3
 * Output:
 * 000 , 001 , 010 , 100 , 101
 * Explanation:
 * None of the above strings contain consecutive 1s. "110" is not an answer as it has '1's occuring consecutively.
 */
public class GenerateAllBinaryString {
    public static void main(String[] args) {
        final var list = new ArrayList<String>();
        generateNumbers(4, "", list);
        System.out.println(list);
    }

    /**
     * In this problem created another function that will take size string and list
     * 1. We start with 0, and call all the recursive call for zero till n become 0
     * 2. When n reaches to zero we have full length string so add that in list
     * 3. For each step we have 2 values either 0 or 1
     * 4. So we recursively call for 0 and 1
     * 5. Finally return the list
     * */
    public static List<String> generateBinaryStrings(int n) {
        // code here
        var list = new ArrayList<String>();
        generateNumbers(n, "", list);
        return list;

    }

    public  static void generateNumbers(int curr, String str, List<String> list) {
        if(curr == 0) {
            list.add(str);
            return;
        }

        generateNumbers(curr - 1, str + "0", list);
        if (str.isEmpty() || str.charAt(str.length() - 1) != '1') {
            generateNumbers(curr - 1, str + "1", list);
        }
    }
}
