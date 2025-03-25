package com.test.dsa.binarySearch.on2DArray;

import java.util.Arrays;

/**
 * A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left,
 * right, top, and bottom.
 *
 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j]
 * and return the length 2 array [i,j].
 * You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
 * */
public class PeakElement {

    public static void main(String[] args) {
        int[][] array = {
                {1, 4},
                {3, 2}
        };

        final var peakGrid = findPeakGrid(array);
        System.out.println(Arrays.toString(peakGrid));
    }

    /**
     * Here we will use the same technique that we have used for finding peak element for 1D array:
     * i.e:
     *     {4, 2, 5, 1, 4, 5},
     *     {2, 9, 3, 2, 3, 2},
     *     {1, 7, 6, 0, 1, 3},
     *     {3, 6, 2, 3, 7, 2}
     *
     *Assume we have above matrix we will have low = 0, high = 5, For first iteration mid will be 2
     * So we will check if this element is greater than both its neighbour if yes then we are on the top of vally
     * fif
     * */
    public static int[] findPeakGridOptimal(int[][] mat) {

        int rows = mat.length;
        int colums = mat[0].length;

        return new int[]{-1, -1};

    }
    /**
     * Here we are going to each element and checking if that element is greater than its all neighbours then we will
     * return it otherwise move to next element
     *
     * TC - O(n*m)
     * @param mat
     * @return
     */
    public static int[] findPeakGrid(int[][] mat) {

        int rows = mat.length;
        int colums = mat[0].length;

        for (int row = 0; row < rows; row++) {

            for(int col = 0; col < colums; col++) {
                int ele = mat[row][col];
                boolean isPeak = true;

                // left element
                if(col - 1 >= 0  && mat[row][col-1] > ele) {
                    isPeak = false;
                }

                // top element
                if(isPeak && row -1 >= 0  && mat[row - 1][col] > ele){
                    isPeak = false;
                }

                // right element
                if(isPeak && col + 1 < colums  && mat[row][col+1] > ele) {
                    isPeak = false;
                }

                // bottom element
                if(isPeak && row + 1 < rows  && mat[row + 1][col] > ele){
                    isPeak = false;
                }

                if(isPeak) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
