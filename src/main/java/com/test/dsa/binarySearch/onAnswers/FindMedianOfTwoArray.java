package com.test.dsa.binarySearch.onAnswers;

/**
 *Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * */
public class FindMedianOfTwoArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8};
        double medianSortedArrays = findMedianSortedArraysOptimized(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     * To get the median of and sorted array there are two ways if array has odd elements the arr[length/2] will be median
     * if array has 9 elements the arr[9/2] = arr[4] will be median
     *
     * if array has even number of elements like 10 we need to sum of central elements and the divide them by two
     * i.e len = 10; mid = 10/2 = 5 median = (arr[mid-1] + arr[mid])/2
     *
     * So Here we created a new array which will have all the elements from nums1 and nums2 in sorted order
     * and after that we will find out median
     *
     * TC - O(n+m) -- For storing element in sorted order +
     * SC - O(n+m) -- For creating new array
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length + nums2.length];
        int x = 0;
        int y = 0;
        int idx = 0;

        while (x < nums1.length && y < nums2.length) {
            if (nums1[x] < nums2[y]) {
                arr[idx++] = nums1[x++];
            } else {
                arr[idx++] = nums2[y++];
            }
        }

        for (int i = x; i < nums1.length; i++) {
            arr[idx++] = nums1[i];
        }
        for (int i = y; i < nums2.length; i++) {
            arr[idx++] = nums2[i];
        }

        if ((arr.length % 2) == 1) {
            return arr[arr.length / 2];
        } else {
            return (double) ((arr[(arr.length / 2) - 1] + arr[arr.length / 2])) / 2;
        }
    }

    /**
     * To optimize the above solution we will eliminate extra space that we are using to storing elements
     * nums1 = {1, 3, 5, 7, 9};
     * nums2 = {2, 4, 6, 8};
     * We only need mid and mid-1 element to calculate median so  will will loop till mid
     *
     * */
    public static double findMedianSortedArraysOptimized(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int mid = n / 2;
        int x = 0;
        int y = 0;
        int idx = 0;
        int ele1 = -1;
        int ele2 = -1;

        while ((x < nums1.length && y < nums2.length) && (ele1 == -1 || ele2 == -1)) {
            int curEle;
            if (nums1[x] < nums2[y]) {
                curEle = nums1[x];
                x++;
            } else {
                curEle = nums2[y];
                y++;
            }

            if (idx == (mid - 1)) {
                ele1 = curEle;
            }

            if (idx == mid) {
                ele2 = curEle;
            }
            idx++;
        }

        if (ele1 == -1 || ele2 == -1) {
            while (x < nums1.length) {
                if (idx == (mid - 1)) {
                    ele1 = nums1[x];
                }

                if (idx == mid) {
                    ele2 = nums1[x];
                }
                x++;
                idx++;
            }

            while (y < nums2.length) {
                if (idx == (mid - 1)) {
                    ele1 = nums2[y];
                }

                if (idx == mid) {
                    ele2 = nums2[y];
                }
                y++;
                idx++;
            }
        }

        if ((n % 2) == 0) {
            return (double) (ele1 + ele2) / 2;
        } else {
            return (double) ele2 / 2;
        }
    }

    /**
     * We will select the array which has less numbers of elements, then we will binary search from 0 to n
     * To check the element which we can select from the array
     * nums1 = {1, 3, 5, 7, 9, 13};
     * nums2 = {2, 4, 6, 8};
     * We have total 10 elements to find median we need mid and mid-1 so total element will e 5 and 5 in two half
     * Select nums2 as it has less number of elements, If we select 2 elements from nums2 3 element should be selected
     * from nums1 i.e: n2 = 2, 4 and n1 = 1, 3, 5, 7 will be in first half and in second half n2_ = 6, 8 n1_ = 9, 13
     * We will compare n2[last] < n1_[first] and n1[last] < n2[first]
     * we will take four variable by dividing arrays in 4 parts
     * l1 - left array max element from arr1
     * l2 - left array max element from arr2
     * r1  - right array min element from arr1
     * r2  - right array min element from arr2
     * Valid symmetry will be if l1 < r2 and l2 < r1
     * we will point l1 to the mid and l2
     * */
    public static double findMedianSortedArraysMinimal(int[] nums1, int[] nums2) {
       int n1 = nums1.length;
       int n2 = nums2.length;

       // we will always getting nums1 as smaller array
       if(n1 > n2) return findMedianSortedArraysOptimized(nums2, nums1);

       int low = 0;
       int high = n1;
       //n1 = 3, n2 = 6 so left = (n1 +n2 +1)/2 ==> 10/2 = 5;
        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;
        while(low <= high) {
            int mid1 = (low + high) /2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1 -1 >=0) l1 = nums1[mid1 - 1];
            if(mid2-1 >=0) l2 = nums2[mid1 - 1];

            if(l1 < r2 && l2 < r1) {
                if(n % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.max(l1, l2);
                }
            }

            if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return -1;
    }

}
