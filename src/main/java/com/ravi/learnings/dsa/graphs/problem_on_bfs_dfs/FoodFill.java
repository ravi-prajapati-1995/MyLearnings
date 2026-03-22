package com.ravi.learnings.dsa.graphs.problem_on_bfs_dfs;

import java.util.Arrays;

/**
 * https://takeuforward.org/plus/dsa/problems/flood-fill-algorithm?source=strivers-a2z-dsa-track
 */
public class FoodFill {
    static int[] delRow = {-1, 0, 1, 0};
    static int[] delCol = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        floodFill(arr, 1, 1, 2);
    }

    /**
     * So for foodFill
     * Create a duplicate array so that we don't need to change the given image
     * 1. Call DFS for the the given sr, sc
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final var rows = image.length;
        final var columns = image[0].length;
        int[][] visted = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                visted[i][j] = image[i][j];
            }
        }

        final var existingColour = visted[sr][sc];

        dfs(visted, sr, sc, existingColour, newColor);
        System.out.println(Arrays.deepToString(visted));
        return visted;
    }

    public static void dfs(int[][] image, int sr, int sc, int existingColor, int newColor) {
        //        System.out.println("Doint for: " + sr + "\t" + sc);

        if(image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int row = delRow[i] + sr;
            int col = delCol[i] + sc;

            if (row >= 0 && row < image.length && col >= 0 && col < image[0].length &&
                    image[row][col] == existingColor) {
                dfs(image, row, col, existingColor, newColor);
            }
        }
    }
}
