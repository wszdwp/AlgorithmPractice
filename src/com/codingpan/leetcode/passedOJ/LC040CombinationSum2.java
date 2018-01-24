package com.codingpan.leetcode.passedOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * 
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6],
 * ]
*/

public class LC040CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0 || target <= 0)	return res;
        
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, cur, res);
        
        return res;
    }
    
    private void helper(int[] candidates, int target, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
        	res.add(new ArrayList<Integer>(cur));
        	return;
        }

        for (int i = idx; i < candidates.length; i++) {
        	if (target < candidates[i])	return;
        	if (i > idx && candidates[i-1] == candidates[i])	continue;
        	cur.add(candidates[i]);
        	helper(candidates, target-candidates[i], i+1, cur, res);
        	cur.remove(cur.size()-1);
        }
    }
    
    public static void main(String[] args) {
    	int[] candidates = {10, 1, 2, 7, 6, 1, 5};
    	int target = 8;
    	LC040CombinationSum2 sol = new LC040CombinationSum2();
    	System.out.println("res " + sol.combinationSum2(candidates, target));
    }
}
