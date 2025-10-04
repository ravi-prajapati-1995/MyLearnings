package com.ravi.learnings.dsa.binarySearch.onAnswers;

/**
 * <a href="https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1">Here</a>
 * Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the
 * kth position of the combined sorted array.
 * Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
 * Output: 6
 * Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
 */
public class KthElementOnSortedArrays {
    public static void main(String[] args) {
        int a[] = {2, 3, 6, 7, 9};
        int b[] = {1, 4, 8, 10};
        final var kthElement = kthElement(a, b, 5);
        System.out.println(kthElement);
    }

    public static int kthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;

        // we will always getting nums1 as smaller array
        if (n1 > n2)
            return kthElement(b, a, k);
        int low = Math.max(0, k - n2);
        int high = Math.min(n1, k);
        int left = k;
        int n = n1 + n2;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 < n1)
                r1 = a[mid1];
            if (mid2 < n2)
                r2 = b[mid2];

            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return -1;
    }
}
