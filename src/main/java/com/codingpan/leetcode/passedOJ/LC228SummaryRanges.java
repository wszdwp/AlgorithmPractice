package com.codingpan.leetcode.passedOJ;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * [228. Summary Ranges](https://leetcode.com/problems/summary-ranges/description/) Given a sorted
 * integer array without duplicates, return the summary of its ranges.
 *
 * <p>Example 1: Input: [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Example 2: Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 */
public class LC228SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> ranges = new ArrayList<String>();
    if (nums == null || nums.length == 0) return ranges;
    if (nums.length == 1) {
      ranges.add(nums[0] + "");
      return ranges;
    }
    int i = 1;
    int start = 0;
    while (i < nums.length) {
      if (nums[i] > nums[i - 1] + 1) {
        if (i > start + 1) {
          ranges.add(nums[start] + "->" + nums[i - 1]);
        } else {
          ranges.add(nums[start] + "");
        }
        start = i;
      }
      if (i == nums.length - 1) {
        if (i > start + 1) {
          ranges.add(nums[start] + "->" + nums[i]);
        } else {
          ranges.add(nums[start] + "");
        }
      }
      i++;
    }

    return ranges;
  }

  public static void main(String[] args) {
    LC228SummaryRanges solu = new LC228SummaryRanges();
    // int[] nums = {0, 1, 2, 4, 5, 7};
    // int[] nums = {0, 2, 3, 4, 6, 8, 9};
    // int[] nums = {0, 10, 20, 40, 41, 55, 100};
    int[] nums = {};
    System.out.println(solu.summaryRanges(nums));
  }

  public static class LC032LongestValidParentheses {
    //    public int longestValidParentheses(String s) {
    //        if (s == null || s.length() <= 1) return 0;
    //
    //        int left = 0, right = 0;
    //        int maxLen = 0;
    //        for (int i = 0; i < s.length(); i++) {
    //            char c = s.charAt(i);
    //            if (c == '(') {
    //                ++left;
    //            } else {
    //                ++right;
    //            }
    //            if (right <= left) {
    //                int currLen = Math.min(left, right) * 2;
    //                maxLen = Math.max(maxLen, currLen);
    //            }
    //            if (left >= right) {
    //                left = 1;
    //                right = 0;
    //            }
    //        }
    //        return maxLen;
    //    }

    public int longestValidParentheses(String s) {
      if (s == null || s.length() <= 1) return 0;

      Stack<Integer> stk = new Stack<>();
      int maxLen = 0;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
          stk.push(i);
        } else {
          if (!stk.isEmpty() && s.charAt(stk.peek()) == '(') {
            stk.pop();
            maxLen = Math.max(maxLen, i - (stk.isEmpty() ? -1 : stk.peek()));
          } else {
            stk.push(i);
          }
        }
      }
      return maxLen;
    }

    public static void main(String[] args) {
      LC032LongestValidParentheses solu = new LC032LongestValidParentheses();
      String s = "()(()"; // 2
      //        String s = "(()";
      //        String s = "()()()";
      //        String s = ")()()";

      StdOut.println("len = " + solu.longestValidParentheses(s));
    }
  }
}
