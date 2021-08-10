package com.codingpan.leetcode.todo;

import java.util.ArrayList;

public class LeetCodeStack {
  public int longestValidParentheses(String s) {
    int maxLen = 0;
    ArrayList<Character> stk = new ArrayList<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (stk.isEmpty()) {
        if (c == '(') {
          stk.add(c);
        }
      } else {
        if (c == '(') {

        } else if (c == ')') {

        }
      }
    }

    return maxLen;
  }

  public static void main(String[] args) {
    String s1 = ")()())";
    String s2 = "(()";
  }
}
