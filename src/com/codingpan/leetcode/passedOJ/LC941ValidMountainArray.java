package com.codingpan.leetcode.passedOJ;

import edu.princeton.cs.algs4.StdOut;

public class LC941ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        if (A[0] >= A[1]) return false;
        int p = 0;
        boolean seenPeak = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i-1]) return false;
            if (A[i] > A[i-1]) {
                if (seenPeak) return false;
                p = i;
            }
            else {
                seenPeak = true;
            }
        }
        return p != 0 && p != A.length - 1;
    }

    public static void main(String[] args) {
        LC941ValidMountainArray solu = new LC941ValidMountainArray();
        int[] A = {3, 5, 5};
//        int[] A = {0, 3, 2, 1};
//        int[] A = {0, 1, 2, 1, 2};
        StdOut.println(solu.validMountainArray(A));
    }

}
