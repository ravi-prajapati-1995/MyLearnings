package com.ravi.learnings.dsa.recursion.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1">Problem Link</a><br>
 * Consider a rat placed at position (0, 0) in an n x n square matrix mat[][].
 * The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions:
 * 'U'(up), 'D'(down), 'L' (left), 'R' (right).
 * <p>
 * The matrix contains only two possible values:
 * <p>
 * 0: A blocked cell through which the rat cannot travel.
 * 1: A free cell that the rat can pass through.
 * Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and
 * ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore,
 * the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
 * If no path exists, return an empty list.
 * <p>
 * Note: Return the final result vector in lexicographically smallest order.
 * <p>
 * {1 0 0 0}
 * {1 1 0 1}
 * {1 1 0 0}
 * {0 1 1 1}
 * Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
 * Output: ["DDRDRR", "DRDDRR"]
 * Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR,
 * when printed in sorted order we get DDRDRR DRDDRR.
 */
public class RatInMaze {

    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1}
        };
        ;
        System.out.println(ratInMaze(maze));
    }

    public static ArrayList<String> ratInMaze(int[][] maze) {
        // Base case when starting position is 0 or end position is 0 we can't reach to end to maze
        if (maze[0][0] == 0 || maze[maze.length - 1][maze.length - 1] == 0) {
            return new ArrayList<>();
        }

        final var strings = new ArrayList<String>();
        solveMazeStriver1(maze, strings, 0, 0, "");
//        solveMazeStriver(maze, strings, 0, 0, new StringBuilder());
        Collections.sort(strings);
        return strings;
    }

    private static void solveMazeStriver1(
            final int[][] maze, final ArrayList<String> strings, final int row, final int col,
            String sb
    ) {
        if (row == maze.length - 1 && col == maze.length - 1) {
            strings.add(sb);
            return;
        }

        if (maze[row][col] == 0) {
            return;
        }

        //Marking cell visited
        maze[row][col] = 0;

        // Go To downward direction if we have 1 in that direction and now exceeding the maze length
        if (row < maze.length - 1) {
            solveMazeStriver1(maze, strings, row + 1, col, sb + "D");
        }

        //Go to left direction only if there are element present in it and element is 1 and is greater than 0
        if (col > 0) {
            // then go to left side
            solveMazeStriver1(maze, strings, row, col - 1, sb + "L");
        }

        //Go to right direction only if there are element present in it and element is 1
        if (col < maze.length -1) {
            // then go to right side
            solveMazeStriver1(maze, strings, row, col + 1, sb + "R");
        }

        // Go To Upward direction if we have 1 in that direction and is greater than equals to 0
        if (row > 0) {
            solveMazeStriver1(maze, strings, row - 1, col, sb +"U");
        }

        maze[row][col] = 1;
    }

    /**
     * This is solution that is given in video but still some test cases fails in it trying another way
     */
    private static void solveMazeStriver(
            final int[][] maze, final ArrayList<String> strings, final int row, final int col,
            StringBuilder sb
    ) {
        if (row == maze.length - 1 && col == maze.length - 1) {
            strings.add(sb.toString());
            return;
        }

        // Go To downward direction if we have 1 in that direction and now exceeding the maze length
        if (row + 1 < maze.length && maze[row + 1][col] == 1) {
            maze[row + 1][col] = 0; // we traversed this path so to avoid revisit
            sb.append("D");
            solveMazeStriver(maze, strings, row + 1, col, sb);
            sb.deleteCharAt(sb.length() - 1);
            maze[row + 1][col] = 1;
        }

        //Go to left direction only if there are element present in it and element is 1 and is greater than 0
        if (col - 1 >= 0 && maze[row][col - 1] == 1) {
            maze[row][col - 1] = 0; // we traversed this path so to avoid revisit
            // then go to left side
            sb.append("L");
            solveMazeStriver(maze, strings, row, col - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col - 1] = 1; //Again marking it 1 so that original maze not changed
        }

        //Go to right direction only if there are element present in it and element is 1
        if (col + 1 < maze.length && maze[row][col + 1] == 1) {
            // then go to right side
            maze[row][col + 1] = 0;
            sb.append("R");
            solveMazeStriver(maze, strings, row, col + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col + 1] = 1;
        }

        // Go To Upward direction if we have 1 in that direction and is greater than equals to 0
        if (row - 1 >= 0 && maze[row - 1][col] == 1) {
            maze[row - 1][col] = 0;
            sb.append("U");
            solveMazeStriver(maze, strings, row - 1, col, sb);
            sb.deleteCharAt(sb.length() - 1);
            maze[row - 1][col] = 1;
        }
    }

    /**
     * Below Solution is mine before seeing the solution of striver
     */
    private static void solveMaze(
            final int[][] maze, final ArrayList<String> strings, final int row, final int col,
            StringBuilder sb
    ) {
        if (row == maze.length - 1 && col == maze.length - 1) {
            System.out.println("-----------------------------");
            strings.add(sb.toString());
            System.out.println(strings);
            return;
        }

        if (row == maze.length || col == maze.length) {
            return;
        }

        for (int i = row; i < maze.length; i++) {

            //check if we can move Right
            if (maze[i][col] == 1) {
                //Marking that zero so not visited again
                maze[i][col] = 0;
                sb.append("D");
                solveMaze(maze, strings, i + 1, col, sb);
                sb.deleteCharAt(sb.length() - 1);
                maze[i][col] = 1;
            } else {
                break;
            }
        }

        for (int i = col; i < maze.length; i++) {

            //check if we can move Right
            if (maze[row][i] == 1) {
                maze[row][i] = 0;
                sb.append("R");
                solveMaze(maze, strings, row, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                maze[row][i] = 1;
            } else {
                break;
            }
        }
    }
}
