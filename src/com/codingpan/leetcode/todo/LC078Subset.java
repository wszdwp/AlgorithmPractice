package com.codingpan.leetcode.todo;


// [78. Subsets](https://leetcode.com/problems/subsets/)

/*
 * Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */


import com.codingpan.leetcode.util.Utility;

import java.util.*;

public class LC078Subset {
	public List<List<Integer>> subsets(int[] nums) {
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		res.add(new ArrayList<Integer>());
//		Arrays.sort(nums);
//		subsets(nums, 0, new boolean[nums.length], new ArrayList<Integer>(), res);
//		return res;

		return subsetsIterative(nums);
	}

	private void subsets(int[] nums, int start, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
		for (int i = start; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				curr.add(nums[i]);
				res.add(new ArrayList<Integer>(curr));
				subsets(nums, i + 1, used, curr, res);
				curr.remove(curr.size() - 1);
				used[i] = false;
			}
		}
	}

	// iterative
	private List<List<Integer>> subsetsIterative (int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> temp = new ArrayList<List<Integer>>();

			for (List<Integer> subset : subsets) {
				temp.add(new ArrayList<Integer>(subset));
			}

			for (List<Integer> subset: temp) {
				subset.add(nums[i]);
			}

			List<Integer> single = new ArrayList<>();
			single.add(nums[i]);
			temp.add(single);

			subsets.addAll(temp);
		}

		subsets.add(new ArrayList<Integer>());

		return subsets;
	}



	public static void main(String[] args) {
		LC078Subset solu = new LC078Subset();
		int[] nums = {1, 2, 3};
		List<List<Integer>> sub = solu.subsets(nums);
		for (List<Integer> aList : sub) {
			Utility.printIntList(aList);
		}
	}
}
