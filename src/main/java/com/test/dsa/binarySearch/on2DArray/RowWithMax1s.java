package com.test.dsa.binarySearch.on2DArray;

/**
 * <a href="https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1">here</a>
 *You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order.
 * Your task is to find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.
 *
 * Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1], [0,0,0,0]]
 * Output: 2
 * Explanation: Row 2 contains the most number of 1s (4 1s). Hence, the output is 2.
 *
 * */
public class RowWithMax1s {
    public static void main(String[] args) {
        int arr[][] = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println(rowWithMax1sOptimal(arr));

    }

    public static int rowWithMax1s(int arr[][]) {
        // code here
        int rows = arr.length;
        int columns = arr[0].length;
        int max = 0;
        int resultedRow = -1;
        for(int row = 0; row < rows; row++) {
            int currMax = 0;
            for(int col = 0; col < columns; col++) {
                if(arr[row][col] == 1) {
                    currMax = columns - col + 1;
                    if(currMax > max) {
                        max = currMax;
                        resultedRow = row;
                    }
                }
            }
        }
        return resultedRow;
    }

    public static int rowWithMax1sOptimal(int arr[][]) {
        // code here
        int rows = arr.length;
        int columns = arr[0].length;
        int max = 0;
        int resultedRow = -1;
        for(int row = 0; row < rows; row++) {
            int currMax;
            int intialIdx = getCountOf1s(arr[row]);
            int curMax = columns - intialIdx;

            if(curMax > max) {
                max = curMax;
                resultedRow = row;
            }

        }
        return resultedRow;
    }

    private static int getCountOf1s(final int[] arr) {
       int low =0;
        int high = arr.length - 1;

       while(low <= high) {
           int mid = (low + high) / 2;

           if(arr[mid] == 0) {
               low = mid + 1;
           } else {
               high = mid - 1;
           }
       }
        return low;
    }
}
