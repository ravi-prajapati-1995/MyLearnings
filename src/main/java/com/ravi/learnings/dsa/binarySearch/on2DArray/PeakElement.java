package com.ravi.learnings.dsa.binarySearch.on2DArray;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-a-peak-element-ii/description/">Problem</a>
 * <a href="https://www.youtube.com/watch?v=nGGp5XBzC4g">Video</a>
 * A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left,
 * right, top, and bottom.
 * <p>
 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j]
 * and return the length 2 array [i,j].
 * You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
 */
public class PeakElement {

    public static void main(String[] args) {
        int[][] array = {
                {7, 6},
                {2, 5},
                {3, 4},
                {1, 2},
                {2, 1}
        };

        final var peakGrid = findPeakGridOptimal(array);
        System.out.println(Arrays.toString(peakGrid));
    }

    /**
     * Here we will use the same technique that we have used for finding peak element for 1D array:
     * i.e:
     * {4, 2, 5, 1, 4, 5},
     * {2, 9, 3, 2, 3, 2},
     * {1, 7, 6, 0, 1, 3},
     * {3, 6, 2, 3, 7, 2}
     * <p>
     * Assume we have above matrix we will have low = 0, high = 5, For first iteration mid will be 2
     * 1. Get the mid column in our case we will get [5, 3, 6, 2]
     * 2. Get max element idx from this colum because if we get then we are sure it will be greater than
     * from it up and down element
     * 3. After get max idx then check for right and left element if current element is greater than those
     * then return as this is peak element
     * 4. if not then we move the low or high based on condition
     * if(arr[row][mid] > arr[row][mid+1]
     * low = mid + 1;
     * else
     * high = mid -1;
     */
    public static int[] findPeakGridOptimal(int[][] mat) {

        int rows = mat.length;
        int columns = mat[0].length;

        int low = 0;
        int high = columns;
        while (low <= high) {
            int mid = (low + high) / 2;
            int idx = getMaxIdx(mat, rows, columns, mid);
            int left = mid - 1 >= 0 ? mat[idx][mid - 1] : -1;
            int right = mid + 1 < columns ? mat[idx][mid + 1] : -1;
            int ele = mat[idx][mid];
            if(ele > left && ele > right) {
                return new int[]{idx, mid};
            } else if(ele > left) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{-1, -1};

    }

    private static int getMaxIdx(final int[][] mat, final int rows, final int colums, final int mid) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            if (mat[i][mid] > max) {
                max = mat[i][mid];
                idx = i;
            }
        }
        return idx;
    }

    /**
     * Here we are going to each element and checking if that element is greater than its all neighbours then we will
     * return it otherwise move to next element
     * <p>
     * TC - O(n*m)
     *
     * @param mat
     * @return
     */
    public static int[] findPeakGrid(int[][] mat) {

        int rows = mat.length;
        int colums = mat[0].length;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < colums; col++) {
                int ele = mat[row][col];
                boolean isPeak = true;

                // left element
                if (col - 1 >= 0 && mat[row][col - 1] > ele) {
                    isPeak = false;
                }

                // top element
                if (isPeak && row - 1 >= 0 && mat[row - 1][col] > ele) {
                    isPeak = false;
                }

                // right element
                if (isPeak && col + 1 < colums && mat[row][col + 1] > ele) {
                    isPeak = false;
                }

                // bottom element
                if (isPeak && row + 1 < rows && mat[row + 1][col] > ele) {
                    isPeak = false;
                }

                if (isPeak) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
