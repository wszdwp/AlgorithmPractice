package com.codingpan.leetcode.todo;

import java.util.ArrayList;
import java.util.List;

public class LC784LetterCasePermutation {
  enum Case {
    UP,
    LO,
    NC;
  }

  public List<String> letterCasePermutation(String S) {
    List<String> perms = new ArrayList<>();
    helper(S.toCharArray(), 0, perms);
    return perms;
  }

  //    private void helper(char[] charArr, int start, List<String> perms) {
  //        perms.add(new String(charArr));
  //        for (int i = start; i < charArr.length; i++) {
  //            if (isChar(charArr[i]) == Case.LO) {
  //                charArr[i] = Character.toUpperCase(charArr[i]);
  //                helper(charArr, i+1, perms);
  //                charArr[i] = Character.toLowerCase(charArr[i]);
  //            }
  //            else if (isChar(charArr[i]) == Case.UP) {
  //                charArr[i] = Character.toLowerCase(charArr[i]);
  //                helper(charArr, i+1, perms);
  //                charArr[i] = Character.toUpperCase(charArr[i]);
  //            }
  //        }
  //    }

  private void helper(char[] charArr, int start, List<String> perms) {
    perms.add(new String(charArr));
    for (int i = start; i < charArr.length; i++) {
      char c = charArr[i];
      if (c >= 'a' && c <= 'z') {
        charArr[i] = Character.toUpperCase(charArr[i]);
        helper(charArr, i + 1, perms);
        charArr[i] = Character.toLowerCase(charArr[i]);
      } else if (c >= 'A' && c <= 'Z') {
        charArr[i] = Character.toLowerCase(charArr[i]);
        helper(charArr, i + 1, perms);
        charArr[i] = Character.toUpperCase(charArr[i]);
      }
    }
  }

  private Case isChar(char c) {
    if (c >= 'a' && c <= 'z') return Case.LO;
    if (c >= 'A' && c <= 'Z') return Case.UP;
    return Case.NC;
  }

  public static void main(String[] args) {
    LC784LetterCasePermutation solu = new LC784LetterCasePermutation();
    String[] tests = {"", "a1b2", "3z4", "12345", "C"};
    for (String s : tests) {
      List<String> perms = solu.letterCasePermutation(s);
      for (String perm : perms) {
        System.out.print(perm + ",");
      }
      System.out.println();
    }
  }
}
