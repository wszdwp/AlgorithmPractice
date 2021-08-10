package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class LC824GoatLatin {
  public String toGoatLatin(String S) {
    if (S == null || S.trim().isEmpty()) return S;

    StringBuilder sb = new StringBuilder();
    Set<String> set = new HashSet<String>();
    final String VOWELS = "AEIOUaeiou";
    for (int i = 0; i < VOWELS.length(); i++) {
      set.add(VOWELS.substring(i, i + 1));
    }
    String[] sArr = S.trim().split(" ");
    for (int i = 0; i < sArr.length; i++) {
      String s = sArr[i];
      if (set.contains(s.substring(0, 1))) {
        s = s + "ma";
      } else {
        s = s.substring(1) + s.substring(0, 1) + "ma";
      }
      sb.append("a");
      sArr[i] = s + sb.toString();
    }

    sb = new StringBuilder();
    for (int i = 0; i < sArr.length; i++) {
      sb.append(sArr[i]);
      sb.append(" ");
    }
    return sb.toString().trim();
  }

  public static void main(String[] args) {
    String S = "I speak Goat Latin";
    LC824GoatLatin solu = new LC824GoatLatin();
    StdOut.println(solu.toGoatLatin(S));
  }
}
