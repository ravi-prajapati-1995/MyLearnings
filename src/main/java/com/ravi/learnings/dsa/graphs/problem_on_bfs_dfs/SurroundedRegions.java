package com.ravi.learnings.dsa.graphs.problem_on_bfs_dfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://takeuforward.org/plus/dsa/problems/surrounded-regions?source=strivers-a2z-dsa-track
 * You are given a matrix mat of size N x M where each cell contains either 'O'
 * or 'X'.
 * 
 * Your task is to replace all 'O' cells that are completely surrounded by 'X'
 * with 'X'.
 */
public class SurroundedRegions {
    public static void main(String[] args) {

    }

    /**
     * To find the indexs which we can replace with X are those
     * 1. Which are not at the corner
     * 2. if any is 0 is at coner any 0 that is connected with that is also can't able to convert in X
     * @param mat
     * @return
     */
    public char[][] fill(char[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int visited[][] = new int[rows][columns];

        Queue<Pair> queue = new ArrayDeque<Pair>();
        char[][] res = new char[rows][columns];
        for(int i =0; i< rows; i++) {
            for(int j = 0; j < columns; j++) {
                res[i][j] = mat[i][j];
            }
        }

        // checking top row if it have 0
        
        
        return null;
    }

    public static class Pair {
        int row;
        int column;
        public Pair(int row, int column) {
            this.row = row;
            this.column =  column;
        }
        
    }
}
