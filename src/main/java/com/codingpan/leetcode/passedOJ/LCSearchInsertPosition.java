package com.codingpan.leetcode.passedOJ;

/**
 * [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/description/)
 * Given a sorted array and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order. You may assume no duplicates in the
 * array.
 *
 * <p>Example 1: Input: [1,3,5,6], 5 Output: 2
 *
 * <p>Example 2: Input: [1,3,5,6], 2 Output: 1
 *
 * <p>Example 3: Input: [1,3,5,6], 7 Output: 4
 *
 * <p>Example 4: Input: [1,3,5,6], 0 Output: 0
 */
public class LCSearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
