package com.codingpan.algorithmprototypes;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class SearchProblemPrototypes {

  /**
   * Combination Time complexity: O(2^n) Space complexity: O(n)
   *
   * @param n
   * @param s
   * @param cur
   * @param ans
   */
  public void combination(int[] nums, int n, int s, List<Integer> cur, List<List<Integer>> ans) {
    if (cur.size() == n) {
      ans.add(new ArrayList<Integer>(cur));
      return;
    }

    for (int i = s; i < nums.length; i++) {
      cur.add(nums[i]);
      combination(nums, n, i + 1, cur, ans);
      cur.remove(cur.size() - 1);
    }
  }

  /**
   * Subset
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> subSet(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<Integer>();
    for (int i = 0; i <= nums.length; i++) {
      combination(nums, i, 0, cur, ans);
    }
    return ans;
  }

  /**
   * Permutation Time complexity: O(n!) Space complexity: O(n)
   *
   * @param nums
   * @param n
   * @param used
   * @param cur
   * @param ans
   */
  public void permutation(
      int[] nums, int n, boolean[] used, List<Integer> cur, List<List<Integer>> ans) {
    if (cur.size() == n) {
      ans.add(new ArrayList<Integer>(cur));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      used[i] = true;
      cur.add(nums[i]);
      permutation(nums, n, used, cur, ans);
      cur.remove(cur.size() - 1);
      used[i] = false;
    }
  }

  /**
   * Generate permutations
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> generatePerm(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<Integer>();
    boolean[] used = new boolean[nums.length];

    for (int i = 0; i < nums.length; i++) {
      permutation(nums, nums.length, used, cur, ans);
    }
    return ans;
  }

  /**
   * Unit com.codingpan.test
   *
   * @param args
   */
  public static void main(String[] args) {
    SearchProblemPrototypes solu = new SearchProblemPrototypes();

    // com.codingpan.test subset and combination
    int n = 4;
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) nums[i] = i + 1;
    List<List<Integer>> subsets = solu.subSet(nums);
    for (List<Integer> one : subsets) {
      // Utility.printList(one);
    }

    List<List<Integer>> permutations = solu.generatePerm(nums);
    for (List<Integer> one : permutations) {
      Utility.printList(one);
    }
  }
}
