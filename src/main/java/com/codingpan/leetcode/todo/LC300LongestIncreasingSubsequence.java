package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC300LongestIncreasingSubsequence {
    // n^2 solution
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            int currLen = 1;
//            for (int j = i; j >= 0; j--) {
//                if (nums[j] < nums[i] && dp[i] < dp[j]) {
//                    currLen = (currLen < dp[j] + 1) ? dp[j] + 1 : currLen;
//                }
//            }
//            dp[i] = currLen;
//        }
//        int longestLength = 0;
//        for (int i = 0; i < dp.length; i++) {
//            if (dp[i] > longestLength) longestLength = dp[i];
//        }
//
//        return longestLength;
//    }

    // n^2 concise version
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int longestLength = 0;
//        int[] dp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            if (dp[i] > longestLength) longestLength = dp[i];
//        }
//
//        return longestLength;
//    }

    //nlgn
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int longestLength = 0;

        int[] dp = new int[nums.length];
        int[] ends = new int[nums.length];
        ends[0] = nums[0];
        dp[0] = 1;
        int right = 0;

        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < nums.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = l + (r-l)/2;
                if (nums[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = nums[i];
            dp[i] = l + 1;
            if (dp[i] > longestLength) longestLength = dp[i];
        }

        return longestLength;
    }

    public static void main(String[] args) {
        LC300LongestIncreasingSubsequence solu = new LC300LongestIncreasingSubsequence();
        //int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {1, 2, 1, 8, 3, 5, 8 ,4};

        int len = solu.lengthOfLIS(nums);
        StdOut.println("len = " + len);
    }

}
