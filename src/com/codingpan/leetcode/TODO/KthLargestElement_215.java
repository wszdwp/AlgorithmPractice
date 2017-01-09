package com.codingpan.leetcode.TODO;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @link https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * @author pan
 *
 */

public class KthLargestElement_215 {
	//	public int findKthLargest(int[] nums, int k) {
	//		int ans = -1;
	//		int len = nums.length;
	//		if (len == 0 || len < k)	return ans;
	//		
	//		// sort and find
	//		Arrays.sort(nums);
	//		ans = nums[len-k];
	//		
	//        return ans;
	//    }

	// quick select
	public int findKthLargest(int[] nums, int k) {
		int ans = -1;
		int len = nums.length;
		if (len == 0 || len < k)	return ans;

		//
		

		return ans;
	}

	//	Heap
	//	public int findKthLargest(int[] nums, int k) {
	//		int ans = -1;
	//		int len = nums.length;
	//		if (len == 0 || len < k)	return ans;
	//		
	//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
	//			@Override
	//			public int compare(Integer o1, Integer o2) {
	//				// TODO Auto-generated method stub
	//				if (o1 > o2) {
	//					return 1;
	//				} else if (o1 < o2) {
	//					return -1;
	//				} else {
	//					return 0;
	//				}
	//			}
	//		});
	//		
	//		for (Integer n : nums) {
	//			pq.offer(n);
	//			if (pq.size() > k) {
	//				pq.poll();
	//			}
	//		}
	//		
	//		
	//		System.out.println("pq " + pq);
	//        return pq.peek();
	//    }


	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 2;

		KthLargestElement_215 sol = new KthLargestElement_215();
		System.out.println("ans(exp: 5) = " + sol.findKthLargest(nums, k));
	}
}
