package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

import java.util.LinkedList;
import java.util.List;

public class LC095UniqueBSTII {
  public List<TreeNode> generate(int start, int end) {
    List<TreeNode> ans = new LinkedList<>();
    if (start > end) {
      ans.add(null);
      return ans;
    }

    for (int i = start; i <= end; i++) {
      for (TreeNode l : generate(start, i - 1)) {
        for (TreeNode r : generate(i + 1, end)) {
          TreeNode root = new TreeNode(i);
          root.left = l;
          root.right = r;
          ans.add(root);
        }
      }
    }

    return ans;
  }

  public List<TreeNode> generateTrees(int N) {
    if (N == 0) return new LinkedList<TreeNode>();
    return generate(1, N);
  }

  public static void main(String[] args) {
    LC095UniqueBSTII solu = new LC095UniqueBSTII();

    int N = 3;
    List<TreeNode> ans = solu.generateTrees(N);
    for (TreeNode root : ans) {
      Utility.printTreeStructure(root);
    }
  }
}
