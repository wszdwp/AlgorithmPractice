package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144BinaryTreePreOrderTranverse {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) return res;

    Stack<TreeNode> stk = new Stack<TreeNode>();
    stk.push(root);
    while (!stk.isEmpty()) {
      TreeNode nd = stk.pop();
      res.add(nd.val);

      if (nd.right != null) {
        stk.push(nd.right);
      }
      if (nd.left != null) {
        stk.push(nd.left);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    LC144BinaryTreePreOrderTranverse solu = new LC144BinaryTreePreOrderTranverse();
    int[] arr = {2, 4, 5, 7, 8, 9};
    TreeNode root = Utility.createTree(arr);
    Utility.printTree(root, Utility.TreeOrder.LEVEL);
    List<Integer> res = solu.preorderTraversal(root);
    Utility.printList(res);
  }
}
