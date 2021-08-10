package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

import java.util.List;
import java.util.Stack;

public class LC230KthSmallestElemInBST {
  public int kthSmallest(TreeNode root, int k) {
    //        List<Integer> ans = new ArrayList<>();
    //        dfs(root, ans);
    //        return ans.get(k-1);

    return iDfs(root, k);
  }

  private void dfs(TreeNode root, List<Integer> ans) {
    if (root == null) return;
    dfs(root.left, ans);
    ans.add(root.val);
    dfs(root.right, ans);
  }

  private int iDfs(TreeNode root, int k) {
    Stack<TreeNode> stk = new Stack();
    TreeNode p = root;
    while (!stk.isEmpty() || p != null) {
      if (p != null) {
        stk.push(p);
        p = p.left;
      } else {
        TreeNode nd = stk.pop();
        k--;
        if (k == 0) return nd.val;
        p = nd.right;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    LC230KthSmallestElemInBST solu = new LC230KthSmallestElemInBST();
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    TreeNode root = Utility.createTree(arr);
    Utility.printTree(root, Utility.TreeOrder.LEVEL);
    int res = solu.kthSmallest(root, 4);
    System.out.println(res);
  }
}
