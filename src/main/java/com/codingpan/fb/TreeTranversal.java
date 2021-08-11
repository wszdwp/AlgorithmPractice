package com.codingpan.fb;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class TreeTranversal {
    // Iter

    /**
     * left -> root -> right
     *
     * @param root
     */
    public void inOrderIter(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode p = root;
        while (!stk.isEmpty() || p != null) {
            if (p != null) {
                stk.push(p);
                p = p.left;
            } else {
                TreeNode nd = stk.pop();
                StdOut.print(nd.val + ",");
                p = nd.right;
            }
        }
        StdOut.println();
    }

    /**
     * root -> left -> right
     *
     * @param root
     */
    public void preOrderIter(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode p = root;
        stk.push(p);
        while (!stk.isEmpty()) {
            TreeNode nd = stk.pop();
            StdOut.print(nd.val + ",");
            if (nd.right != null) {
                stk.push(nd.right);
            }
            if (nd.left != null) {
                stk.push(nd.left);
            }
        }
        StdOut.println();
    }

    /**
     * left -> right -> root
     *
     * @param root
     */
    public void postOrderIter1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<>();
        Stack<TreeNode> ans = new Stack<>();
        TreeNode p = root;
        stk.push(p);
        while (!stk.isEmpty()) {
            TreeNode nd = stk.pop();
            ans.push(nd);
            if (nd.left != null) {
                stk.push(nd.left);
            }
            if (nd.right != null) {
                stk.push(nd.right);
            }
        }
        while (!ans.isEmpty()) {
            TreeNode nd = ans.pop();
            StdOut.print(nd.val + ",");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        TreeTranversal treeTranversal = new TreeTranversal();
        int[] inOrder = {2, 3, 1, 4, 5};
        int[] preOrder = {1, 2, 3, 4, 5};
        int[] postOrder = {3, 2, 5, 4, 1};
        TreeNode root = Utility.createTreeFromInPre(inOrder, preOrder);
        treeTranversal.inOrderIter(root);
        treeTranversal.preOrderIter(root);
        treeTranversal.postOrderIter1(root);
    }
}
