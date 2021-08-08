package com.codingpan.leetcode.passedOJ;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;

        if (res.size() <= level) {
            List<Integer> ans = new LinkedList<>();
            res.add(ans);
        }
        List<Integer> ans = res.get(level);
        if (level % 2 == 0) {
            ans.add(root.val);
        } else {
            ans.add(0, root.val);
        }

        dfs(root.left, level+1, res);
        dfs(root.right, level+1, res);
    }

    public void levelOrderTraverse(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> dq = new LinkedList<>();
        boolean leftToRight = true;
        dq.offerLast(root);
        TreeNode last = root;
        TreeNode nLast = null;
        TreeNode nd = root;
        while (!dq.isEmpty()) {
            if (leftToRight) {
                nd = dq.pollFirst();
                if (nd.left != null) {
                    nLast = nLast == null ? nd.left : nLast;
                    dq.offerLast(nd.left);
                }
                if (nd.right != null) {
                    nLast = nLast == null ? nd.right : nLast;
                    dq.offerLast(nd.right);
                }
            } else {
                nd = dq.pollLast();
                if (nd.right != null) {
                    nLast = nLast == null ? nd.right : nLast;
                    dq.offerFirst(nd.right);
                }
                if (nd.left != null) {
                    nLast = nLast == null ? nd.left : nLast;
                    dq.offerFirst(nd.left);
                }
            }
            StdOut.print(nd.val + " ");
            if (nd == last && !dq.isEmpty()) {
                leftToRight = !leftToRight;
                last = nLast;
                nLast = null;
                StdOut.println();
            }

        }
    }


    public static void main(String[] args) {
        LC103BinaryTreeZigzagLevelOrderTraversal solu = new LC103BinaryTreeZigzagLevelOrderTraversal();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = Utility.createTree(arr);
        //StdOut.println();
        //Utility.printTree(root, Utility.TreeOrder.IN);
        Utility.printTreeStructure(root);
        StdOut.println();
        List<List<Integer>> res = solu.zigzagLevelOrder(root);
        for (List<Integer> ans : res) {
            Utility.printList(ans);
            StdOut.println();
        }

        solu.levelOrderTraverse(root);

    }

}
