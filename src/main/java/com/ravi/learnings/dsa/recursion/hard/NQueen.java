package com.ravi.learnings.dsa.recursion.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 <a href="https://leetcode.com/problems/n-queens/">Problem Link </a>
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

    /*
     * Will have a character 2d array and initialize it empty
     * So first we try to put Queen in first row 0th column and check we can add all queens
     * */
    public static List<List<String>> solveNQueens(int n) {
        char[][] ch = new char[n][n];
        for (char[] row : ch)
            Arrays.fill(row, '.');

        List<List<String>> l2 = new ArrayList<>();
        // we will try to add queen from 0th to nth index and check if all  queens can pe added
        checkQueen(n, l2, 0, 0, ch);
        return l2;
    }

    /**
     * Steps I have followed while solving the N Queen Problem::
     * 1. Start with 0 row 0 Column and place a Queen then check for this we can place all the queens
     * 2. I wrote a function canPutAt which will check if we can put a Queen at given place this will check
     *      a. If there is any queen from that row and col till top as we are adding queens from top to bottom
     *      b. Then check diagonally by decreasing row number and increasing col number
     *      c. Second diagonally decreasing both row and column
     * 3. I i reached a place where I put all the queens then I will store that answer in the list
     *
     * This solution is not Striver solution
     */
    private static void checkQueen(
            final int totalQueens,
            final List<List<String>> l1,
            int placedQueens, // how many we have placed
            int row, // for which row we are adding Queen
            char[][] ch
    ) {

        if (totalQueens == placedQueens) {
            final var arrayList = new ArrayList<String>();
            for (char[] ar : ch) {
                StringBuilder sb = new StringBuilder();
                for(char aa: ar) {
                    sb.append(aa);
                }
                arrayList.add(sb.toString());
                System.out.println(Arrays.toString(ar) + " ");
            }
            l1.add(arrayList);
            System.out.println("---------------------------------");
            return;
        }

        for (int i = 0; i < totalQueens; i++) {
            if (canPutAt(row, i, ch)) {
                ch[row][i] = 'Q';
                checkQueen(totalQueens, l1, placedQueens + 1, row + 1, ch);
                ch[row][i] = '.';
            }
        }
    }

    private static boolean canPutAt(final int row, final int col, final char[][] ch) {
        if (row == 0) {
            return true;
        }
        //check row if there is any Q in current row from left to right
        final var length = ch.length;
//        for (int i = 0; i < length; i++) {
//            if (ch[row][i] == 'Q') {
//                return false;
//            }
//        }

        //check this column from top to bottom we don't need to check for all rows till because we are placing elements
        // from top to bottom
        for (int c = 0; c <= row; c++) {
            if (ch[c][col] == 'Q') {
                return false;
            }
        }

        // Diagonally check from top left to bottom right
        int i = row;
        int j = col;
        while (i > 0 && j > 0) {
            i--;
            j--;
        }
        //after moving to top then again traverse from top to bottom diagonally
        while (i <= row && j <= col) {
            if (ch[i][j] == 'Q') {
                return false;
            }
            i++;
            j++;
        }

        //secondary diagonal checking from top right to bottom left
        int x = row;
        int y = col;
        while (x > 0 && y < length - 1) {
            x--;
            y++;
        }

        while (x < row && y >= 0) {
            if (ch[x][y] == 'Q') {
                return false;
            }
            x++;
            y--;
        }

        return true;
    }
}
