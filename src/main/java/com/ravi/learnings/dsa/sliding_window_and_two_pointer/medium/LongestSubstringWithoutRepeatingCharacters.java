package com.ravi.learnings.dsa.sliding_window_and_two_pointer.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
//        System.out.println(longestNonRepeatingSubstring_striver_method(
//                "hvcqifyffjclkozjqmazcwzrfiktwvwkbudvoiuubxgrltjyqiblilcbeusgcumjehgjcztrhhstlptlkstaipoccvtfwrquhyvkwlvdhqqafvnnwgaphvkjpppqkbeaaaaglqwnxhsggglogxmdqkwhmlyjnlwbzuffvxvkxiaodyvkvgjcykhtvwfvlcwjromkvvuviwupddtgqinydoneqeydxeeteglknchzridkholelrdpvofrgychxhoprpfnlykkecdjzcywgrhsuxtjokan"));

        System.out.println(longestNonRepeatingSubstring_optimal("aaabbbccc"));
    }

    /**
     * So this is the brute force solution,
     * we are using 2 loops basically we will create every possible pattern without repeating character
     * start from the 0 top loop then start inner loop from i
     * if we didn't find the current character store that in Hashset
     * If found the check the highest and break the inner loop
     * TC - For each character we are traversing 2 time 1 in outer loop and 2nd in inner loop so tc will be O(n^2) +
     * O(1) to lookup contains
     * SC  - So we are using HasSet to store it will O(Max(l))
     */
    public static int longestNonRepeatingSubstring(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;
            final var characters = new HashSet<Character>();
            for (int j = i; j < s.length(); j++) {
                final var charAt = s.charAt(j);
                if (characters.contains(charAt)) {
                    System.out.println(s.substring(i, j) + " and length is: " + temp);
                    longest = Math.max(longest, temp);
                    break;
                } else {
                    temp++;
                    characters.add(charAt);
                }
            }
            //This is the case when we don't have repeating character and inner loop didn't break
            longest = Math.max(longest, temp);
        }
        return longest;
    }

    /**
     * Instead of using hasset we can create a array of integer with 256 length as we have only 256 characters
     * we will get ascii value for each character and check if the value is 1 or not, if value is 1 then break the
     * inner loop
     * Otherwise mark the current char to 1 and calculate the max length
     * TC - As we are using 2 inner loops so complexity is O(N^2)
     * SC - We are using constant space of 256 digits to ist O(1)
     * */
    public static int longestNonRepeatingSubstring_striver_method(String s) {
        int longest = 0;
        final var charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int arr[] = new int[256];
            for (int j = i; j < s.length(); j++) {
                if(arr[charArray[j]] == 1) {
                    break;
                }

                arr[charArray[j]] = 1;
                longest = Math.max(j - i + 1, longest);
                System.out.println(s.substring(i, j) + "Length: "+ longest);
            }
        }
        return longest;
    }

    /**
     * So to reduce the time complexity we will use the two pointer and sliding window
     * 1. Create two pointer l and r starts from 0 and create a hashmap that will stores the character and its last
     * position
     * 2. Then start a loop from 0 to length of string
     * 3.In the loop check if the current character exists in the Hashmap
     * 4. If Yes, then move the left pointer to the next where we get the current character
     * 5. if No, then keep moving the right pointer r, and add each character in map along with its index
     * 6. Find the max length by checking r - l + 1
     *
     * example: aaabbbccc
     * */
    public static int longestNonRepeatingSubstring_optimal(String s) {
        int longest = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> map = new HashMap<>();
        final var charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {

            if (map.containsKey(charArray[i])) {
                l = map.get(charArray[i]) + 1;
            } else {
                r++;
            }

            map.put(charArray[i], i);

            int length = r -l;
            if(length < 0) {
                continue;
            }

            System.out.println(s.substring(l, r));
            longest = Math.max(length, longest);
        }
        return longest;
    }
}
