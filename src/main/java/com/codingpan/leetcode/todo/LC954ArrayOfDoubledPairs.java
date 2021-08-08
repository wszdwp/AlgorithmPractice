package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

/**
 * Given an array of integers A with even length,
 * return true if and only if it is possible to reorder it
 * such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 *
 * Example 1:
 *
 * Input: [3,1,3,6]
 * Output: false
 * Example 2:
 *
 * Input: [2,1,2,6]
 * Output: false
 * Example 3:
 *
 * Input: [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 * Example 4:
 *
 * Input: [1,2,4,16,8,4]
 * Output: false
 */
 public class LC954ArrayOfDoubledPairs {
//    public boolean canReorderDoubled(int[] A) {
//        int n = A.length;
//        if (n == 0) return true;
//        Map<Integer, Integer> map = new TreeMap<>();    // counter
//        for (int i = 0; i < n; i++) {
//            if (!map.containsKey(A[i])) map.put(A[i], 0);
//            map.put(A[i], map.get(A[i]) + 1);
//        }
//
//        for (int x : map.keySet()) {
//            if (map.get(x) == 0) continue;
//            int want = x < 0 ? x / 2 : x * 2;
//            if (x < 0 && x % 2 != 0) return false;
//            int wantValue = map.get(want) == null ? 0 : map.get(want);
//            if (map.get(x) > wantValue) return false;
//            map.put(want, map.get(want) - map.get(x));
//        }
//
//
//        return true;
//    }

    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : A) {
            if (!count.containsKey(a)) {
                count.put(a, 0);
            }
            count.put(a, count.get(a) + 1);
        }
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            int want = x < 0 ? x / 2 : x * 2;
            int wantValue = (count.get(want) == null ? 0 : count.get(want));
            if (x < 0 && x % 2 != 0 || count.get(x) > wantValue) return false;

            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }

//    Map<Integer, Integer> count = new TreeMap<>();
//        for (int a : A)
//            count.put(a, count.getOrDefault(a, 0) + 1);
//        for (int x : count.keySet()) {
//        if (count.get(x) == 0) continue;
//        int want = x < 0 ? x / 2 : x * 2;
//        if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0))
//            return false;
//        count.put(want, count.get(want) - count.get(x));
//    }
//        return true;


    public static void main(String[] args) {
        LC954ArrayOfDoubledPairs solu = new LC954ArrayOfDoubledPairs();
        int[] A = {4, -2, 2, -4};
//        int[] A = {0, 0};
//        int[] A = {-5, -3};
//        int[] A = {-6, -3};
//        int[] A = {1, 2, 4, 8};

        boolean ans = solu.canReorderDoubled(A);
        StdOut.println("ans " + ans);
    }
}
