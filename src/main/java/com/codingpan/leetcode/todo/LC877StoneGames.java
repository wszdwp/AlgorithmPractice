package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC877StoneGames {
    public boolean stoneGame(int[] piles) {
        if (piles == null || piles.length == 0) return false;
        return f(piles, 0, piles.length - 1) > s(piles, 0, piles.length - 1);
    }

    private int f(int[] stones, int l, int r) {
        if (l > r) return 0;
        return Math.max(s(stones, l + 1, r) + stones[l], s(stones, l, r - 1) + stones[r]);
    }

    private int s(int[] stones, int l, int r) {
        if (l == r) return stones[l];
        return Math.min(f(stones, l + 1, r), f(stones, l, r - 1));
    }

    public static void main(String[] args) {
        LC877StoneGames solu = new LC877StoneGames();
        int[] piles = {5, 3, 4, 5};
        boolean res = solu.stoneGame(piles);
        StdOut.println("expected (true): " + res);
    }
}
