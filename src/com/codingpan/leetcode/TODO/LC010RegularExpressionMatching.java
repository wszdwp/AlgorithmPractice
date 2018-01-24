package com.codingpan.leetcode.TODO;


/**
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 * @author pan
 *
 */
public class LC010RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null)	return false;
		
		if (s.isEmpty() && p.isEmpty())	return true;
		if (s.isEmpty() || p.isEmpty()) {
			return false;
		}
		
		if (s.length() == 1){
			
		}
		
		int i = 0;
		int j = 0;
		char pre1 = s.charAt(i);
		char pre2 = p.charAt(j);
		while (i < s.length() && j < p.length()) {
			char c1 = s.charAt(i);
			char c2 = p.charAt(j);
			
			if (c1 != '*' && c1 != '.' && c2 != '*' && c2 != '.') {
				if (c1 != c2) {
					return false;
				}
				pre1 = c1;
				pre2 = c2;
				i++;
				j++;
			} else {
				if (c1 == '.') {
					if (c2 == '*') {
						
					}
				} else if (c1 == '*') {
					
				} else {
 
				}
			}
		}
        return true;
    }
	
}
