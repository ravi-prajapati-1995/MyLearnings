package com.ravi.learnings.dsa.binarySearch.on2DArray;

/**
 * <a href="https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1">Problem</a>
 * Given a row-wise sorted matrix where the number of rows and columns is always odd,
 * find the median of the matrix.
 * <p>
 * Input: mat = [[1, 3, 5], [2, 6, 9], [3, 6, 9]]
 * Output: 5
 * Explanation: Sorting matrix elements gives us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median.
 * odd * odd = odd
 */
public class MedianRowWiseSortedMatrix {

    public static void main(String[] args) {
        int[][] mat = {
                {18, 79, 79},
                {36, 75, 79},
                {0, 8, 11}};
        //[0, 8, 11, 18, 36, 75, 79, 79, 79]
        System.out.println(median(mat));
    }

    /**
     * {1, 3, 5},
     * {2, 6, 9},
     * {3, 6, 9}
     * <p>
     * Here given that rows and column are odd, and we know that multiply of two odd gives always odd, so there
     * always one element which divide array in two half.
     * from above matrix arr = [1, 2, 3, 3, 5, 6, 6, 9, 9] in this example 5 will be element which has 4 elements in left
     * and 4 in right
     * <p>
     * So we need to find and return this 5
     * To do this we need to find that for a given number how many elements are in left and how many are in right
     * <p>
     * We can use binary search on answers steps below:
     * 1. find min and max of array by traverse first column and last column from top to bottom
     * 2. Find the mid and call a function that will give us how many element present in left of this element
     * 3. If element are less than equal to half of matrix(m*n/2) then we will increase low = mid + 1 else high = mid -1
     * 4. And after that return low it will point to center
     * <p>
     * How to Calculate count of elements present in left of any element:
     * 1. we will found the upper bound for each row for the given element
     * 2. Process this for all the row and count the numbers
     * 3. return the number
     */
    static int median(int mat[][]) {
        int rows = mat.length;
        int columns = mat[0].length;
        int low = getMin(mat, rows);
        int high = getMax(mat, columns, rows);
        int half = (rows * columns) / 2;
        //[0, 8, 11, 18, 36, 75, 79, 79, 79]
        while (low <= high) {
            int mid = (low + high) / 2;
            final var leftElements = getLeftElements(mat, mid);
            if (leftElements <= half) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int getLeftElements(final int[][] mat, final int mid) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            count += getUpperBound(mat[i], mid);
        }
        return count;
    }

    private static int getUpperBound(final int[] arr, final int element) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int getMin(final int[][] mat, int rows) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            min = Math.min(min, mat[i][0]);
        }
        return min;
    }

    private static int getMax(final int[][] mat, int column, int rows) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            max = Math.max(max, mat[i][column - 1]);
        }
        return max;
    }
}

