package com.codingpan.leetcode.util;

import edu.princeton.cs.algs4.StdOut;

public class ArrayUtil {

    /**
     * Prefix sums of nums, preSum[i] = sum of range [0, j) sum[i, j) = preSum[j] - preSum[i]
     *
     * @param nums
     * @return preSum array
     */
    public static int[] getPrefixSum(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        return preSum;
    }

    /**
     * Unit com.codingpan.test of getPrefixSum()
     */
    private static void getPrefixSumTest() {
        int[] nums = {3, 5, 8, 12, -1, 6, -2};
        printArray(getPrefixSum(nums));
    }

    /**
     * Utility function to format print int array
     *
     * @param arr
     */
    private static void printArray(int[] arr) {
        for (int a : arr) {
            StdOut.print(a + ", ");
        }
        StdOut.println();
    }

    /**
     * Main function
     *
     * @param args
     */
    public static void main(String[] args) {
        getPrefixSumTest();
    }
}
