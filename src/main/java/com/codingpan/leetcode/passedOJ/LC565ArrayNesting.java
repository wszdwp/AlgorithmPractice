package com.codingpan.leetcode.passedOJ;

/**
 * [565. Array Nesting](https://leetcode.com/problems/array-nesting/description/) A zero-indexed
 * array A of length N contains all integers from 0 to N-1. Find and return the longest length of
 * set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 *
 * <p>Suppose the first element in S starts with the selection of element A[i] of index = i, the
 * next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right
 * before a duplicate element occurs in S.
 *
 * <p>Example 1: Input: A = [5,4,0,3,1,6,2] Output: 4 Explanation: A[0] = 5, A[1] = 4, A[2] = 0,
 * A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * <p>One of the longest S[K]: S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * <p>Note: N is an integer within the range [1, 20,000]. The elements of A are all distinct. Each
 * element of A is an integer within the range [0, N-1].
 */
public class LC565ArrayNesting {
    // change the content of the array
    public int arrayNesting(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int maxLen = 1;

        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            while (i != nums[i]) {
                int tmp = nums[i];
                nums[i] = i;
                i = tmp;
                len++;
            }
            if (maxLen < len) maxLen = len;
        }

        return maxLen;
    }

    // not change the content of the array, need extra n spaces
    //    public int arrayNesting(int[] nums) {
    //        if (nums.length <= 1)   return nums.length;
    //        int maxLen = 1;
    //        boolean[] company = new boolean[nums.length];
    //        for (int i = 0; i < nums.length; i++) {
    //            int len = 0;
    //            while (!company[i] && i != nums[i]) {
    //                company[i] = true;
    //                i = nums[i];
    //                len++;
    //            }
    //            if (maxLen < len) maxLen = len;
    //        }
    //
    //        return maxLen;
    //    }
}
