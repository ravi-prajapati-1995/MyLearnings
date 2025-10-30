package com.ravi.learnings.interviewquestions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * I am having a list of strings: cat, atc, tac, dog, god, odg, ac, ca
 * Using stream need to distinguish like cat, atc, tac in one list and dog, god, odg in another
 * in one go ac and ca in another list
 */
public class GroupSimilarWords {
    public static void main(String[] args) {
        final var strings = List.of("cat", "atc", "tac", "dog", "god", "odg", "ac", "ca");

        final var collect = strings.stream().collect(Collectors.groupingBy(GroupSimilarWords::getWordVal));
        System.out.println(collect);
    }

    private static Integer getWordVal(final String ele) {
        int res = 0;
        for (char c : ele.toCharArray()) {
            res += c;
        }
        return res;
    }
}
