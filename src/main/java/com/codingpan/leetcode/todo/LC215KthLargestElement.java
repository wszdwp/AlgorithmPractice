package com.codingpan.leetcode.todo;

/**
 * @author pan
 * @link https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class LC215KthLargestElement {
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
        if (len == 0 || len < k) return ans;

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
    //				// todo Auto-generated method stub
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
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        LC215KthLargestElement sol = new LC215KthLargestElement();
        System.out.println("ans(exp: 5) = " + sol.findKthLargest(nums, k));
    }
}
