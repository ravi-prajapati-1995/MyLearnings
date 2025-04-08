package com.test.dsa.onstrings.basicandeasy;

public class RotateString {
    public static void main(String[] args) {
        rotateStringOptimal("abcde", "cdeab");
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            final var c = s.substring(0, i);
            final var s1 = s.substring(i) + c;
            if (s1.equals(goal)) {
                return true;
            }
        }

        return false;
    }

    /**
     *  clever way to exploit this is by concatenating s with itself. Why? Because this effectively creates a string
     *  that contains all possible rotations of s within it. For example, if s = "abcde", then s + s = "abcdeabcde".
     *  Notice how every possible rotation of s appears somewhere in this concatenated string.
     * Check if the lengths of strings s and goal are different:
     *
     * If they are, return false because a rotation of s cannot match goal.
     * Create a new string doubledString by concatenating s with itself.
     *
     * Use a string search method to find the substring goal within doubledString:
     *
     * If goal is found, check if this index is less than the length of doubledString.
     * If it is, return true, indicating that goal is a valid rotation of s. Otherwise, return false.
     * */
    public static boolean rotateStringOptimal(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String doubleString = s + s;

        return doubleString.contains(goal);
    }
}
