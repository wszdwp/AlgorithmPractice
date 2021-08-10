package com.codingpan.leetcode.passedOJ;

import edu.princeton.cs.algs4.StdOut;

public class LC152MaxProductSubArray {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int maxP = nums[0];
    int maxPSoFar = nums[0];
    int minPSoFar = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int maxProduct = Math.max(nums[i], Math.max(nums[i] * maxPSoFar, nums[i] * minPSoFar));
      int minProduct = Math.min(nums[i], Math.min(nums[i] * maxPSoFar, nums[i] * minPSoFar));
      maxPSoFar = maxProduct;
      minPSoFar = minProduct;
      maxP = Math.max(maxP, maxPSoFar);
    }

    return maxP;
  }

  public static void main(String[] args) {
    LC152MaxProductSubArray solu = new LC152MaxProductSubArray();
    int[] arr = {-2, 3, -4};
    // {-1,-2,-9,-6};
    // {-4, -3, -2};
    // {-2, 3, 4};
    StdOut.println(solu.maxProduct(arr));
  }
}
