package com.codingpan.leetcode.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 * 
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 * 
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 * 
 * @author pan
 *
 */

public class LC377CombinationSum4 {
	public List<List<Integer>> combinationSum4(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if (nums.length == 0 || target <= 0)	return res;
		List<Integer> cur = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, target, 0, cur, res);
        
		return res;
    }
	
	private void dfs(int[] nums, int target, int start, List<Integer> cur, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		} else {
			for (int i = start; i < nums.length; i++) {
				if (target < nums[i])	return;
				cur.add(nums[i]);
				dfs(nums, target-nums[i], 0, cur, res);
				cur.remove(cur.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int target = 4;
//		int[] nums = {3, 1, 2, 4};
//		int target = 4;
//		int[] nums = {4, 2, 1};
//		int target = 32;
		LC377CombinationSum4 sol = new LC377CombinationSum4();
		System.out.println("res" + sol.combinationSum4(nums, target));
	}

}
