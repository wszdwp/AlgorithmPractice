package com.codingpan.leetcode.passedOJ;

import java.util.HashSet;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

//Write an algorithm to determine if a number is "happy".
//
//A happy number is a number defined by the following process: 
// Starting with any positive integer, replace the number 
// by the sum of the squares of its digits, and repeat the process 
// until the number equals 1 (where it will stay), 
// or it loops endlessly in a cycle which does not include 1. 
// Those numbers for which this process ends in 1 are happy numbers.
//
//Example: 19 is a happy number
//
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//Credits:
//Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.

public class HappyNumber {
	
	public static boolean isHappy(int n) {
        if (n == 0)	return false;
        HashSet<Integer> hSet = new HashSet<Integer>();
        return helper(n, hSet);
        
    }
	
	private static boolean helper(int n, HashSet<Integer> hSet) {
		int tempRes = 0;
        while (n > 0) {
        	int d = n % 10;
        	n = n / 10;
        	tempRes += d * d;
        }
        if (tempRes == 1)	return true;
        if (hSet.contains(tempRes)) {
    		return false;
    	} else {
        	hSet.add(tempRes);
    	}
        
        return helper(tempRes, hSet);
	}
	
	public static void main(String[] args) {
		int n = 19;
		int n2 = 2;
		System.out.println("19(true): " + isHappy(n));
		System.out.println("2(false): " + isHappy(n2));

	}
}
 