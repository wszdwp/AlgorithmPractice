package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC249GroupShiftedString {
  /**
   * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc"
   * -> "bcd". We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".
   *
   * <p>Given a list of strings which contains only lowercase alphabets, group all strings that
   * belong to the same shifting sequence, return:
   *
   * <p>Input : str[] = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"}; Output : { {a
   * x}, {acd dfg wyz yab mop}, {bdfh moqs} } All shifted strings are grouped together.
   */
  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> res = new ArrayList<>();

    Map<String, List<String>> groupMap = new HashMap<>();
    for (String s : strings) {
      String dKey = getDistanceKey(s);
      if (groupMap.containsKey(dKey)) {
        groupMap.get(dKey).add(s);
      } else {
        List<String> group = new ArrayList<>();
        group.add(s);
        groupMap.put(dKey, group);
      }
    }

    for (Map.Entry<String, List<String>> entry : groupMap.entrySet()) {
      res.add(entry.getValue());
    }

    return res;
  }

  private String getDistanceKey(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length() - 1; i++) {
      int d = (s.charAt(i + 1) - s.charAt(i)) % 26;
      if (d < 0) d += 26;
      StdOut.println("string " + s + " d = " + d);
      sb.append(d);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    LC249GroupShiftedString solu = new LC249GroupShiftedString();
    String[] strings = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};
    List<List<String>> res = solu.groupStrings(strings);
    for (List<String> one : res) {
      Utility.printList(one);
    }
  }
}
