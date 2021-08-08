package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class LC886PossibleBipartition {
    private  Map<Integer, List<Integer>> g;
    private int[] colors;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        colors = new int[N];  // 0 not fill, 1 red, -1 blue
        g = buildGraph(dislikes);
        // dfs
//        for (int i = 0; i < N; i++) {
//            if (colors[i] == 0 && !dfs(i, 1)) return false;
//        }

        // bfs
        if (!bfs(N)) return false;
        return true;
    }

    private boolean dfs(int curr, int color) {
        colors[curr] = color;
        if (g.get(curr) != null) {
            for (int next : g.get(curr)) {
                if (colors[next] == color) return false;
                if (colors[next] == 0 && !dfs(next, -color)) return false;
            }
        }
        return true;
    }

    private boolean bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0) {
                queue.offer(i);
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    if (g.get(curr) != null) {
                        for (int next : g.get(curr)) {
                            if (colors[next] == colors[curr]) return false;
                            if (colors[next] == 0) {
                                colors[next] = -colors[curr];
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] dislikes) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0] - 1;
            int b = dislikes[i][1] - 1;
            if (!g.containsKey(a)) {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                g.put(a, list);
            } else {
                g.get(a).add(b);
            }
            if (!g.containsKey(b)) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                g.put(b, list);
            } else {
                g.get(b).add(a);
            }
        }
        return g;
    }

    public static void main(String[] args) {
        LC886PossibleBipartition solu = new LC886PossibleBipartition();
        // false
        int N = 5;
        int[][] dislikes = {
                {1,2},{2,3},{3,4},{4,5},{1,5}
        };

        // true
//        int N = 4;
//        int[][] dislikes = {
//                {1,2},{1,3},{2,4}
//        };

        // true
//        int N = 1;
//        int[][] dislikes = {};
        StdOut.println(solu.possibleBipartition(N, dislikes));
    }
}
