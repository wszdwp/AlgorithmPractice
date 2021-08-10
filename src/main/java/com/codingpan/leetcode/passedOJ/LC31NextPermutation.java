package com.codingpan.leetcode.passedOJ;

import com.codingpan.leetcode.util.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * [31. Next Permutation](https://leetcode.com/problems/next-permutation/description/) Implement
 * next permutation, which rearranges numbers into the lexicographically next greater permutation of
 * numbers. If such arrangement is not possible, it must rearrange it as the lowest possible order
 * (ie, sorted in ascending order). The replacement must be in-place, do not allocate extra memory.
 *
 * <p>Here are some examples. Inputs are in the left-hand column and its corresponding outputs are
 * in the right-hand column.
 *
 * <p>1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 *
 * <p>Solu: 1. find the 1st element which less than current max from right, say current max is max,
 * and it's index is maxIdx the 1st element is num[i] and it's index is i 2. find the 1st element
 * which greater than num[i] from right, say it's num[j] and it's index is j 3. swap num[i] and
 * num[j] 4. reverse the array from maxId to end of the array
 *
 * <p>Explanation: the i is one potential position to find greater permutation, which is the first
 * number which breaking a decending sequence from right to left is also next to the left of current
 * max
 *
 * <p>in all the numbers to the right of current max, we need to find the first number nums[j].
 * which is greater thant nums[i], swap nums[i] and nums[j] then reverse all the descending
 * sequences from current max to the right can get us the ascending sequence which is permutation we
 * need
 */
public class LC31NextPermutation {
  public void nextPermutation(int[] nums) {
    if (nums.length <= 1) return;
    int i = nums.length - 1;
    int maxIdx = i;
    int max = nums[i];
    while (i > 0) {
      i = i - 1;
      int n = nums[i];
      if (max <= n) {
        max = n;
        maxIdx = i;
      } else {
        break;
      }
    }
    if (i >= 0) {
      int j = nums.length - 1;
      while (nums[j] <= nums[i] && j > 0) j--;
      swap(nums, i, j);
    }
    reverse(nums, maxIdx, nums.length - 1);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  public static void main(String[] args) {
    LC31NextPermutation solu = new LC31NextPermutation();
    //        int[] nums = {1, 2, 3};   //132
    // int[] nums = {3, 2, 1};   //123
    // int[] nums = {1, 1, 5};   //151
    // int[] nums = {3, 2, 2};   //223
    // int[] nums = {1, 5, 2, 8, 4, 3};    //152843 -> 153248
    // int[] nums = {1, 3, 2};   // 132 -> 213
    // int[] nums = {1, 1};
    // int[] nums = {2, 3, 1};//312
    //        solu.nextPermutation(nums);
    //        for (int n : nums) {
    //            System.out.print(n + ",");
    //        }
    //        System.out.println();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(Utility.PATH + "LC31"));
      String line;
      int ans;
      while ((line = br.readLine()) != null) {
        String[] numStr = line.split(",");
        ans = Integer.parseInt(br.readLine());
        int[] nums = new int[numStr.length];
        for (int i = 0; i < numStr.length; i++) {
          nums[i] = Integer.parseInt(numStr[i].trim());
        }
        solu.nextPermutation(nums);
        Utility.printArray(nums);
        System.out.println(ans);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }
}
