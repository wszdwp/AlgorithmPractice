package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class LC894AllPossibleFullBinaryTrees {
  public List<TreeNode> allPossibleFBT(int N) {
    List<TreeNode> ans = new ArrayList<>();
    if (N % 2 == 0) return ans;
    if (N == 1) {
      ans.add(new TreeNode(0));
      return ans;
    }
    for (int i = 1; i < N; i += 2) {
      for (TreeNode l : allPossibleFBT(i)) {
        for (TreeNode r : allPossibleFBT(N - i - 1)) {
          TreeNode root = new TreeNode(0);
          root.left = l;
          root.right = r;
          ans.add(root);
        }
      }
    }
    return ans;
  }

  private static final List<List<TreeNode>> dp = new ArrayList<>(21);

  public List<TreeNode> allPossibleFBTDP(int N) {
    List<TreeNode> ans = new ArrayList<>();

    if (N % 2 == 0) return ans;
    dp.add(new ArrayList<TreeNode>());
    ans.add(new TreeNode(0));
    dp.add(ans);
    for (int i = 3; i < N; i += 2) {
      for (int j = 1; j < i; j += 2) {
        int k = i - j - 1;
        for (TreeNode l : dp.get(j - 1)) {
          for (TreeNode r : dp.get(k - 1)) {
            TreeNode root = new TreeNode(0);
            root.left = l;
            root.right = r;
            ans.add(root);
            dp.set(i, ans);
          }
        }
      }
    }
    return dp.get(N);
  }

  public static void main(String[] args) {
    LC894AllPossibleFullBinaryTrees solu = new LC894AllPossibleFullBinaryTrees();
    int N = 7;
    List<TreeNode> trees = solu.allPossibleFBT(N);
    for (TreeNode root : trees) {
      Utility.printTreeStructure(root);
    }
  }
}
