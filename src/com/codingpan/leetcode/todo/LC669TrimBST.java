package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class LC669TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (L > R) return root;
        List<Integer> inOrder = new ArrayList<Integer>();
        dfs(root, L, R, inOrder);
        Utility.printIntList(inOrder);
        return buildTree(inOrder, 0, inOrder.size()-1);
    }

    private void dfs(TreeNode root, int L, int R, List<Integer> inOrder) {
        if (root == null) return;
        dfs(root.left, L, R, inOrder);
        if (root.val >= L && root.val <= R) inOrder.add(root.val);
        dfs(root.right, L, R, inOrder);
    }

    private TreeNode buildTree(List<Integer> inOrder, int l, int r) {
        if (l > r) {
            return null;
        } else {
            int m = l + (r - l) / 2;
            TreeNode root = new TreeNode(inOrder.get(m));
            root.left = buildTree(inOrder, l, m-1);
            root.right = buildTree(inOrder, m+1, r);
            return root;
        }
    }

    public static void main(String[] args) {
        LC669TrimBST solu = new LC669TrimBST();
//        int[] arr = {0, 1, 2, 3, 4};
//        TreeNode root = Utility.createTree(arr);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        Utility.printTreeStructure(root);
        int L = 1;
        int R = 3;
        TreeNode newRoot = solu.trimBST(root, L, R);
        Utility.printTreeStructure(newRoot);
    }
}
