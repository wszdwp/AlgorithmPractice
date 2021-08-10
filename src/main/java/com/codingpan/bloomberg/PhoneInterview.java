package com.codingpan.bloomberg;

import edu.princeton.cs.algs4.StdOut;

public class PhoneInterview {
  /**
   * Recursive way of double for-loop
   *
   * @param m
   * @param n
   */
  public void recursiveDoubleForLoop(int m, int n) {
    doubleForHelper(0, 0, m, n);
  }

  private void doubleForHelper(int i, int j, int iLen, int jLen) {
    if (j == jLen && i < iLen) {
      StdOut.println();
      doubleForHelper(i + 1, 0, iLen, jLen);
    } else if (i == iLen) {
      return;
    } else {
      System.out.print(j + ",");
      doubleForHelper(i, j + 1, iLen, jLen);
    }
  }

  public static void main(String[] args) {
    PhoneInterview phoneInterview = new PhoneInterview();
    int m = 3;
    int n = 5;
    phoneInterview.recursiveDoubleForLoop(m, n);
  }
}
