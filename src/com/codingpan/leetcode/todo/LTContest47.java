package com.codingpan.leetcode.todo;

public class LTContest47 {
//	665. Non-decreasing Array My SubmissionsBack to Contest
//	Difficulty: Easy
//	Given an array with n integers, 
//	your task is to check if it could become non-decreasing by modifying at most 1 element.
//
//	We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
//
//	Example 1:
//	Input: [4,2,3]
//	Output: True
//	Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
//	Example 2:
//	Input: [4,2,1]
//	Output: False
//	Explanation: You can't get a non-decreasing array by modify at most one element.
//	Note: The n belongs to [1, 10,000].
	
	public static boolean checkPossibility(int[] nums) {
        if (nums.length <= 1)	return true;
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
        	if (nums[i] > nums[i+1]) {
        		count += 1;
        		if (i - 1 < 0 || nums[i-1] <= nums[i+1]) {
        			nums[i] = nums[i+1];
        		} else {
        			nums[i+1] = nums[i];
        		}
        	}
        	if (count >= 2) {
        		return false;
        	}
        }
        
        return true;
    }
	
//	666. Path Sum IV My SubmissionsBack to Contest
//	User Accepted: 739
//	User Tried: 912
//	Total Accepted: 745
//	Total Submissions: 1703
//	Difficulty: Medium
//	If the depth of a tree is smaller than 5, 
//	then this tree can be represented by a list of three-digits integers.
//
//	For each integer in this list:
//	The hundreds digit represents the depth D of this node, 1 <= D <= 4.
//	The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
//	The units digit represents the value V of this node, 0 <= V <= 9.
//	Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.
//
//	Example 1:
//	Input: [113, 215, 221]
//	Output: 12
//	Explanation: 
//	The tree that the list represents is:
//	    3
//	   / \
//	  5   1
//
//	The path sum is (3 + 5) + (3 + 1) = 12.
//	Example 2:
//	Input: [113, 221]
//	Output: 4
//	Explanation: 
//	The tree that the list represents is: 
//	    3
//	     \
//	      1
//
//	The path sum is (3 + 1) = 4.
	
	public static void main(String[] args) {
		int[] nums1 = {3, 4, 2, 3};
		int[] nums2 = {4, 2, 1};
		int[] nums3 = {3, 2, 1};
		int[] nums4 = {4, 2, 3};
		int[] nums5 = {2, 3, 3, 2, 4};
		System.out.println("f " + checkPossibility(nums1));
		System.out.println("f " + checkPossibility(nums2));
		System.out.println("f " + checkPossibility(nums3));
		System.out.println("t " + checkPossibility(nums4));
		System.out.println("t " + checkPossibility(nums5));
	}

}
