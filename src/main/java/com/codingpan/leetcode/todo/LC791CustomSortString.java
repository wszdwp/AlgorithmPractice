package com.codingpan.leetcode.todo;

import java.util.HashSet;
import java.util.Set;

public class LC791CustomSortString {
  /**
   * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
   *
   * <p>S was sorted in some custom order previously. We want to permute the characters of T so that
   * they match the order that S was sorted. More specifically, if x occurs before y in S, then x
   * should occur before y in the returned string. Return any permutation of T (as a string) that
   * satisfies this property.
   *
   * <p>Example: Input: S = "cba" T = "abcd" Output: "cbad" Explanation: "a", "b", "c" appear in S,
   * so the order of "a", "b", "c" should be "c", "b", and "a". Since "d" does not appear in S, it
   * can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs. Note: S has length
   * at most 26, and no character is repeated in S. T has length at most 200. S and T consist of
   * lowercase letters only.
   *
   * @param S string s
   * @param T string t
   * @return
   */
  public String customSortString(String S, String T) {
    Set charSet = new HashSet();
    for (char c : S.toCharArray()) {
      charSet.add(c);
    }
    int i = 0;
    int j = 0;
    StringBuilder sb = new StringBuilder();
    while (i < S.length() && i < T.length()) {
      char s = S.charAt(i);
      char t = T.charAt(i);
      if (s == t) {
        sb.insert(0, t);
      } else {
        if (charSet.contains(t)) {

        } else {

        }
      }
    }

    return sb.toString();
  }
}
