package com.codingpan.leetcode.todo;


import java.util.TreeSet;

/**
 * [220. Contains Duplicate III](https://leetcode.com/problems/contains-duplicate-iii/description/)
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 */
public class LC220ContainsDuplicateIII {
    // Failed at com.codingpan.test case 4
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer max = treeSet.floor(nums[i] + t);
            Integer min = treeSet.ceiling(nums[i] - t);
            if (max != null && max >= nums[i])  return true;
            if (min != null && min <= nums[i])  return true;
            treeSet.add(nums[i]);
            if (i >= k) treeSet.remove(nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        LC220ContainsDuplicateIII solu = new LC220ContainsDuplicateIII();
        //false
        // int[] nums = {-1, 2147483647};
        // int k = 1;
        // int t = 2147483647;

        //true
        // int[] nums = {-1, -1};
        // int k = 1;
        // int t = 0;

        //false
        // int[] nums = {2147483647, -2147483647};
        // int k = 1;
        // int t = 2147483647;


        //4 true
        int[] nums = {-2147483648,-2147483647};
        int k = 3;
        int t = 3;

//        int[] nums = {-1, -1};
//        int k = 1;
//        int t = -1;
        System.out.println(solu.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
