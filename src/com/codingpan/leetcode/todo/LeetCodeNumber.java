package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.ListNode;

public class LeetCodeNumber {
	// Base 7
//	Given an integer, return its base 7 string representation.
//
//			Example 1:
//			Input: 100
//			Output: "202"
//			Example 2:
//			Input: -7
//			Output: "-10"
//			Note: The input will be in range of [-1e7, 1e7].
	
    public String convertToBase7(int num) {
        return Integer.toString(num);
    }
    
//    Reverse bits of a given 32 bits unsigned integer.
//
//    For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
//
//    Follow up:
//    If this function is called many times, how would you optimize it?
//
//    Related problem: Reverse Integer
//
//    Credits:
//    Special thanks to @ts for adding this problem and creating all test cases.
    
    public int reverseBits(int n) {
//    	return Integer.reverse(n);
    	n = (n & 0x55555555) << 1 | (n >>> 1) & 0x55555555;
    	n = (n & 0x33333333) << 2 | (n >>> 2) & 0x33333333;
    	n = (n & 0x0f0f0f0f) << 4 | (n >>> 4) & 0x0f0f0f0f;
    	n = (n << 24) | ((n & 0xff00) << 8) |
    			((n >>> 8) & 0xff00) | (n >>> 24);
    	
    	return n;
    }

    public ListNode sumTwoLists(ListNode head1, ListNode head2) {
    	ListNode head = new ListNode(0);
    	return head.next;
	}


    public static void main(String[] args) {
    	LeetCodeNumber test = new LeetCodeNumber(); 
    	int n = 43261596;
    	System.out.println(Integer.toBinaryString(n) + " reverse: " + test.reverseBits(n));
    }

}
