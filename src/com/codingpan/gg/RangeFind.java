package com.codingpan.gg;

import edu.princeton.cs.algs4.StdOut;

public class RangeFind {
    /**
     * 有一个double类型的数组， 找满足 [a, a + 1) 的最长序列含有的元素的个数，
     * eg. [ 1.0 ,1.3 ,1.5 ,2.3, 3.5],
     * 最长的是[1.0 1.3 1.5], 应该返回3。
     *
     * 然后面试官提醒了下用greedy的方法。
     * 然而代码还是写的很艰难。。。大家可以自己写写O(n)的方法练习一下。
     *
     * @param nums
     * @param a
     *
     * @return num of ranges
     */
    public int findRange(double[] nums, int a) {
        int ans = 0;
        int len = 0;
        double l = (double) a;
        double r = (double) (a + 1);
        for (double num : nums) {
            if (num >= l && num < r) len++;
            else len = 0;
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public static void main(String[] args) {
        RangeFind solu = new RangeFind();
        double[] nums = {1.0 ,1.3 ,1.5 ,2.3, 3.5, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7};
        int a = 1;
        StdOut.println(solu.findRange(nums, a));
    }
}
