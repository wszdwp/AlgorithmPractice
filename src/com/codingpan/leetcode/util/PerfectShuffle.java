package com.codingpan.leetcode.util;

public class PerfectShuffle {
    // 完美洗牌
    // eg1:
    // a1 a2 b1 b2
    // b1 a1 b2 a2

    // eg2:
    // a1 a2 a3 b1 b2 b3
    // b1 a1 b2 a2 b3 a3

    // (2 * i) % (len + 1),  i is from [1, len] 变完之后的位置

    //变形 先排序 再完美洗牌 得到
    //a <= b >= c <= d >= e <= f >= ....


    // 完美洗牌的结论
    // 长度（偶数） = 3^k - 1， 驱动点3^(k-1)
}
