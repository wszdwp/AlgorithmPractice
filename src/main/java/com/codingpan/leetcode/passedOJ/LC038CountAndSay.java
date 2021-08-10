package com.codingpan.leetcode.passedOJ;

import edu.princeton.cs.algs4.StdOut;

public class LC038CountAndSay {
  public String countAndSay(int n) {
    if (n < 1) return "";
    if (n == 1) return "1";
    String s = "1";
    int k = 1;
    while (k < n) {
      s = getCountSayString(s);
      k++;
    }
    return s;
  }

  private String getCountSayString(String s) {
    if (s.length() == 1) return "1" + s;
    StringBuilder sb = new StringBuilder();
    int count = 1;
    char c0 = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      char c1 = s.charAt(i);
      if (c1 == c0) {
        count++;
      } else {
        sb.append(count);
        sb.append(c0);
        count = 1;
        c0 = c1;
      }
      if (i == s.length() - 1) {
        sb.append(count);
        sb.append(c0);
      }
    }
    return new String(sb);
  }

  public static void main(String[] args) {
    LC038CountAndSay solu = new LC038CountAndSay();
    int n = 5;
    for (int i = 0; i <= n; i++) {
      StdOut.println(solu.countAndSay(i));
    }
  }
}
