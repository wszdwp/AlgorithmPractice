package com.codingpan.leetcode.TODO;

/**
 *	Given a list of non negative integers, 
 *	arrange them such that they form the largest number.
 *
 *	For example, given [3, 30, 34, 5, 9], 
 *	the largest formed number is 9534330.
 *	Note: The result may be very large, so you need to return a string instead of an integer.
 */

import java.util.*;

class MyComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		int returnedValue = 0;

		String combined1 = s1 + s2;
		String combined2 = s2 + s1;
		int i = 0, j = 0;
		for (; i < combined1.length() && j < combined2.length(); i++, j++) {
			String ss1 = combined1.substring(i, i+1);
			String ss2 = combined2.substring(i, i+1);

			int a1 = Integer.valueOf(ss1);
			int a2 = Integer.valueOf(ss2);

			if (a1 == a2) continue;
			if (a1 > a2) {
				returnedValue = -1;
				break;
			} else {
				returnedValue = 1;
				break;
			}

		}


		//reverse order
		return returnedValue; 
	}
}

public class LargestNumber {
	public static String largestNumber(int[] num) {

		StringBuilder sb = new StringBuilder();

		String[] arrStr = new String[num.length];

		for (int i = 0; i < num.length; i++) {
			arrStr[i] = String.valueOf(num[i]);
		}

		Arrays.sort(arrStr, new MyComparator());

		for (String s : arrStr) {
			sb.append(s);
		}

		return sb.toString();
	}



	public static void main(String[] args) {
		int[] num = {3, 30, 34, 5, 9};
		System.out.println("Expected(9534330) " + largestNumber(num));

	}
}
