package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC134GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int remain = 0;
    int len = gas.length;
    for (int i = 0; i < len; i++) {
      remain = 0;
      if (gas[i] >= cost[i]) {
        remain = gas[i] - cost[i];
        int start = i;
        int j = i + 1;
        while (j % len != start) {
          int idx = j % len;
          if (remain < 0 || remain + gas[idx] < cost[idx]) {
            break;
          }
          remain += gas[idx] - cost[idx];
          j++;
        }
        if (remain >= 0 && j % len == start) return start;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    LC134GasStation solu = new LC134GasStation();
    int[] gas = {2, 3, 4};
    int[] cost = {3, 4, 3};
    StdOut.println(solu.canCompleteCircuit(gas, cost));
  }
}
