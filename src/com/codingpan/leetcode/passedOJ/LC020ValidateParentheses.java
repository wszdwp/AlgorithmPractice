package com.codingpan.leetcode.passedOJ;

// [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
// determine if the input string is valid.

// The brackets must close in the correct order, 
// "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

// invalid cases 
// 1. start from )
// 2. ending with (
// 3. pop up to first ( is not matching )

// algm: 1: stack is empty
//				if is ) false
//				else push
//			 2: stack is not empty
//				if is ) : pop 
//							see if it is match
//				if is ( : peek 
//							if it is ) not match
//							else push


import java.util.Stack;

public class LC020ValidateParentheses {
	public static boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}

		Stack<Character> stk = new Stack<Character>();
		final char[] C1 = {'(', ')'};
		final char[] C2 = {'[', ']'};
		final char[] C3 = {'{', '}'};

		char[] cStr = s.toCharArray();

		for (int i = 0; i < cStr.length; i++) {
			char c = cStr[i];
			if (stk.isEmpty()) {
				if (c == C1[1] || c == C2[1] || c == C3[1]) {
					return false;
				} else {
					stk.push(c);
				}
			} else {
				if (c == C1[1] || c == C2[1] || c == C3[1]) {
					char cc = stk.pop();
					if ( (cc == C1[0] && c == C1[1])
							|| (cc == C2[0] && c == C2[1])	
							|| (cc == C3[0] && c == C3[1])
							)	continue;
					else {
						return false;
					}
				} else {
					stk.push(c);        			
				}
			}
		}

		return stk.isEmpty();
	}

	public static void main(String[] args) {
		String[] ss = {"()()", "()[]{}", "()"};
		String[] sss = {"([)]", "(]"};
		for (String s : ss) { 
			System.out.println(isValid(s));
		}
	}
}

