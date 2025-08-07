package com.ravi.learnings.dsa.recursion.hard;

import java.util.ArrayList;

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
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        ratInMaze(maze);
    }

    public static ArrayList<String> ratInMaze(int[][] maze) {
        final var strings = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        solveMaze(maze, strings, 0, 0, sb);
        return  null;
    }


    private static void solveMaze(
            final int[][] maze, final ArrayList<String> strings, final int row, final int col,
            StringBuilder sb
    ) {
        if (row == maze.length - 1 && col == maze.length -1 ) {
            System.out.println("-----------------------------");
            strings.add(sb.toString());
            System.out.println(strings);
            return;
        }

        if(row == maze.length || col == maze.length) {
            return;
        }

        for (int i = col; i < maze.length; i++) {

            //check if we can move Right
            if (maze[row][i] == 1) {
                sb.append("R");
                solveMaze(maze, strings, row, i+1 , sb);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                break;
            }
        }

        for (int i = row; i < maze.length; i++) {

            //check if we can move Right
            if (maze[i][col] == 1) {
                sb.append("D");
                solveMaze(maze, strings, i+1, col, sb);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                break;
            }
        }
    }
}
