package com.ravi.learnings.dsa;

import java.util.*;
import java.util.stream.Collectors;

public class FindGCDAndHCF {
    public static void main(String[] args) {
//        lcmAndGcd(354293l, 125208l);
        lcmAndGcd(14l, 8l);
    }

    static Long[] lcmAndGcd(final Long a, final Long b) {

        final var gcd = getGcd(a, b);
        final var gcd1 = getGcd1(Math.min(a, b), Math.max(a, b));
        final var lcm = (a * b) / gcd;
        System.out.println("GCD: " + gcd+" GCD 1: "+gcd1+" , LCM: "+lcm);
        return new Long[]{lcm, gcd};
    }

    private static Long getGcd1(Long min, Long max) {
        var result = min;
        var reminder = max % min;
        while(reminder != 0){
            max = min;
            min = reminder;
            result = min;
            reminder = max % min;
        }
        return result;
    };
    private static Long getGcd(Long a, Long b) {
        final var allMultiple = getAllMultiple(a);
        final var allMultiple1 = getAllMultiple(b);
        var smallList = allMultiple;
        var bigList = allMultiple1;
        if(allMultiple.size() != allMultiple1.size()) {
            smallList = allMultiple.size() < allMultiple1.size() ? allMultiple : allMultiple1;
            bigList = allMultiple.size() > allMultiple1.size() ? allMultiple : allMultiple1;
        }
        System.out.println(smallList);
        System.out.println(bigList);
        Long gcd = 1L;
        for (int counter = 0; counter < smallList.size(); counter++) {
            if (bigList.contains(smallList.get(counter))) {
                gcd = smallList.get(counter);
            }
        }
        return gcd;
    }

    private static List<Long> getAllMultiple(final Long a) {
        final var size = (int) Math.sqrt(a);
        final var list = new TreeSet<Long>();
        for (Long counter = 1L; counter <= size; counter++) {
            if (a % counter == 0) {
                list.add(counter);
                final var divisor = a / counter;
                if (counter != divisor) {
                    list.add(divisor);
                }
            }
        }
        return new ArrayList<>(list);
    }
}
