package com.codingpan.leetcode.todo;

import java.util.ArrayList;

public class LC045JumpGame2 {
  //    Given an array of non-negative integers, you are initially positioned at the first index of
  // the array.
  //
  //    Each element in the array represents your maximum jump length at that position.
  //
  //    Your goal is to reach the last index in the minimum number of jumps.
  //
  //    For example:
  //    Given array A = [2,3,1,1,4]
  //
  //    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1,
  // then 3 steps to the last index.)
  //
  //    Note:
  //    You can assume that you can always reach the last index.

  public int jump(int[] nums) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    jumpHelper(nums, 0, new ArrayList<Integer>(), ans);
    System.out.println("ans " + ans);
    int minJump = Integer.MAX_VALUE;
    for (ArrayList<Integer> steps : ans) {
      if (steps.size() < minJump) {
        minJump = steps.size();
      }
    }
    return minJump;
  }

  private void jumpHelper(
      int[] nums, int start, ArrayList<Integer> steps, ArrayList<ArrayList<Integer>> ans) {
    if (start >= nums.length - 1) {
      ans.add(new ArrayList<Integer>(steps));
      return;
    } else {
      for (int step = 1; step <= nums[start]; step++) {
        steps.add(step);
        jumpHelper(nums, start + step, steps, ans);
        steps.remove(new Integer((step)));
      }
    }
  }

  public static void main(String[] args) {
    LC045JumpGame2 test = new LC045JumpGame2();
    // int[] nums = {2, 3, 1, 1, 4};
    // int[] nums = {2, 1, 0, 1, 4};
    // int[] nums = {2, 1};    // out of boundary
    int[] nums = {
      6, 2, 6, 1, 7, 9, 3, 5, 3, 7, 2, 8, 9, 4, 7, 7, 2, 2, 8, 4, 6, 6, 1, 3
    }; // time limit
    int minJump = test.jump(nums);
    System.out.println("min jump " + minJump);
  }
}
