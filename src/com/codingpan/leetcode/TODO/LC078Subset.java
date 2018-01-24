package com.codingpan.leetcode.TODO;


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


public class LC078Subset {

	// Ways of picking k from n, k <= n
	public static int subset1(int k, int n) {
		if (k == 0 || k == n)	
			return 1;
		else 
			return subset1(k-1, n-1) + subset1(k, n-1);
	}
	
	public static void permutation(String soFar, String rest) {
		if (rest.isEmpty())	{
//			System.out.println(soFar);
		} else {
			for (int i = 0; i < rest.length(); i++) {
				String next = soFar + rest.charAt(i);
				String remain = rest.substring(0, i) + rest.substring(i+1);
				System.out.println(i + " '" + next + "':'" + remain + "'");
				permutation(next, remain);
			}
		}
	}
	
	public static void main(String[] args) {
		int k = 2;
		int n = 6;
		System.out.println("exp(15) " + subset1(k, n));

		permutation("", "ab");
	}
}
