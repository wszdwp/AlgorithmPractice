package com.codingpan.leetcode;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    for (int n = 0; n <= nums.length; n++) {
      dfs(nums, 0, n, new ArrayList<>(), ans);
    }
    return ans;
  }

  private static void dfs(int[] nums, int d, int n, List<Integer> cur, List<List<Integer>> ans) {
    if (cur.size() == n) {
      ans.add(new ArrayList<Integer>(cur));
      return;
    }
    for (int i = d; i < nums.length; i++) {
      cur.add(nums[i]);
      dfs(nums, i + 1, n, cur, ans);
      cur.remove(cur.size() - 1);
    }
  }

  //    public static List<List<Integer>> permutations(int[] nums) {
  //
  //    }

  private void permutate(
      int[] nums, int d, int n, boolean[] used, List<Integer> cur, List<List<Integer>> ans) {}

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> ans = subsets(nums);
    Utility.printList(ans);
  }
}
