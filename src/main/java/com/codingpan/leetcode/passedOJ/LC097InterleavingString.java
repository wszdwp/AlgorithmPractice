package com.codingpan.leetcode.passedOJ;

/**
 * [97. Interleaving String](https://leetcode.com/problems/interleaving-string/)
 *
 * @author pan
 *     <p>Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *     <p>For example, Given: s1 = "aabcc", s2 = "dbbca",
 *     <p>When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 *     <p>Subscribe to see which companies asked this question
 */
public class LC097InterleavingString {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1 == null || s2 == null || s3 == null) return false;
    int len1 = s1.length();
    int len2 = s2.length();
    int len3 = s3.length();
    if (len1 + len2 != len3) return false;

    int idx1 = 0;
    int idx2 = 0;
    boolean matched = false;
    for (int i = 0; i < len3; i++) {
      char c = s3.charAt(i);
      if (idx1 < len1) {
        char c1 = s1.charAt(idx1);
        if (c1 == c) {
          idx1++;
          matched = true;
        } else {
          matched = false;
        }
      }
      if (idx2 < len2 && !matched) {
        char c2 = s2.charAt(idx2);
        if (c2 == c) {
          idx2++;
          matched = true;
        } else {
          matched = false;
        }
      }
      if (!matched) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    LC097InterleavingString test = new LC097InterleavingString();
    String s1 = "aa";
    String s2 = "ab";
    String s3 = "abaa";
    System.out.println("expected(true) " + test.isInterleave(s1, s2, s3));
  }
}
