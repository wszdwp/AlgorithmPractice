package com.codingpan.leetcode.passedOJ;

import com.codingpan.leetcode.util.Utility;

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

public class LC039CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
	    if(candidates == null || candidates.length == 0) return ans;

		Arrays.sort(candidates);
		for (int n = 1; n <= target / candidates[0]; n++) {
			dfs(candidates, target, 0, 0, n, new ArrayList<Integer>(), ans);
		}
//		dfs(candidates, target, 0, cur, res);
		return ans;
	}

//	private void dfs(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> res) {
//		if (target == 0) {
//			res.add(new ArrayList<Integer>(cur));
//			return;
//		} else {
//			for (int i = start; i < candidates.length; i++) {
//	            if(i>start && candidates[i]==candidates[i-1]) {
//	            	System.out.println("i=" + i + " start=" +start);
//	            	continue;
//	            }
//
//	            if(candidates[i]<=target) {
//					cur.add(candidates[i]);
//					dfs(candidates, target-candidates[i], i, cur, res);
//					cur.remove(cur.size()-1);
//	            }
//			}
//		}
//	}

	// with order by depth of the recursion
	private void dfs(int[] candidates, int target, int s, int d, int n, List<Integer> cur, List<List<Integer>> ans) {
		if (d == n) {
			if (target == 0) {
				ans.add(new ArrayList<>(cur));
			}
			return;
		} else {
			for (int i = s; i < candidates.length; i++) {
				if (candidates[i] > target) return;
				cur.add(candidates[i]);
				dfs(candidates, target - candidates[i], i, d + 1, n, cur, ans);
				cur.remove(cur.size() - 1);
			}
		}
	}

	// no order
	// private void dfs(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> ans) {
	//     if (target == 0) {
	//         ans.add(new ArrayList<>(cur));
	//     } else {
	//         for (int i = start; i < candidates.length; i++) {
	//             if (candidates[i] > target) return;
	//             cur.add(candidates[i]);
	//             dfs(candidates, target - candidates[i], i, cur, ans);
	//             cur.remove(cur.size() - 1);
	//         }
	//     }
	// }

	public static void main(String[] args) {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		LC039CombinationSum sol = new LC039CombinationSum();
		List<List<Integer>> ans = sol.combinationSum(candidates, target);
		for (List<Integer> one : ans) {
			Utility.printList(one);
		}
	}
}
