package com.codingpan.leetcode.todo;

import java.util.Arrays;

public class LC496NextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] ans = new int[nums1.length];
    	for (int i = 0; i < ans.length; i++) {
    		ans[i] = -1;
    	}
    	
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
        	int index = binarySearch(nums2, nums1[i]);
        	if (index != -1 && index < nums2.length-1) {
        		ans[i] = nums2[index+1];
        	}
        }
        
        return ans;
    }
    
    private static int binarySearch(int[] nums, int n) {
    	int l = 0;
    	int r = nums.length-1;
    	while (l <= r) {
    		int m = l + (r - l) / 2;
    		//System.out.println("l/m/r " + l + "/" + m + "/" + r);
    		if (n == nums[m]) {
    			return m;
    		} else if (n < nums[m]){
    			r = m - 1;
    		} else {
    			l = m + 1;
    		}
    	}
    	return -1;
    }
    
    private static void printArray(int[] nums) {
    	for (int n : nums) {
    		System.out.print(n + ", ");
    	}
    	System.out.println("");
    }
    
    public static void main(String[] args) {
    	// ans [-1,3,-1]
    	int[] nums1 = {4, 1, 2};
    	int[] nums2 = {1, 3, 4, 2};
    	
    	int[] ans = nextGreaterElement(nums1, nums2);
    	printArray(ans);
    }
}
