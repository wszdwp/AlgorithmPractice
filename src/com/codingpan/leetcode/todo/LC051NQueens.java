package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class LC051NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        return res;
    }

    private void solver(int i, int[] record, int n, List<List<Integer>> idxRes) {

    }

    private List<List<String>> generateRes(int[] record) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
        }
        return res;
    }

    public int num1(int n) {
        if (n < 1) return 0;
        int[] record = new int[n];
        return process1(0, record, n);
    }

    private int process1(int i, int[] record, int n) {
        if (i == n) return 1;
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i+1, record, n);
            }
        }
        return res;
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LC051NQueens solu = new LC051NQueens();
        for (int i = 0; i <= 10; i++) {
            StdOut.println("size " + i + "'s solus = " + solu.num1(i));
        }
    }
}
