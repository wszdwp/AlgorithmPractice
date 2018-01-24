package com.codingpan.leetcode.TODO;

import java.util.Stack;

public class LC394DecodeString {
	public static String decodeString(String s) {
		Stack<Character> stk = new Stack<Character>();
		Stack<Integer> numStk = new Stack<Integer>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ']') {
				stk.push(c);
			} else {
				while (!stk.isEmpty()) {
					if (stk.peek() == '[') {
						stk.pop();
					} else {
						sb.append(stk.pop());
					}
				}
			}
		}
		return s;
    }
	
	
	public static void main(String[] args) {
		String s1 = "3[a]2[bc]";
		String s2 = "3[a2[c]]";
		String s3 = "2[abc]3[cd]ef";
		
	}
}
