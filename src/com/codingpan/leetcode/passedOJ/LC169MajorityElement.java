package com.codingpan.leetcode.passedOJ;

// [169. Majority Element](https://leetcode.com/problems/majority-element/) 
// Given an array of size n, find the majority element. 
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.


import java.util.Arrays;

public class LC169MajorityElement {
	public static int majorityElement(int[] num) {
		Arrays.sort(num);

		int maxCount = 1;
		int n = num[0];
		for (int i = 1; i < num.length; i++) {
			if (n != num[i]) {
				if (maxCount > num.length/2) {
					break;
				} else {
					n = num[i];
					maxCount = 1;
				}
			} else {
				maxCount++;
			}
		}

		return n;
	}

	public static int compareVersion(String version1, String version2) {
		if (!version1.contains(".")) {
			version1 = new String(version1 + ".0");
		} 

		if (!version2.contains(".")) {
			version2 = new String(version2 + ".0");
		}


		String[] s1 = version1.split("[^0-9]");
		String[] s2 = version2.split("[^0-9]");

		int i = 0;
		for (; i < s1.length && i < s2.length; i++) {
			int d1 = Integer.valueOf(s1[i]);
			int d2 = Integer.valueOf(s2[i]);

			if (d1 > d2) {
				return 1;
			} else if (d1 < d2) {
				return -1;
			} else if (d1 == d2) {
				continue;
			}
		}

		if (i < s1.length) {
			if (Integer.valueOf(s1[i]) != 0) {
				return 1;
			}
		} 

		if (i < s2.length) {
			if (Integer.valueOf(s2[i]) != 0) {
				return -1;
			}
		}
		return 0;

	}

	public static void main(String[] args) {
//		int[] num = {-1, 1, 1, 1, 2, 1};
		String v1 = "1.8";
		String v2 = "1.5";
		String[] vv1 = v1.split("[^0-9]");
		String[] vv2 = v2.split("[^0-9]");
		System.out.println(compareVersion(v1, v2));
		// 	System.out.println(vv1[1]);
		// 	System.out.println(vv2[1]);
		// System.out.println(compareVersion(v1, v2));
		// int n = majorityElement(num);
		// System.out.println(n);
	}
}

