package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = root;
        while (!stk.isEmpty() || p != null) {
            if (p != null) {
                stk.push(p);
                p = p.left;
            } else {
                TreeNode nd = stk.pop();
                res.add(nd.val);
                p = nd.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC94BinaryTreeInorderTraversal solu = new LC94BinaryTreeInorderTraversal();
        int[] arr = {2, 4, 5, 7, 8, 9};
        TreeNode root = Utility.createTree(arr);
        Utility.printTree(root, Utility.TreeOrder.IN);
        StdOut.println();
        //        Utility.printTree(root, Utility.TreeOrder.LEVEL);
        List<Integer> res = solu.inorderTraversal(root);
        Utility.printList(res);
    }
}
