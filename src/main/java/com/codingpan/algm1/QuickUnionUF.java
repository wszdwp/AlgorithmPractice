package com.codingpan.algm1;

public class QuickUnionUF {
    private int[] id;
    private int count;      // number of connected components

    public QuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
     }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;

        id[i] = j;
        count--;
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }
}
