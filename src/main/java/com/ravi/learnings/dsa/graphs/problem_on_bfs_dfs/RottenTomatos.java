package com.ravi.learnings.dsa.graphs.problem_on_bfs_dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

/**
 * https://takeuforward.org/plus/dsa/problems/rotten-oranges?tab=description&source=strivers-a2z-dsa-track
 * Given an n x m grid, where each cell has the following values :
 * 2 - represents a rotten orange
 * 1 - represents a Fresh orange
 * 0 - represents an Empty Cell
 * <p>
 * Every minute, if a fresh orange is adjacent to a rotten orange in 4-direction
 * ( upward, downwards, right, and left ) it becomes rotten.
 * <p>
 * <p>
 * <p>
 * Return the minimum number of minutes required such that none of the cells has
 * a Fresh Orange. If it's not possible, return -1.
 * Input: grid = [ [2, 1, 1] , [0, 1, 1] , [1, 0, 1] ]
 * Output: -1
 * Explanation: Orange at (3,0) cannot be rotten.
 */
public class RottenTomatos {
    public static void main(String[] args) {
        int[][] arr = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        orangesRottingStriverWay(arr);
    }

    /**
     * if (row, col) represents the then
     * row-1, col --- represents the orange of upside
     * row + 1, col --- represents the down orange
     * row, col-1 ----- for Left side orange
     * row, col + 1 -- for right side orange
     * So if we create a array of [Up, right, down left]
     * delRow = [-1, 0, 1, 0]
     * delCol = [0, 1, 0, -1]
     *
     * For any row, col by adding delRow and delCol we can get the all four side of
     * oranges
     * 
     * @param grid
     * @return
     */
    public static int orangesRottingStriverWay(int[][] grid) {
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        Queue<Pair> queue = new ArrayDeque<>();
        int rows = grid.length;
        int columns = grid[0].length;
        int freshTomato = 0;
        // Get the already rotten tomatoes in the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshTomato++;
                }
            }
        }

        int count = 0;
        int minutes = 0;

        while (!queue.isEmpty()) {
            final var poll = queue.poll();
            minutes = Math.max(minutes, poll.tm);

            // Getting the four neighbours of current
            for (int i = 0; i < 4; i++) {
                int currRow = poll.i + delRow[i];
                int currCol = poll.j + delCol[i];

                // Checking if we get the valid row and col
                if (currRow >= 0 && currRow < rows && currCol >= 0 && currCol < columns
                        && grid[currRow][currCol] == 1) {
                    // Marking current row rotten
                    grid[currRow][currCol] = 2;
                    count++;
                    queue.add(new Pair(currRow, currCol, poll.tm + 1));
                }
            }

        }

        System.out.println(Arrays.deepToString(grid));
        System.out.println(freshTomato + "\t" + count + "\t" + minutes);
        return freshTomato != count ? -1 : 0;
    }

    /**
     * To solve this problem we will start adding the rotten tomatos in the queue
     * 1. Queue will have (position of tomato), time unit,
     * 2. We will get the element from the queue and mark all applicable orange as
     * rotten
     * 3. After marking all orange rotten we will add each of them in queue with
     * time unit
     * 4. We will repeat the process till queue is not empty
     * 
     * TC = N * M
     * SC = N * M
     * @param grid
     * @return
     */
    public static int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new ArrayDeque<>();
        int rows = grid.length;
        int columns = grid[0].length;
        int freshTomato = 0;
        // Get the already rotten tomatoes in the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshTomato++;
                }
            }
        }

        System.out.println(queue);
        int count = 0;
        int minutes = 0;
        while (!queue.isEmpty()) {
            final var poll = queue.poll();
            minutes = Math.max(minutes, poll.tm);

            if (canGoRight(poll, rows, grid)) { // In case we are on top most row we can go up side
                grid[poll.i + 1][poll.j] = 2;
                queue.add(new Pair(poll.i + 1, poll.j, poll.tm + 1));
                count++;
            }

            if (canGoLeft(poll, grid)) {
                grid[poll.i - 1][poll.j] = 2;
                queue.add(new Pair(poll.i - 1, poll.j, poll.tm + 1));
                count++;
            }

            if (canGoUp(poll, grid)) {
                grid[poll.i][poll.j - 1] = 2;
                queue.add(new Pair(poll.i, poll.j - 1, poll.tm + 1));
                count++;
            }

            if (canGoDown(poll, columns, grid)) {
                grid[poll.i][poll.j + 1] = 2;
                queue.add(new Pair(poll.i, poll.j + 1, poll.tm + 1));
                count++;
            }
        }

        System.out.println(Arrays.deepToString(grid));
        System.out.println(freshTomato + "\t" + count + "\t" + minutes);
        return freshTomato != count ? -1 : 0;
    }

    private static boolean canGoDown(final Pair poll, final int columns, final int[][] grid) {
        return poll.j + 1 < columns && grid[poll.i][poll.j + 1] == 1;
    }

    private static boolean canGoUp(final Pair poll, final int[][] grid) {
        return poll.j - 1 >= 0 && grid[poll.i][poll.j - 1] == 1;
    }

    private static boolean canGoRight(final Pair poll, final int rows, final int[][] grid) {
        return poll.i + 1 < rows && grid[poll.i + 1][poll.j] == 1;
    }

    private static boolean canGoLeft(final Pair poll, final int[][] grid) {
        return poll.i - 1 >= 0 && grid[poll.i - 1][poll.j] == 1;
    }

    public static final class Pair {
        public final int i;
        public final int j;
        public final int tm;

        public Pair(int i, int j, int tm) {
            this.i = i;
            this.j = j;
            this.tm = tm;
        }

    }
}
