package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC560SubarraySumK {
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    int l = 0, r = 0, sum = 0;
    while (l < r && r < nums.length) {
      sum += nums[r];
      if (sum == k) {
        count++;
        r++;
      } else if (sum < k) {
        r++;
      } else {
        while (l < r && sum > k) {
          l++;
          sum -= nums[l];
        }
        if (sum == k) {
          count++;
        }
        r++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    LC560SubarraySumK solu = new LC560SubarraySumK();
    int[] nums = {1, 1, 1};
    int k = 2;
    int res = solu.subarraySum(nums, k);
    StdOut.println(res);
  }
}
