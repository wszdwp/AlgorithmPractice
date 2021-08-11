package com.codingpan.leetcode.passedOJ;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 *
 * <p>Each number in C may only be used once in the combination.
 *
 * <p>Note: All numbers (including target) will be positive integers.
 *
 * <p>The solution set must not contain duplicate combinations. For example, given candidate set
 * [10, 1, 2, 7, 6, 1, 5] and target 8, A solution set is: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6], ]
 */
public class LC040CombinationSum2 {
    //    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //        List<List<Integer>> res = new ArrayList<List<Integer>>();
    //        if (candidates.length == 0 || target <= 0)	return res;
    //
    //        List<Integer> cur = new ArrayList<Integer>();
    //        Arrays.sort(candidates);
    //        helper(candidates, target, 0, cur, res);
    //
    //        return res;
    //    }
    //
    //    private void helper(int[] candidates, int target, int idx, List<Integer> cur,
    // List<List<Integer>> res) {
    //        if (target == 0) {
    //        	res.add(new ArrayList<Integer>(cur));
    //        	return;
    //        }
    //
    //        for (int i = idx; i < candidates.length; i++) {
    //        	if (target < candidates[i])	return;
    //        	if (i > idx && candidates[i-1] == candidates[i])	continue;
    //        	cur.add(candidates[i]);
    //        	helper(candidates, target-candidates[i], i+1, cur, res);
    //        	cur.remove(cur.size()-1);
    //        }
    //    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        Utility.printArray(candidates);
        //        dfs(candidates, target, 0, new ArrayList<Integer>(), ans);
        for (int n = 1; n <= target / candidates[0]; n++) {
            dfs(candidates, target, 0, 0, n, new ArrayList<Integer>(), ans);
        }
        return ans;
    }

    //    private void dfs(int[] candidates, int target, int start, List<Integer> cur,
    // List<List<Integer>> ans) {
    //        if (target == 0) {
    //            ans.add(new ArrayList<>(cur));
    //        } else {
    //            for (int i = start; i < candidates.length; i++) {
    //                if (candidates[i] > target) return;
    //                if (i > start && candidates[i] == candidates[i - 1]) continue;
    //                cur.add(candidates[i]);
    //                dfs(candidates, target - candidates[i], i+1, cur, ans);
    //                cur.remove(cur.size() - 1);
    //            }
    //        }
    //    }

    // with order by length
    private void dfs(
            int[] candidates,
            int target,
            int start,
            int d,
            int n,
            List<Integer> cur,
            List<List<Integer>> ans) {
        if (d == n) {
            if (target == 0) {
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) return;
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, d + 1, n, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        LC040CombinationSum2 sol = new LC040CombinationSum2();
        System.out.println("res " + sol.combinationSum2(candidates, target));
    }
}
