package com.codingpan.leetcode.todo;

public class LC350IntersectionOfTwoArraysII {
//  Given two arrays, write a function to compute their intersection.
//
//          Example:
//  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2],
//  return [2, 2].
//
//  Note:
//  Each element in the result should appear as many times as it shows in both arrays.
//  The result can be in any order.
//  Follow up:
//  What if the given array is already sorted? How would you optimize your algorithm?
//  What if nums1's size is small compared to nums2's size? Which algorithm is better?
//  What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements
//  into the memory at once?
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int minLen = len1 < len2 ? len1 : len2;
        int[] ans = new int[minLen];

        return ans;
    }

    public static void main(String[] args) {
        LC350IntersectionOfTwoArraysII test = new LC350IntersectionOfTwoArraysII();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] ans = test.intersect(nums1, nums2);
        System.out.println(ans.toString());
    }

}
