package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class LC826MaxProfitAssignWork {
    //    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    //        if (difficulty == null || profit == null || worker == null) return 0;
    //        if (difficulty.length != profit.length || profit.length == 0 || worker.length == 0)
    // return 0;
    //
    //        int maxProfit = 0;
    //        Point[] points = new Point[difficulty.length];
    //        for (int i = 0; i < points.length; i++) {
    //            Point point = new Point(difficulty[i], profit[i]);
    //            points[i] = point;
    //        }
    //        Arrays.sort(points, new Comparator<Point>() {
    //            @Override
    //            public int compare(Point o1, Point o2) {
    //                return o1.x - o2.x;
    //            }
    //        });
    //        Arrays.sort(worker);
    //
    //        int[] maxLevel = new int[worker.length];
    //        for (int i = 0; i < worker.length; i++) {
    //            int idx = binarySearch(points, worker[i]);
    //            if (idx == points.length || worker[i] != points[idx].x) {
    //                idx = idx - 1;
    //            }
    //            maxLevel[i] = idx;
    //        }
    //        for (int idx : maxLevel) {
    //            int currMax = 0;
    //            while (idx >= 0 && idx < points.length) {
    //                currMax = Math.max(currMax, points[idx].y);
    //                idx--;
    //            }
    //            maxProfit += currMax;
    //
    //        }
    //        return maxProfit;
    //    }

    //    private int binarySearch(Point[] points, int target) {
    //        int low = 0;
    //        int high = points.length-1;
    //        while (low <= high) {
    //            int mid = low + (high - low) / 2;
    //            if (points[mid].x == target) return mid;
    //            else if (points[mid].x < target) low = mid + 1;
    //            else high = mid - 1;
    //        }
    //        return low;
    //    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[]{difficulty[i], profit[i]};
        }
        // sort dp {n * 2 dimensional}: if difficult equal, sort by profit DESC, otherwise by difficult
        // ASC
        Arrays.sort(
                dp,
                new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        if (a[0] != b[0]) return a[0] - b[0];
                        return -(a[1] - b[1]);
                    }
                });
        // xs is sorted difficulty
        int[] xs = new int[n];
        for (int i = 0; i < n; i++) xs[i] = dp[i][0];
        // IMPORTANT!!!  fill the maximum profit,
        // if difficulty is higher, but profit is lower, we need to fill higher profit
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i][1], dp[i - 1][1]);
        }
        int ret = 0;
        for (int w : worker) {
            int ind = Arrays.binarySearch(xs, w);
            if (ind < 0) ind = -ind - 2; // no match, find the lowest match index
            if (ind >= 0) {
                ret += dp[ind][1];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC826MaxProfitAssignWork solu = new LC826MaxProfitAssignWork();
        // ans: 100
        //        int[] difficulty = {2,4,6,8,10};
        //        int[] profit = {10,20,30,40,50};
        //        int[] worker = {4,5,6,7};

        // ans:142
        //        int[] difficulty = {7, 20, 68};
        //        int[] profit = {26, 28, 57};
        //        int[] worker = {71, 20, 71};

        // ans: 0
        //        int[] difficulty = {85,47,57};
        //        int[] profit = {24,66,99};
        //        int[] worker = {40,25,25};

        // 324
        //        int[] difficulty = {68,35,52,47,86};
        //        int[] profit = {67,17,1,81,3};
        //        int[] worker = {92,10,85,84,82};

        // 553
        int[] difficulty = {23, 30, 35, 35, 43, 46, 47, 81, 83, 98};
        int[] profit = {8, 11, 11, 20, 33, 37, 60, 72, 87, 95};
        int[] worker = {95, 46, 47, 97, 11, 35, 99, 56, 41, 92};

        int maxProfit = solu.maxProfitAssignment(difficulty, profit, worker);
        StdOut.println("Max profit = " + maxProfit);
    }
}
