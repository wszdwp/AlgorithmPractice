package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class LeetCodeArray {
  // 219. Contains Duplicate II
  /**
   * Given an array of integers and an integer k, find out whether there are two distinct indices i
   * and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is
   * at most k.
   */
  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (hMap.containsKey(nums[i])
          && Math.abs(hMap.get(nums[i]) - i) <= k
          && hMap.get(nums[i]) != i) {
        return true;
      }
      hMap.put(nums[i], i);
    }

    return false;
  }

  // 220. Contains Duplicate III
  /**
   * Given an array of integers, find out whether there are two distinct indices i and j in the
   * array such that the absolute difference between nums[i] and nums[j] is at most t and the
   * absolute difference between i and j is at most k.
   */
  public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j <= t; j++) {
        int myKey = 0;
        if (nums[i] < 0) {
          myKey = nums[i] - j;
        } else {
          myKey = nums[i] + j;
        }
        if (hMap.containsKey(myKey) && Math.abs(hMap.get(myKey) - i) <= k && hMap.get(myKey) != i) {
          return true;
        }
      }

      hMap.put(nums[i], i);
    }
    return false;
  }

  private static boolean helper(int n1, int n2, int gap) {
    return (Math.abs(n1 - n2) <= gap) && (n1 != n2);
  }

  // 167 two sum from sorted array
  public static int[] twoSumFromSorted(int[] numbers, int target) {
    int[] res = {0, 0};
    int l = 0;
    int r = numbers.length - 1;
    while (l < r) {
      if (numbers[l] + numbers[r] == target) {
        res[0] = l + 1;
        res[1] = r + 1;
        return res;
      } else if (numbers[l] + numbers[r] < target) {
        l++;
      } else {
        r--;
      }
    }

    return res;
  }

  // 001 two sum
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      hMap.put(target - nums[i], i);
    }
    int[] ans = new int[2];
    for (int i = 0; i < nums.length; i++) {
      if (hMap.containsKey(nums[i])) {
        ans[0] = i;
        ans[1] = hMap.get(nums[i]);
        return ans;
      }
    }
    return ans;
  }

  // 242 valia anagram
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] letters = new int[65536];
    for (Character c : s.toCharArray()) {
      letters[c] = letters[c] + 1;
    }
    for (Character c : t.toCharArray()) {
      letters[c] = letters[c] - 1;
    }
    for (int i = 0; i < 65536; i++) {
      if (letters[i] != 0) {
        return false;
      }
    }

    return true;
  }

  // 169 Majority Element
  public static int majorityElement(int[] num) {
    int count = 0;
    int curr = num[0];
    for (int i = 1; i < num.length; i++) {
      if (curr != num[i]) {
        if (count == 0) {
          curr = num[i];
        } else {
          count--;
        }
      } else {
        count++;
      }
    }

    return curr;
  }

  private static int majorityElement2(int[] nums) {
    HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
    for (Integer n : nums) {
      if (hMap.containsKey(n)) {
        hMap.put(n, hMap.get(n) + 1);
        if (hMap.get(n) > nums.length / 2) {
          return n;
        }
      } else {
        hMap.put(n, 1);
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    // 001
    //        int[] nums = {2, 11, 7, 15};
    //        int target = 9;
    int[] nums = {3, 2, 4};
    int target = 6;
    int[] ans = twoSum(nums, target);
    for (int a : ans) {
      StdOut.println(ans[0] + ", " + ans[1]);
    }

    // 219 com.codingpan.test
    // int[] nums = {1, 2, 3, 4, 5, 6, 3, 7, 34, 75, 86, 44, 3};
    // int k = 4;
    // System.out.println("true: " + containsNearbyDuplicate(nums, k));

    // 220 com.codingpan.test
    // int[] nums = {-1, -1};   //true
    // int k = 1;
    // int t = 0;
    // int[] nums = {7, 1, 3}; //true
    // int k = 2;
    // int t = 3;
    // System.out.println("true: " + containsNearbyAlmostDuplicate(nums, k, t));

    // 167 com.codingpan.test
    // int[] numbers={2, 7, 11, 15};
    // int target=9;
    // System.out.println("[0, 1]: " + Arrays.toString(twoSumFromSorted(numbers, target)));

    // 242 com.codingpan.test
    // String s = "abbacde";
    // String t = "cabeabd";
    // System.out.println("(true) " + isAnagram(s, t));
    // String s = "abbacde";
    // String t = "cabeabd";
    // System.out.println("(true) " + isAnagram(s, t));

    // 169 com.codingpan.test
    // int[] nums = {3, 3, 3, 4, 4, 4, 5};
    //        int[] nums = {1, 1, 1, 3, 3, 2, 3, 3, 3, 2, 3, 3};
    //        System.out.println("(3) " + majorityElement(nums));
    //        System.out.println("(3) " + majorityElement2(nums));

  }
}
