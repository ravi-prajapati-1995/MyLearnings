package com.ravi.learnings.dsa.binarySearch.on2DArray;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/description/">here</a>
 * You are given an m x n integer matrix matrix with the following two properties:
 * <p>
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * <p>
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0}};
        System.out.println(searchMatrixOptimal(matrix, 2));
    }

    /**
     * TC - O(n) + log(m) -> Because we iterating over all the rows and log(m) for binary search element from 1D array
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] <= target && matrix[row][columns - 1] >= target) {
                final var lowerBound = lowerBound(matrix[row], target);
                return lowerBound;
            }
        }

        return false;
    }

    /**
     * We know matrix is sorted and we have total m*n elements if we consider it as 1D array. i.e
     * matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}
     * we will consider it [1, 3, 5 ,7, 10, 11, 16, 20, 23, 30, 34, 60]
     * <p>
     * we can use simple binary search on this 1D array.
     * Question: How we will find row and colum as we will have only mid like for first time we have mid = (0+11)/2 =
     * 5 --> arr[5] = 11
     * so to find the row and column we can use below formulas:
     * row = mid/numbers of columns --> 5/4 --> 1 :Because we have four elements in on row so by dividing given number
     * we can find the row in which that element will be.
     * <p>
     * colum: mid%numbers of colums --> 5%4 = 1 same reason every row has 4 elements remaining numbers will give us
     * column so
     * matrix[1][1] = 11 and arr[5] in 1D array is also 11
     * <p>
     * This will help us to reduce time complexity to O(log(m*n))
     */
    public static boolean searchMatrixOptimal(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = 0;
        int high = rows * columns - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int row = mid / columns;
            int col = mid % columns;

            if(matrix[row][col] == target) {
                return true;
            }else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static boolean lowerBound(int[] arr, int target) {
        int result = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return arr[result] == target;
    }
}
