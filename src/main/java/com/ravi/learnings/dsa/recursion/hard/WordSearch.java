package com.ravi.learnings.dsa.recursion.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/word-search/description/">Problem Link</a>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (striver(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean striver(char[][] board, String word, int row, int col, int idx) {
        // if idx reaches till word length then we will return true there is only way we reaches this when we find
        // matched string
        if (word.length() == idx) {
            return true;
        }

        // As we marking each column with '' when we visited that if are seeing it again definatly that is not the
        // path we want
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                word.charAt(idx) != board[row][col]) {
            return false;
        }

        // Mark as visited
        char temp = board[row][col];
        board[row][col] = ' ';

        boolean ans = false;
        // This mean we can move upward direction
        ans |= striver(board, word, row - 1, col, idx + 1);

        // we can move in left direction
        ans |= striver(board, word, row, col - 1, idx + 1);

        // if we don't cross the last row
        ans |= striver(board, word, row + 1, col, idx + 1);

        // if we don't cross the last column
        ans |= striver(board, word, row, col + 1, idx + 1);

        board[row][col] = temp;
        return ans;
    }

    /*
     * My code is not working writing striver code
     * */
    public static boolean existNotWorking(char[][] board, String word) {
        boolean isPossible = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Map<Integer, String> map = new HashMap<>();
                    List<Boolean> l1 = new ArrayList<>();
                    checkKar(board, word, i, j, "", 0, map, l1);
                    System.out.println(l1);
                    isPossible = !l1.isEmpty();
                    if (isPossible) {
                        return true;
                    }
                }
            }
        }
        return isPossible;
    }

    private static void checkKar(
            char[][] board, String word, int row, int col, String str, int idx, Map<Integer,
                    String> map, List<Boolean> b
    ) {

        if (word.equals(str)) {
            b.add(true);
            return;
        }

        if ((row < 0 || col < 0)) {
            return;
        }
        if (row > (board.length - 1) || col > board[0].length - 1) {
            return;
        }
        if (board[row][col] == ' ') {
            return;
        }

        final var currentChar = board[row][col];

        if (currentChar == word.charAt(idx)) {
            str = str + currentChar;
            map.put(idx, str + "~~~" + currentChar);
            System.out.println(map);
            idx++;
        } else {
            return;
        }

        board[row][col] = ' ';

        // Go to right
        checkKar(board, word, row, col + 1, str, idx, map, b);

        // Go to left
        checkKar(board, word, row, col - 1, str, idx, map, b);
        //         check up
        checkKar(board, word, row - 1, col, str, idx, map, b);

        // check down
        checkKar(board, word, row + 1, col, str, idx, map, b);
    }
}
