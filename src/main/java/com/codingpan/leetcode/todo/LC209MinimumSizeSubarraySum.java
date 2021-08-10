package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC209MinimumSizeSubarraySum {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums.length == 0) return 0;

    int minLen = Integer.MAX_VALUE;
    int l = 0;
    int r = 0;
    int sum = 0;
    while (r < nums.length) {
      sum += nums[r++];

      while (sum >= s) {
        minLen = Math.min(minLen, r - l);
        sum -= nums[l++];
      }
    }

    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }

  private int myVersion(int s, int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0] == s ? 1 : 0;

    int minLen = Integer.MAX_VALUE;
    int l = 0;
    int r = 1;
    int sum = nums[l] + nums[r];
    while (l < nums.length && r < nums.length) {
      if (sum == s) {
        minLen = (minLen < r - l + 1) ? minLen : r - l + 1;
        r++;
        if (r < nums.length) sum += nums[r];
      } else if (sum < s) {
        r++;
        if (r < nums.length) sum += nums[r];
      } else {
        sum -= nums[l];
        if (l == r) {
          l++;
          r += 2;
        } else {
          l++;
        }
      }
    }

    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }

  public static void main(String[] args) {
    LC209MinimumSizeSubarraySum solu = new LC209MinimumSizeSubarraySum();
    int s = 7;
    int[] nums = {2, 3, 1, 2, 4, 3}; // ans 2 {4, 3}
    //        int[] nums = {2,3, 8, 19, 21}; // ans 2 {4, 3}
    int ans = solu.minSubArrayLen(s, nums);
    StdOut.println(ans);
  }
}
