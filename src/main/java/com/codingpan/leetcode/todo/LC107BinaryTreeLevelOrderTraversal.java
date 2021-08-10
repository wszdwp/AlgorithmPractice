package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

public class LC107BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {

    List<List<Integer>> res = new LinkedList<List<Integer>>();
    if (root == null) return res;

    dfsLevelOrder(res, root, 0);
    return res;

    //        Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //        queue.offer(root);
    //        int currLevelCount = 1;
    //        int nextLevelCount = 0;
    //        List<Integer> level = new LinkedList<>();
    //        while (!queue.isEmpty()) {
    //            TreeNode nd = queue.poll();
    //            level.add(nd.val);
    //            currLevelCount--;
    //
    //            if (nd.left != null) {
    //                queue.offer(nd.left);
    //                nextLevelCount++;
    //            }
    //            if (nd.right != null) {
    //                queue.offer(nd.right);
    //                nextLevelCount++;
    //            }
    //            if (currLevelCount == 0) {
    //                res.add(0, level);
    //                level = new LinkedList<Integer>();
    //                currLevelCount = nextLevelCount;
    //                nextLevelCount = 0;
    //            }
    //        }
    //        return res;
  }

  public List<List<Integer>> levelOrderBottom2(TreeNode root) {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    if (root == null) return res;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> level = new LinkedList<>();
      for (int i = 0; i < levelSize; i++) {
        TreeNode nd = queue.poll();
        if (nd.left != null) {
          queue.offer(nd.left);
        }
        if (nd.right != null) {
          queue.offer(nd.right);
        }
        level.add(nd.val);
      }
      res.add(0, level);
    }

    return res;
  }

  public void dfsLevelOrder(List<List<Integer>> res, TreeNode root, int height) {
    if (root == null) return;
    if (height >= res.size()) {
      //            res.add(new LinkedList<Integer>());
      res.add(0, new LinkedList<Integer>()); // bottom up
    }
    //        res.get(height).add(root.val);
    res.get(res.size() - height - 1).add(root.val); // bottom up
    dfsLevelOrder(res, root.left, height + 1);
    dfsLevelOrder(res, root.right, height + 1);
  }

  public static void main(String[] args) {
    LC107BinaryTreeLevelOrderTraversal solu = new LC107BinaryTreeLevelOrderTraversal();
    int[] arr = {2, 4, 5, 6, 7, 8, 9};
    TreeNode root = Utility.createTree(arr);
    Utility.printTree(root, Utility.TreeOrder.LEVEL);
    List<List<Integer>> res = solu.levelOrderBottom(root);
    for (List<Integer> aList : res) {
      System.out.println(aList);
    }
  }
}
