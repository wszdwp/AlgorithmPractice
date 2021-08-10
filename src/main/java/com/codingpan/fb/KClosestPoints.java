package com.codingpan.fb;

import java.util.Arrays;

public class KClosestPoints {
  public int[][] kClosest(int[][] points, int K) {
    int lo = 0;
    int hi = points.length - 1;
    while (lo <= hi) {
      int m = partition(points, lo, hi);
      if (m == K) break;
      if (m < K) {
        lo = m + 1;
      } else {
        hi = m - 1;
      }
    }
    return Arrays.copyOfRange(points, 0, K);
  }

  private int partition(int[][] points, int lo, int hi) {
    if (lo >= hi) return lo;
    int i = lo;
    int j = hi + 1;
    int[] p1 = points[lo];
    while (true) {
      while (less(points[++i], p1)) {
        if (i == hi) break;
      }
      while (less(p1, points[--j])) {
        if (j == lo) break;
      }
      if (i >= j) break;
      exch(points, i, j);
    }
    exch(points, lo, j);
    return j;
  }

  private boolean less(int[] p1, int[] p2) {
    long dist1 = p1[0] * p1[0] + p1[1] * p1[1];
    long dist2 = p2[0] * p2[0] + p2[1] * p2[1];
    if (dist1 < dist2) return true;
    else return false;
  }

  private void exch(int[][] points, int i, int j) {
    int[] temp = points[i];
    points[i] = points[j];
    points[j] = temp;
  }
}
