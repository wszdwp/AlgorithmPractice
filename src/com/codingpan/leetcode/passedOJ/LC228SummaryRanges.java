package com.codingpan.leetcode.passedOJ;


import java.util.ArrayList;
import java.util.List;

/**
 * [228. Summary Ranges](https://leetcode.com/problems/summary-ranges/description/)
 * Given a sorted integer array without duplicates,
 * return the summary of its ranges.
 *
 * Example 1:
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Example 2:
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 */

public class LC228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        if (nums == null || nums.length == 0)   return ranges;
        if (nums.length == 1) {
            ranges.add(nums[0] + "");
            return ranges;
        }
        int i = 1;
        int start = 0;
        while (i < nums.length) {
            if (nums[i] > nums[i-1] + 1) {
                if (i > start+1) {
                    ranges.add(nums[start] + "->" + nums[i-1]);
                } else {
                    ranges.add(nums[start] + "");
                }
                start = i;
            }
            if (i == nums.length-1) {
                if (i > start+1) {
                    ranges.add(nums[start] + "->" + nums[i]);
                } else {
                    ranges.add(nums[start] + "");
                }
            }
            i++;
        }

        return ranges;
    }

    public static void main(String[] args) {
        LC228SummaryRanges solu = new LC228SummaryRanges();
        //int[] nums = {0, 1, 2, 4, 5, 7};
        //int[] nums = {0, 2, 3, 4, 6, 8, 9};
        //int[] nums = {0, 10, 20, 40, 41, 55, 100};
        int[] nums = {};
        System.out.println(solu.summaryRanges(nums));
    }
}
