package com.codingpan.leetcode.todo;

import java.util.Stack;

public class LC739DailyTemperatures {
  //	Given a list of daily temperatures, produce a list that, for each day in the input,
  //	tells you how many days you would have to wait until a warmer temperature. If there is no
  // future day for which this
  //	is possible, put 0 instead.
  //
  //	For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should
  // be [1, 1, 4, 2, 1, 1, 0, 0].
  //
  //	Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an
  // integer in the range [30, 100].
  //
  //	Discuss

  public int[] dailyTemperatures(int[] temperatures) {
    // mono stack, elements from great to small
    // push when empty stack or top elem greater than the new one
    // pop until top elem greater than the new one or empty
    int[] ans = new int[temperatures.length];
    Stack<Integer> stk = new Stack<>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
        int j = stk.pop();
        ans[j] = i - j;
      }
      stk.push(i);
    }

    return ans;
  }
}
