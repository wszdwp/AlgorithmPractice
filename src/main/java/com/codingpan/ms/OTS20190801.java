package com.codingpan.ms;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class OTS20190801 {
  /** 给一个string，“aAbeedxXb”，只有a-z, A-Z. 找到一个字母的大小写同时出现在string里。 比如这里是A, E, X。 然后X > E > A。 */
  public char findTargetChar(String s) {
    boolean[] upper = new boolean[26];
    boolean[] lower = new boolean[26];
    for (char c : s.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        lower[c - 'a'] = true;
      } else if (c >= 'A' && c <= 'Z') {
        upper[c - 'A'] = true;
      } else {
        continue;
      }
    }
    char ans = 0;
    for (int i = 25; i >= 0; i--) {
      if (upper[i] && lower[i]) {
        ans = (char) (i + 'A');
        break;
      }
    }
    return ans;
  }

  public int solution(int[] A) {
    // write your code in Java SE 8
    int min = 1000001, max = -1000001;
    Set<Integer> seen = new HashSet<>();
    for (int a : A) {
      min = Math.min(min, a);
      max = Math.max(max, a);
      seen.add(a);
    }
    boolean found = false;
    int ans = 0;
    for (int i = min; i <= max; i++) {
      if (!seen.contains(i)) {
        ans = i <= 0 ? 1 : i;
        found = true;
        break;
      }
    }
    return found ? ans : max + 1;
  }

  /**
   * 给定一个string，只有小写字母和问号组成，例如"ab?dc?j"， 要求把所有问号替换成小写字母，而且这个替换后的字母不能与相邻的两个字母相同。
   * 例如"a?b"可以替换成"acb"或"azb"但不能是"aab"或者"abb"
   *
   * @param s
   * @return String
   */
  public String reformString(String s) {
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '?') {
        if (i == 0) {
          if (i + 1 < arr.length) {
            arr[i] = getCandidateChar(' ', arr[i + 1]);
          } else {
            arr[i] = getCandidateChar(' ', ' ');
          }
        } else if (i == arr.length - 1) {
          if (i - 1 >= 0) {
            arr[i] = getCandidateChar(' ', arr[i - 1]);
          } else {
            arr[i] = getCandidateChar(' ', ' ');
          }
        } else {
          arr[i] = getCandidateChar(arr[i - 1], arr[i + 1]);
        }
      }
    }
    return new String(arr);
  }

  private char getCandidateChar(char a, char b) {
    char candidate = ' ';
    for (char c = 'a'; c <= 'z'; c++) {
      if (c != a && c != b) {
        candidate = c;
        break;
      }
    }
    return candidate;
  }

  public String longestSubstringWithOut3RepeatedChars(String s) {
    String ans = "";
    int start = 0;
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        ++count;
      } else {
        count = 1;
      }
      if (count >= 3) {
        if (ans.length() <= i - start) {
          ans = s.substring(start, i);
        }
        start = i - 1;
      } else {
        if (ans.length() <= i - start + 1) {
          ans = s.substring(start, i + 1);
        }
      }
      // StdOut.println("i = " + i + " start = " + start + " end = " + i + " ans = " + ans);
    }
    return ans;
  }

  public String removeTripleChars(String s) {
    if (s.length() <= 1) return s;
    StringBuilder sb = new StringBuilder();
    int count = 1;
    sb.append(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        ++count;
      } else {
        while (count >= 3) {
          sb.deleteCharAt(sb.length() - 1);
          count--;
        }
        count = 1;
      }
      sb.append(s.charAt(i));
    }
    while (count >= 3) {
      sb.deleteCharAt(sb.length() - 1);
      count--;
    }

    return sb.toString();
  }

  public String removeOneToLexicographicallySmallestString(String s) {
    if (s.length() <= 1) return "";
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        while (i < arr.length - 1) {
          arr[i] = arr[i + 1];
          i++;
        }
        break;
      }
    }
    return new String(arr, 0, arr.length - 1);
  }

  //    public String longestSubStringWithNo3RepeatChars(String s) {
  //        int start = 0, end = 1;
  //        while (end < s.length()) {
  //
  //        }
  //    }

  public static void main(String[] args) {
    OTS20190801 solu = new OTS20190801();

    //        String s = "aabBcDEe";  // ans: E      // "aAbeedxXb" ans: X
    //        char ans = solu.findTargetChar(s);
    //        StdOut.println("ans " + ans);

    //        String s = "?a?";
    //        String ans = solu.reformString(s);
    //        StdOut.println("ans " + ans);

    //        String[] ss = {"", "aaabceddd", "aabbbbcedddd", "aaacccbbb", "aa", "aaa",
    // "aaaaabbbbbbbb"};
    ////        String[] tt = {"", "aabcedd", "bbcedd", "ccbb", "aa", "aa", "aabb"};
    //        String[] tt = {"", "aabcedd", "aabbcedd", "aaccbb", "aa", "aa", "aabb"};
    //        for (int i = 0; i < ss.length; i++) {
    //            String s = ss[i];
    //            String t = tt[i];
    ////            String ans = solu.longestSubstringWithOut3RepeatedChars(s);
    //            String ans = solu.removeTripleChars(s);
    //            StdOut.println("ans " + (t.equalsIgnoreCase(ans) ? " pass " : " fail ") + ans);
    //        }

    //        String[] ss = {"abcde", "abcda", "dba", "gffa"};
    //        String[] tt = {"abcd", "abca", "ba", "ffa"};
    //        for (int i = 0; i < ss.length; i++) {
    //            String s = ss[i];
    //            String t = tt[i];
    //            String ans = solu.removeOneToLexicographicallySmallestString(s);
    //            StdOut.println("ans " + (t.equalsIgnoreCase(ans) ? " pass " : " fail ") + ans);
    //        }

    //        int[] A = {-1, -3};
    String s = "rd?e?wg??";
    String ans = solu.reformString(s);
    StdOut.println("ans " + ans);
  }
}
