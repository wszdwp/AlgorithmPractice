package com.codingpan.leetcode.high;

import com.codingpan.leetcode.util.NestedInteger;

import java.util.List;

public class LC364NestedListWeightedSum {
  // 201805 phone by linkedin
  // [solu](https://www.programcreek.com/2014/08/leetcode-nested-list-weight-sum-ii-java/)

  /**
   * Example 1: Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
   *
   * <p>Example 2: Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and
   * one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
   *
   * @param nestedList
   * @return
   */
  public int depthSumInverse(List<NestedInteger> nestedList) {
    int sum = 0;
    // TODO: impl

    return sum;
  }

  /**
   * Example 1: Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
   *
   * @param nestedList
   * @return
   */
  public int depthSum(List<NestedInteger> nestedList) {
    int sum = 0;
    // TODO: impl

    return sum;
  }

  public static void main(String[] args) {
    LC364NestedListWeightedSum solu = new LC364NestedListWeightedSum();
  }
}
