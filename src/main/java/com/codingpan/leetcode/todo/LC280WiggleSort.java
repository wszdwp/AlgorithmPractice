package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;

import java.util.Arrays;

public class LC280WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swap(nums, i - 1, i);
            }
        }
    }

    public void wiggleSort2(int[] nums) {
        if (nums.length <= 1) return;
        int l = 0;
    }

    // nlogn
    private void wiggleSortWay2(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) return;
        for (int i = 2; i < nums.length; i += 2) {
            swap(nums, i - 1, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        LC280WiggleSort solu = new LC280WiggleSort();
        //        int[] nums = {3, 5, 2, 1, 6, 4};
        int[] nums = {1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2};
        solu.wiggleSort(nums);
        // solu.wiggleSortWay2(nums);
        Utility.printArray(nums);
    }
}
