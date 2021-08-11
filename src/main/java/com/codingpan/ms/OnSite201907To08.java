package com.codingpan.ms;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OnSite201907To08 {
    /**
     * 题目1：一个int数组 求subarray 和的最大值 median难度 dp 空间复杂度O(1)即可
     */
    public static int maxSubSum(int[] A) {
        if (A == null || A.length == 0) return 0;
        int maxSum = A[0];
        int curMax = A[0];
        for (int i = 1; i < A.length; i++) {
            if (curMax > 0) {
                curMax = curMax + A[i];
            } else {
                curMax = A[i];
            }
            maxSum = Math.max(maxSum, curMax);
        }
        return maxSum;
    }

    /**
     * 题目2，给定一个int 数组 问该数组是否可以拆分成两个 数组 使得两个数组和相同 返回boolean
     *
     * @param A
     * @return
     */
    public static boolean canSplitEven(int[] A) {
        if (A == null || A.length == 0) return true;
        if (A.length == 1) return false;
        Arrays.sort(A);
        Set<Integer> set = new HashSet<>();
        int totalSum = 0;
        for (int i = 0; i < A.length; i++) {
        }
        return false;
    }

    public static void main(String[] args) {
        // int[] A = {-2, -3, 4, -1, -2, 1, 5, -3};    // exp 7
        int[] A = {-5, -3, -4}; // exp -2

        int ans = maxSubSum(A);
        StdOut.println("ans " + ans);
    }
}
