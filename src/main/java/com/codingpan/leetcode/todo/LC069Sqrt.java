package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC069Sqrt {
  public int mySqrt(int x) {
    if (x == 0 || x == 1) return x;
    int left = 0;
    int right = x;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      //            int mid = (right + left) / 2;
      StdOut.println("mid " + mid + "  " + (left + right) / 2);
      int sqrt = x / mid;
      StdOut.println("sqrt= " + sqrt + "  " + x / ((left + right) / 2));
      if (sqrt < mid) {
        right = mid - 1;
        StdOut.println("right = " + right);
      } else if (sqrt > mid) {
        left = mid + 1;
      } else {
        return sqrt;
      }
    }

    return right;
  }

  public static void main(String[] args) {
    LC069Sqrt solu = new LC069Sqrt();
    //        for (int i = 1; i < 999; i+=10) {
    //            StdOut.println(i + " sqrt is " + solu.mySqrt(i));
    //        }
    int i = 2147483647;
    i = Integer.MAX_VALUE;
    StdOut.println(i + " sqrt is " + solu.mySqrt(i));
  }
}
