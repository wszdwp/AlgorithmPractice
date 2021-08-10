package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC007ReverseInt {
  public int reverse(int x) {
    int i = x;
    int n = 0;
    while (i != 0) {
      int d = i % 10;
      if (Math.abs(n) > Integer.MAX_VALUE / 10) return 0;
      n = n * 10 + d;
      i = i / 10;
    }
    return n;
  }

  public static void main(String[] args) {
    LC007ReverseInt solu = new LC007ReverseInt();
    int[] nums = {
      0, 1, 123, 345, 333, -658, -6, Integer.MAX_VALUE, Integer.MIN_VALUE, 2147483647, 1534236469
    };
    for (int n : nums) {
      StdOut.print(solu.reverse(n) + ",");
    }
  }
}
