package com.codingpan.leetcode.passedOJ;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 *	For example,
 *	Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *	
 *	Window position                Max
 *	---------------               -----
 *	[1  3  -1] -3  5  3  6  7       3
 *	 1 [3  -1  -3] 5  3  6  7       3
 *	 1  3 [-1  -3  5] 3  6  7       5
 *	 1  3  -1 [-3  5  3] 6  7       5
 *	 1  3  -1  -3 [5  3  6] 7       6
 *	 1  3  -1  -3  5 [3  6  7]      7
 *	Therefore, return the max sliding window as [3,3,5,5,6,7].
 *	
 *	Note: 
 *	You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * @author Pan
 *
 */
public class MaxSlidingWindow {
	// Solu 1
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		if (len < 1 || k == 0) {
            return nums;
        }
        int[] maxWin = new int[len - k + 1];
        int i = 0;
        for (int s = 0; s < len-k+1; s++) {
        	int e = s + k -1;
//        	System.out.println("index " + s + "," + e);
        	maxWin[i] = findPeak(nums, s, e);
        	i++;
        }
        
        return maxWin;
    }
	
	public static int findPeak(int[] nums, int s, int e) {
		int peak = Integer.MIN_VALUE;
		while (s <= e && e < nums.length && s >=0) { 
			if (peak < nums[s]) {
				peak = nums[s];
			}
			s++;
		}
		
		return peak;
	}
	
	// Solu 2
	public static int[] maxSlidingWindow2(int[] nums, int k) {
		int len = nums.length;
		if (len < 1 || k == 0) {
            return nums;
        }
        int[] maxWin = new int[len - k + 1];
        int i = 0;
        int peakIndex = -1;
        int peak = 0;
        for (int s = 0; s < len-k+1; s++) {
        	int e = s + k -1;
        	if (peakIndex < s) {
        		int[] peakAndIndex = findPeak2(nums, s, e);
        		peak = peakAndIndex[0];
            	peakIndex = peakAndIndex[1];
        	} else {
        		if (peak < nums[e]) {
        			peak = nums[e];
        			peakIndex = e;
        		}
        	}	
        	maxWin[i] = peak;
        	i++;
        }
        
        return maxWin;
    }
	
	public static int[] findPeak2(int[] nums, int s, int e) {
		int[] peakAndIndex = {Integer.MIN_VALUE, Integer.MIN_VALUE};
		while (s <= e && e < nums.length && s >=0) { 
			if (peakAndIndex[0] < nums[s]) {
				peakAndIndex[0] = nums[s];
				peakAndIndex[1] = s;
			}
			s++;
		}
		
		return peakAndIndex;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3,-1, -3, 5, 3, 6, 7};
		int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 2};
		printTest(maxSlidingWindow(arr, 3));
		printTest(maxSlidingWindow(arr2, 3));
		printTest(maxSlidingWindow2(arr, 3));
		printTest(maxSlidingWindow2(arr2, 3));
	}
	
	public static void printTest(int[] res) {
		System.out.println("result is ");
		
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + ", ");
		}
		System.out.println();
	}

}
