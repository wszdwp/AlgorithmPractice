package com.codingpan.leetcode.TODO;


// [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

public class LC125Palindrome {
	//Recursion
	public static boolean isPalindrome(String s) {
		if (s.length() <= 1)	return true;
		return s.charAt(0) == s.charAt(s.length() - 1) &&
				isPalindrome(s.substring(1, s.length()-1));
	}
	
	//Iteration
	public static boolean isPalindrome2(String s) {
		if (s.length() <= 1)	return true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;	
	}
	
	public static void main(String[] args) {
		String s1 = "was it a car or a cat i saw";
		String s2 = "abba";
		String s3 = "was it a car or a car i saw";
		String s4 = "aba";
		String s5 = "aa";
		String s6 = "a";
		String s7 = "";
		
		System.out.println("expected(true) " + isPalindrome(s1.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome(s2.replaceAll(" ", "")));
		System.out.println("expected(false) " + isPalindrome(s3.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome(s4.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome(s5.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome(s6.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome(s7.replaceAll(" ", "")));

		System.out.println();
		
		System.out.println("expected(true) " + isPalindrome2(s1.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome2(s2.replaceAll(" ", "")));
		System.out.println("expected(false) " + isPalindrome2(s3.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome2(s4.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome2(s5.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome2(s6.replaceAll(" ", "")));
		System.out.println("expected(true) " + isPalindrome2(s7.replaceAll(" ", "")));
	}
}
