package com.codingpan.leetcode.TODO;

import java.util.Arrays;

/*
 * [164. Maximum Gap](https://leetcode.com/problems/maximum-gap/)
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

* Try to solve it in linear time/space.

* Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Credits:
Special thanks to @porker2008 for adding this problem and creating all test cases.
 */


public class MaximumGap_164 {
	//O(NlogN) Passed
	public static int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2)	return 0;
		
		int maxGap = 0;
		Arrays.sort(nums);
		for (int i = 1 ; i < nums.length; i++) {
			int gap = Math.abs(nums[i] - nums[i-1]);
			if (gap > maxGap) {
				maxGap = gap;
			}
		}
		
		return maxGap;
	}
	
	//O(N) TODO
	public static int maximumGap2(int[] nums) {
		if (nums == null || nums.length < 2)	return 0;
		
		int maxGap = 0;
		//TODO		
		return maxGap;
	}	
	public static void main(String[] args) {
		int[] n = {9, 21, 4, 32, 45, 75};
		System.out.println("Expected(30): " + maximumGap(n));
	}

}
