package com.ravi.learnings.dsa.graphs.problem_on_bfs_dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Given a binary grid of N x M. Find the distance of the nearest 1 in the grid
 * for each cell.
 * 
 * 
 * 
 * The distance is calculated as |i1 - i2| + |j1 - j2|, where i1, j1 are the row
 * number and column number of the current cell, and i2, j2 are the row number
 * and column number of the nearest cell having value 1.
 */
public class DistanceOfNearestCell {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 0, 0 }
        };
        int[][] res = nearest(matrix);
        System.out.println(Arrays.toString(res));
    }

    /**
     * We need to return the matrix which has distance of 1s for each element
     * 
     * @param grid
     * @return
     */
    public static int[][] nearest(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] temp = new int[row][column]; // This matrix we will return
        int[][] visited = new int[row][column]; // this matrix track if current element is visited or not

        Queue<Pair> queue = new ArrayDeque<Pair>();
        // First we will traverse the matrix and copy it into visited and also add the
        // 1s in queu
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        // After adding all the things we will do the BFS
        while (!queue.isEmpty()) {
            Pair head = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = head.row + delRow[i];
                int newCol = head.col + delCol[i];
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < column && visited[newRow][newCol] == 0) {
                    visited[newRow][newCol] = 1;
                    temp[newRow][newCol] = head.distance + 1;
                    queue.add(new Pair(newRow, newCol, head.distance + 1));
                }
            }

        }

        System.out.println(Arrays.deepToString(visited));
        System.out.println(Arrays.deepToString(temp));

        return temp;

    }

    public static class Pair {
        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

}
