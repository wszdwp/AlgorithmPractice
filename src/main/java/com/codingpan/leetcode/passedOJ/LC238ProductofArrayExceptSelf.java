package com.codingpan.leetcode.passedOJ;

import com.codingpan.leetcode.util.Utility;

public class LC238ProductofArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    //        int[] products = new int[nums.length];
    //        int totalProduct = 1;
    //        for (int i = 0; i < products.length; i++) {
    //            products[i] = 1;
    //            totalProduct *= nums[i];
    //        }
    //        for (int i = 0; i < nums.length; i++) {
    //        }

    int n = nums.length;
    int[] res = new int[n];
    res[0] = 1;
    for (int i = 1; i < n; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }
    // Utility.printArray(res);

    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
      res[i] *= right;
      // StdOut.println(res[i]);
      right *= nums[i];
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    LC238ProductofArrayExceptSelf solu = new LC238ProductofArrayExceptSelf();
    int[] products = solu.productExceptSelf(nums);
    Utility.printArray(products);
  }
}
