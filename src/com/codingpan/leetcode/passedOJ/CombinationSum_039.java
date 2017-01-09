package com.codingpan.leetcode.passedOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
	The same repeated number may be chosen from C unlimited number of times.

	Note:
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.

	For example, given candidate set [2, 3, 6, 7] and target 7, 
	A solution set is: 
	[
	  [7],
	  [2, 2, 3]
	]
 * @author pan
 *
 */

public class CombinationSum_039 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
	    if(candidates == null || candidates.length == 0) return res;

		Arrays.sort(candidates);
		dfs(candidates, target, 0, cur, res);
		return res;
	}

	private void dfs(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
	            if(i>start && candidates[i]==candidates[i-1]) {
	            	System.out.println("i=" + i + " start=" +start);
	            	continue;
	            }

	            if(candidates[i]<=target) {
					cur.add(candidates[i]);
					dfs(candidates, target-candidates[i], i, cur, res);
					cur.remove(cur.size()-1);
	            }
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		CombinationSum_039 sol = new CombinationSum_039();
		List<List<Integer>> res = sol.combinationSum(candidates, target);
		System.out.println("res" + res);
	}
}
