package com.codingpan.leetcode.todo;

public class LC724FindPivotIndex {
    //	Given an array of integers nums, write a method that returns the "pivot" index of this array.
    //
    //	We define the pivot index as the index where the sum of the numbers to the left of the index is
    // equal to the sum of the numbers to the right of the index.
    //
    //	If no such index exists, we should return -1. If there are multiple pivot indexes, you should
    // return the left-most pivot index.
    //
    //	Example 1:
    //	Input:
    //	nums = [1, 7, 3, 6, 5, 6]
    //	Output: 3
    //	Explanation:
    //	The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to
    // the right of index 3.
    //	Also, 3 is the first index where this occurs.
    //	Example 2:
    //	Input:
    //	nums = [1, 2, 3]
    //	Output: -1
    //	Explanation:
    //	There is no index that satisfies the conditions in the problem statement.
    //	Note:
    //
    //	The length of nums will be in the range [0, 10000].
    //	Each element nums[i] will be an integer in the range [-1000, 1000].

    public static int pivotIndex(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int lSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rSum = sum - nums[i] - lSum;
            if (lSum == rSum) {
                return i;
            }
            lSum += nums[i];
        }
        return -1;
    }

    public static int getPivot(int l, int r) {
        return l + (r - l) / 2;
    }

    private static int isPivotIndex(int[] nums, int pivot) {
        int ls = 0;
        int rs = 0;
        for (int l = 0; l < pivot; l++) {
            ls += nums[l];
        }
        for (int r = nums.length - 1; r > pivot; r--) {
            rs += nums[r];
        }
        if (ls == rs) {
            return 0;
        } else if (ls < rs) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        // int[] nums = {1, 2, 3};
        System.out.println("ans  " + pivotIndex(nums));
    }
}
