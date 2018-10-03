package com.codingpan.contests;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

public class Ctx77 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowMax = new int[n];
        int[] colMax = new int[m];
        for (int i = 0; i < n; i++) { rowMax[i] = Integer.MIN_VALUE;}
        for (int i = 0; i < m; i++) { colMax[i] = Integer.MIN_VALUE;}

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[j] = Math.max(grid[i][j], rowMax[j]);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colMax[i] = Math.max(grid[i][j], colMax[i]);
            }
        }

        Utility.printArray(rowMax);
        Utility.printArray(colMax);

        int maxSum = 0;
        int originalSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                originalSum += grid[i][j];
                int sum = Math.min(rowMax[j], colMax[i]);
                StdOut.println(i + ", " + j + "max " + sum);
                maxSum += sum;
            }
        }
        return maxSum-originalSum;
    }

    public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for (int a : A) sum += a;
        boolean[][] dp = new boolean[A.length+1][sum+1];
        dp[0][0] = true;

        for (int i = 0; i < A.length; i++) {
            dp[1][A[i]] = true;
            if (A[i] == 0) dp[i+1][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - A[i-1] >= 0 && dp[i][j-A[i-1]]) dp[i][j] = true;
            }
        }

        Utility.printBooleanMatrix(dp);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]) {
                    double avg = j / i;
                    int total = (int) avg * (A.length+1-i);
                    if (dp[A.length+1-i][total]) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Ctx77 solu = new Ctx77();
//        int[][] grid = {
//                {3, 0, 8, 4},
//                {2, 4, 5, 7},
//                {9, 2, 6, 3},
//                {0, 3, 1, 0}
//        };
//
//        int ans = solu.maxIncreaseKeepingSkyline(grid);
//        StdOut.println(ans);

        int[] A = {1,2,3,4,5,6,7,8};    //true
        //
        boolean res = solu.splitArraySameAverage(A);
        StdOut.println(res);
    }
}
