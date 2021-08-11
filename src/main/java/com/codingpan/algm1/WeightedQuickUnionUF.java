package com.codingpan.algm1;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
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

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // improvement 2
            i = id[i];
        }

        // improvement 1: path compression with two passes
        // after find root, set company[] of each examined node to the root

        // improvement 2: one pass, halving the finding path
        return i;
    }
}
