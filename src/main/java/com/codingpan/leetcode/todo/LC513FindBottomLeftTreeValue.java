package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

public class LC513FindBottomLeftTreeValue {
  public int findBottomLeftValue(TreeNode root) {
    int[] ans = new int[2]; // maxDepth, targetNode
    //        dfs(root, ans, 0);
    ans[1] = root.val;
    findLeft(root, false, 0, ans);
    return ans[1];
  }

  private void dfs(TreeNode root, int[] res, int depth) {
    if (root == null) return;
    dfs(root.left, res, depth++);
    if (res[0] < depth) {
      res[0] = depth;
      res[1] = root.val;
    }
    depth--;
    dfs(root.right, res, depth++);
  }

  private void findLeft(TreeNode root, boolean isLeft, int width, int[] ans) {
    if (root == null) return;
    if (root.left == null && root.right == null && isLeft) {
      if (ans[0] < width) {
        ans[0] = width;
        ans[1] = root.val;
      }
    }
    findLeft(root.left, true, width++, ans);
    findLeft(root.right, false, width, ans);
  }

  public static void main(String[] args) {
    LC513FindBottomLeftTreeValue solu = new LC513FindBottomLeftTreeValue();
    int[] arr = {3, 2};
    TreeNode root = Utility.createTree(arr);
    Utility.printTree(root, Utility.TreeOrder.LEVEL);
    int res = solu.findBottomLeftValue(root);
    System.out.println(res);
  }
}
