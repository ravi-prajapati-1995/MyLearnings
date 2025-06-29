package com.test.dsa.recursion.easy;

public class PrintNamesNTimes {
    public static void main(String[] args) {
        printNamesHeadRecursion(655);
    }

    /**
     * When first you do your job and then call the function it is called tail recursion
     * */
    private static void printNamesTailRecursion(int i) {
        if(i == 0) {
            return;
        }

        i--;
        System.out.println(i + "\t"+ "Ravi");
        printNamesTailRecursion(i);
    }

    /**
     * When first we call recursive function and then do our work like in below case it is called head recursion
     * */
    private static void printNamesHeadRecursion(int i) {
        if(i == 0) {
            return;
        }
        i--;
        printNamesHeadRecursion(i);
        System.out.println(i + "\t"+ "Ravi");
    }
}


