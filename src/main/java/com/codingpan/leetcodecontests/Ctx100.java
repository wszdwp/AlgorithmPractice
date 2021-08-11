package com.codingpan.leetcodecontests;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

public class Ctx100 {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) return false;
        if (A.length == 1) return true;

        boolean monoIncr = false;
        boolean monoDecr = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                if (monoDecr) return false;
                monoIncr = true;
            }
            if (A[i - 1] > A[i]) {
                if (monoIncr) return false;
                monoDecr = true;
            }
        }
        return true;
    }

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) return null;
        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);
        return left;
    }

    public static void main(String[] args) {
        Ctx100 solu = new Ctx100();
        int[] arr = {1, 1, 1, 2, 2};
        StdOut.println(solu.isMonotonic(arr));

        TreeNode root = Utility.createTreeLevelOrder(new int[]{5, 3, 6, 2, 4, 8});
        Utility.printTreeStructure(root);
        solu.increasingBST(root);
        Utility.printTreeStructure(root);
    }
}
