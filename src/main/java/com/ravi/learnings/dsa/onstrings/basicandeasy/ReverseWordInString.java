package com.ravi.learnings.dsa.onstrings.basicandeasy;

import java.util.Arrays;

public class ReverseWordInString {
    public static void main(String[] args) {
        String s = "the sky is   blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        final var strings = s.split("\\s+");
        for (int i = strings.length -1 ; i >= 0; i--) {
            sb.append(strings[i] + " ");
        }

        return sb.toString().trim();
    }
}
