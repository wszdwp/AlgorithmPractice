package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class LC046Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> perms = new ArrayList<List<Integer>>();
    //        // version 1
    //        permute(nums, 0, perms);
    //        // version 2
    backtracking(nums, new boolean[nums.length], new ArrayList<Integer>(), perms);
    return perms;

    // version 3
    //        return iterativePerm(nums);
  }

  // version 3

  private List<List<Integer>> iterativePerm(int[] nums) {
    List<List<Integer>> perms = new ArrayList<List<Integer>>();

    List<Integer> first = new ArrayList<>();
    first.add(nums[0]);
    perms.add(first);

    for (int i = 1; i < nums.length; i++) {
      List<List<Integer>> newPerms = new ArrayList<List<Integer>>();
      for (int j = 0; j < perms.size(); j++) {
        List<Integer> curr = perms.get(j);

        for (int k = 0; k <= curr.size(); k++) {
          List<Integer> perm = new ArrayList<>(curr);
          perm.add(k, nums[i]);
          newPerms.add(new ArrayList<Integer>(perm));
        }
      }
      perms = newPerms;
    }

    return perms;
  }

  // version 2
  private void backtracking(
      int[] nums, boolean[] used, List<Integer> perm, List<List<Integer>> perms) {
    if (perm.size() == nums.length) {
      perms.add(new ArrayList<Integer>(perm));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (!used[i]) {
          used[i] = true;
          perm.add(nums[i]);
          backtracking(nums, used, perm, perms);
          perm.remove(perm.size() - 1);
          used[i] = false;
        }
      }
    }
  }

  // version 1
  private void permute(int[] nums, int s, List<List<Integer>> perms) {
    if (s == nums.length) {
      perms.add(arrToList(nums));
    } else {
      for (int i = s; i < nums.length; i++) {
        exch(nums, i, s);
        permute(nums, s + 1, perms);
        exch(nums, i, s);
      }
    }
  }

  private void exch(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private List<Integer> arrToList(int[] nums) {
    List<Integer> perm = new ArrayList<>();
    for (int n : nums) perm.add(n);
    return perm;
  }

  /**
   * unit com.codingpan.test
   *
   * @param args
   */
  public static void main(String[] args) {
    LC046Permutations solu = new LC046Permutations();
    int[] nums = {1, 1, 3};
    List<List<Integer>> res = solu.permute(nums);
    for (List<Integer> aList : res) {
      Utility.printList(aList);
    }
  }
}
