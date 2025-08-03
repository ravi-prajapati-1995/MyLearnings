package com.test.dsa.recursion.hard;

import java.util.ArrayList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
 queen and an empty space, respectively.
 Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
public class NQueen {
    public static void main(String[] args) {
        solveNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] ch = new char[n][n];
        List<List<String>> l2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            checkQueen(n, i, l2, new ArrayList<>(), 0, 0);
        }
    }

    private static void checkQueen(
            final int totalQueens,
            final int startPosition,
            final List<List<String>> l2,
            final ArrayList<Integer> l1,
            int placedQueens, int row
    ) {

        if(totalQueens == placedQueens) {
            System.out.println(l1);
            System.out.println(l2);
            return;
        }


    }
}
