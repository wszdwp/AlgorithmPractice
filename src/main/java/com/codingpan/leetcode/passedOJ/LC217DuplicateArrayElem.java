package com.codingpan.leetcode.passedOJ;

import java.util.BitSet;

/**
 * [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) Given an array of
 * integers, find if the array contains any duplicates. Your function should return true if any
 * value appears at least twice in the array, and it should return false if every element is
 * distinct.
 *
 * <p>Subscribe to see which companies asked this question
 */
public class LC217DuplicateArrayElem {

    public static boolean containsDuplicate(int[] nums) {
        boolean isDuplicate = false;
        int len = nums.length;

        if (len < 2) {
            return false;
        }

        BitSet myBitSet = new BitSet();
        for (int i = 0; i < len; i++) {
            if (nums[i] == Integer.MIN_VALUE) continue;
            if (nums[i] < 0) continue;
            int bIndex = nums[i];
            if (myBitSet.get(bIndex)) {
                isDuplicate = true;
                return isDuplicate;
            } else {
                myBitSet.set(bIndex);
            }
        }
        myBitSet.clear();
        for (int i = 0; i < len; i++) {
            if (nums[i] == Integer.MIN_VALUE) continue;
            if (nums[i] > 0) continue;
            int bIndex = -nums[i];
            if (myBitSet.get(bIndex)) {
                isDuplicate = true;
                return isDuplicate;
            } else {
                myBitSet.set(bIndex);
            }
        }

        return isDuplicate;
    }

    public static boolean containsDuplicate2(int[] nums) {
        boolean isDuplicate = false;
        int len = nums.length;

        if (len < 2) {
            return false;
        }

        BitSet myPosBitSet = new BitSet();
        BitSet myNegBitSet = new BitSet();
        for (int i = 0; i < len; i++) {
            if (nums[i] == Integer.MIN_VALUE) continue;
            if (nums[i] < 0) {
                int bIndex = -nums[i];
                if (myNegBitSet.get(bIndex)) {
                    isDuplicate = true;
                    return isDuplicate;
                } else {
                    myNegBitSet.set(bIndex);
                }
            } else {
                int bIndex = nums[i];
                if (myPosBitSet.get(bIndex)) {
                    isDuplicate = true;
                    return isDuplicate;
                } else {
                    myPosBitSet.set(bIndex);
                }
            }
        }

        return isDuplicate;
    }

    public static void main(String[] args) {
        int[] nums1 = {9, 4, 35, 1920, 214, 4};
        int[] nums2 = {9, 4, 35, 1920, 214, 425};
        int[] nums3 = {9, -35, 35, -1920, 214, 4};
        int[] nums4 = {9, 4, 35, 523, 214, 0, 0};
        int[] nums5 = {9, Integer.MAX_VALUE, 35, 523, 214, 0, Integer.MIN_VALUE};

        System.out.println("Expected(True): " + (containsDuplicate(nums1) ? "True" : "False"));
        System.out.println("Expected(False): " + (containsDuplicate(nums2) ? "True" : "False"));
        System.out.println("Expected(False): " + (containsDuplicate(nums3) ? "True" : "False"));
        System.out.println("Expected(True): " + (containsDuplicate(nums4) ? "True" : "False"));
        System.out.println("Expected(False): " + (containsDuplicate(nums5) ? "True" : "False"));

        System.out.println("Expected(True): " + (containsDuplicate2(nums1) ? "True" : "False"));
        System.out.println("Expected(False): " + (containsDuplicate2(nums2) ? "True" : "False"));
        System.out.println("Expected(False): " + (containsDuplicate2(nums3) ? "True" : "False"));
        System.out.println("Expected(True): " + (containsDuplicate2(nums4) ? "True" : "False"));
        System.out.println("Expected(False): " + (containsDuplicate2(nums5) ? "True" : "False"));
    }
}
