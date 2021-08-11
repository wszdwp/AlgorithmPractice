package com.codingpan.leetcodecontests;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Ctx97 {

    /**
     * SaveVMK
     *
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        HashSet<String> one = new HashSet<String>();
        HashSet<String> two = new HashSet<String>();

        List<String> ans = new ArrayList<>();
        for (String s : a) {
            if (one.contains(s)) two.add(s);
            one.add(s);
        }
        for (String s : b) {
            if (one.contains(s)) two.add(s);
            one.add(s);
        }
        for (String s : one) {
            if (!two.contains(s)) ans.add(s);
        }
        String[] aaa = new String[ans.size()];
        int index = 0;
        for (String s : ans) aaa[index++] = s;
        return aaa;
    }

    /**
     * SaveVMK
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        int index = 0;
        for (int q = 0; q < 200; q += 2) {
            for (int i = 0; i < q + 1; i++) {
                if (r0 >= 0 && c0 >= 0 && r0 < R && c0 < C) {
                    ans[index][0] = r0;
                    ans[index++][1] = c0;
                }
                c0++;
            }
            for (int i = 0; i < q + 1; i++) {
                if (r0 >= 0 && c0 >= 0 && r0 < R && c0 < C) {
                    ans[index][0] = r0;
                    ans[index++][1] = c0;
                }
                r0++;
            }
            for (int i = 0; i < q + 2; i++) {
                if (r0 >= 0 && c0 >= 0 && r0 < R && c0 < C) {
                    ans[index][0] = r0;
                    ans[index++][1] = c0;
                }
                c0--;
            }
            for (int i = 0; i < q + 2; i++) {
                if (r0 >= 0 && c0 >= 0 && r0 < R && c0 < C) {
                    ans[index][0] = r0;
                    ans[index++][1] = c0;
                }
                r0--;
            }
        }
        return ans;
    }

    public boolean possibleBipartition(int N, int[][] dl) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < dl.length; i++) {
            int u = dl[i][0] - 1;
            int v = dl[i][1] - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int[] t = new int[N];
        for (int i = 0; i < N; i++) {
            if (t[i] > 0) continue;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(i);
            t[i] = 2;
            while (!q.isEmpty()) {
                int u = q.removeFirst();
                int next = t[u] ^ 1;
                for (int v : g.get(u)) {
                    if (t[v] == 0) {
                        t[v] = next;
                        q.add(v);
                    } else if (t[v] != next) return false;
                }
            }
        }
        return true;
    }

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 2];
        for (int i = 1; i < K; i++) {
            for (int j = 1; dp[i][j - 1] < N; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;
            }
        }
        int j = 1;
        while (dp[K][j - 1] <= N) {
            dp[K][j] = dp[K - 1][j - 1] + dp[K][j - 1] + 1;
            if (dp[K][j] >= N) return j;
            j++;
        }
        return -1;
    }

    // cuiaoxiang
    //    const int d[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //    class MinWindowSubString {
    //        public:
    //        bool valid(int x, int y, int n, int m) {
    //            return x >= 0 && x < n && y >= 0 && y < m;
    //        }
    //        vector<vector<int>> spiralMatrixIII(int n, int m, int x, int y) {
    //            vector<vector<int>> ret = {{x, y}};
    //            int dir = 0;
    //            for (int k = 1; ; ++k) {
    //                for (int i = 0; i < k; ++i) {
    //                    x += d[dir][0];
    //                    y += d[dir][1];
    //                    if (valid(x, y, n, m)) ret.push_back({x, y});
    //                    if (ret.size() == n * m) return ret;
    //                }
    //                dir = (dir + 1) % 4;
    //                for (int i = 0; i < k; ++i) {
    //                    x += d[dir][0];
    //                    y += d[dir][1];
    //                    if (valid(x, y, n, m)) ret.push_back({x, y});
    //                    if (ret.size() == n * m) return ret;
    //                }
    //                dir = (dir + 1) % 4;
    //            }
    //            return ret;
    //        }
    //    };

}
