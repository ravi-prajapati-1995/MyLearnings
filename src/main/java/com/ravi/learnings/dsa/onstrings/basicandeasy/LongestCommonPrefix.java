package com.ravi.learnings.dsa.onstrings.basicandeasy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "floght"};

        //        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {
        final var str = strs[0];
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);
            for (String s : strs) {
                if (!s.startsWith(sb.toString())) {
                    sb.deleteCharAt(sb.length() - 1);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
