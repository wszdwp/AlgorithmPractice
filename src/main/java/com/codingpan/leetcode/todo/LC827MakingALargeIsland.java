package com.codingpan.leetcode.todo;

import java.util.Arrays;

public class LC827MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ret = count(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    ret = Math.max(ret, count(grid));
                    grid[i][j] = 0;
                }
            }
        }
        return ret;
    }

    private int count(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        DJSet ds = new DJSet(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 1 < m && grid[i][j] + grid[i][j + 1] == 2) {
                    ds.union(i * m + j, i * m + j + 1);
                }
                if (i + 1 < n && grid[i][j] + grid[i + 1][j] == 2) {
                    ds.union(i * m + j, (i + 1) * m + j);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n * m; i++) {
            ret = Math.max(ret, -ds.upper[i]);
        }
        return ret;
    }

    class DJSet {
        public int[] upper;

        public DJSet(int n) {
            upper = new int[n];
            Arrays.fill(upper, -1);
        }

        public int root(int x) {
            return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
        }

        public boolean equiv(int x, int y) {
            return root(x) == root(y);
        }

        public boolean union(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (upper[y] < upper[x]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                upper[x] += upper[y];
                upper[y] = x;
            }
            return x == y;
        }

        public int count() {
            int ct = 0;
            for (int u : upper) if (u < 0) ct++;
            return ct;
        }
    }
}
