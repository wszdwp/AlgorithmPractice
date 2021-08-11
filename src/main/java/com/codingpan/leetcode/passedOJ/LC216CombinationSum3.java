package com.codingpan.leetcode.passedOJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * <p>Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
 *
 * <p>Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author pan
 */
public class LC216CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (n <= 0 || k <= 0) return res;
        List<Integer> cur = new ArrayList<Integer>();
        helper(k, n, 1, cur, res);

        return res;
    }

    private void helper(int k, int n, int start, List<Integer> cur, List<List<Integer>> res) {
        if (n == 0 && cur.size() == k) {
            res.add(new ArrayList<Integer>(cur));
            return;
        } else {
            if (cur.size() > k || start > 9) {
                return;
            }
            for (int i = start; i <= 9; i++) {
                cur.add(i);
                helper(k, n - i, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int k = 2;
        int n = 7;
        LC216CombinationSum3 sol = new LC216CombinationSum3();
        System.out.println("res" + sol.combinationSum3(k, n));
    }
}
