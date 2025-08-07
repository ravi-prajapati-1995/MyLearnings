package com.ravi.learnings.dsa.binarySearch.on2DArray;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/description/">Here</a>
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
         1   4   7   11  15
         2   5   8   12  19
         3   6   9   16  22
         10  13  14  17  24
         18  21  23  26  30

 */
public class SearchIn2DMatrix_2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 20));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length - 1;

        int rowNumber = 0;
        int columnNumber = columns;

        while(rowNumber < rows && columnNumber >= 0) {
            int currElement = matrix[rowNumber][columnNumber];
            if(currElement > target) {
                columnNumber--;
            } else if(currElement < target) {
                rowNumber ++;
            } else {
                return true;
            }
        }

        return false;
    }
}



