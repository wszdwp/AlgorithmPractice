package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC680ValidPalindromeII {
  public boolean validPalindrome(String s) {
    if (s == null || s.length() <= 2) return true;

    int l = 0, r = s.length() - 1;
    boolean used = false;
    while (l < r) {
      char lc = s.charAt(l);
      char rc = s.charAt(r);
      StdOut.println(lc + ":" + rc);
      StdOut.println(l + ":" + r);

      if (lc != rc) {
        if (used) return false;

        if (s.charAt(l) == s.charAt(r - 1) && s.charAt(l + 1) == s.charAt(r)) {
          if (s.charAt(l + 1) == s.charAt(r - 2)) {
            l++;
          } else {
            r--;
          }
          used = true;
        } else if (s.charAt(l + 1) == s.charAt(r)) {
          l++;
          used = true;
        } else if (s.charAt(l) == s.charAt(r - 1)) {
          r--;
          used = true;
        } else {
          return false;
        }
      }
      l++;
      r--;
    }

    return true;
  }

  public static void main(String[] args) {
    // expected true
    String s =
        "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
    StdOut.println(s.length());
    LC680ValidPalindromeII solu = new LC680ValidPalindromeII();
    StdOut.println("ans " + solu.validPalindrome(s));
  }
}
