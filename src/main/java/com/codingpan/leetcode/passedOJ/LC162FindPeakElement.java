package com.codingpan.leetcode.passedOJ;

// [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/)

// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is
// fine.

// You may imagine that num[-1] = num[n] = -∞.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index
// number 2.

// click to show spoilers.

// Credits:
// Special thanks to @ts for adding this problem and creating all com.codingpan.test cases.

public class LC162FindPeakElement {
    // O(n)
    public static int findPeakElement(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }

        int len = num.length;
        if (len == 2) {
            return (num[0] < num[1]) ? 1 : 0;
        }
        for (int i = 1; i < len - 1; i++) {
            if (i == 0 && num[i] > num[i + 1]) {
                return i;
            }

            if (i + 1 == len - 1 && num[i] < num[i + 1]) {
                return i + 1;
            }

            if (num[i - 1] < num[i] && num[i] > num[i + 1]) {
                return i;
            }
        }

        return 0;
    }

    // O(log(n))
    public static int findPeakElement2(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }

        return findPeakUtil(num, 0, num.length - 1, num.length);
    }

    public static int findPeakUtil(int[] arr, int low, int high, int n) {
        // Find index of middle element
        int mid = low + (high - low) / 2; /* (low + high)/2 */

        // Compare middle element with its neighbours (if neighbours exist)
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return mid;

            // If middle element is not peak and its left neighbor is greater than it
            // then left half must have a peak element
        else if (mid > 0 && arr[mid - 1] > arr[mid]) return findPeakUtil(arr, low, (mid - 1), n);

            // If middle element is not peak and its right neighbor is greater than it
            // then right half must have a peak element
        else return findPeakUtil(arr, (mid + 1), high, n);
    }

    public static void main(String[] args) {
        int[] num = {1, 2};
        int[] num1 = {2, 1};
        int[] num2 = {1, 2, 3};
        int[] num3 = {3, 2, 1};

        System.out.println("num " + findPeakElement2(num));
        System.out.println("num1 " + findPeakElement2(num1));
        System.out.println("num2 " + findPeakElement2(num2));
        System.out.println("num3 " + findPeakElement2(num3));
    }
}
