package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LCDuplicateQuestions {
    // every dups appreas two times
    public int removeDuplicatesFromSorted(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        int idx = 1;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i];
                count = 0;
            } else {
                count++;
                if (count < 2) {
                    nums[idx++] = nums[i];
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        // int[] nums = {0,0,1,1,1,1,2,3,3};

        LCDuplicateQuestions solu = new LCDuplicateQuestions();
        int len = solu.removeDuplicatesFromSorted(nums);
        for (int i = 0; i < len; i++) {
            StdOut.print(nums[i] + ",");
        }
    }
}
