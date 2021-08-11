package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [47. Permutations II](https://leetcode.com/problems/permutations-ii/)

// Given a collection of numbers that might contain duplicates,
// return all possible unique permutations.
//
// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].

public class LC047Permutations {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> perms = new ArrayList<List<Integer>>();
        if (nums.length == 0) return perms;
        Arrays.sort(nums);
        permute(nums, new boolean[nums.length], new ArrayList<Integer>(), perms);
        return perms;
    }

    private void permute(int[] nums, boolean[] used, List<Integer> perm, List<List<Integer>> perms) {
        if (perm.size() == nums.length) {
            perms.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) continue;
                if (!used[i]) {
                    used[i] = true;
                    perm.add(nums[i]);
                    permute(nums, used, perm, perms);
                    perm.remove(perm.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    /**
     * unit com.codingpan.test
     *
     * @param args
     */
    public static void main(String[] args) {
        LC047Permutations solu = new LC047Permutations();
        int[] nums = {1, 1, 3};
        List<List<Integer>> res = solu.permuteUnique(nums);
        for (List<Integer> aList : res) {
            Utility.printList(aList);
        }
    }
}
