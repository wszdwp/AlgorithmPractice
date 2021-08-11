package com.codingpan.leetcode.passedOJ;

import com.codingpan.leetcode.util.TreeNode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author pan
 */
public class LC105BuildTreeFromPreInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        int len1 = preorder.length;
        int len2 = inorder.length;
        if (len1 == 0 || len2 == 0 || len1 != len2) return null;

        HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len2; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(preorder, 0, len1 - 1, inorder, 0, len2 - 1, inMap);
    }

    private TreeNode helper(
            int[] preorder,
            int preL,
            int preR,
            int[] inorder,
            int inL,
            int inR,
            HashMap<Integer, Integer> inMap) {
        if (preL > preR || inL > inR) return null;

        int mid = inMap.get(preorder[preL]);
        TreeNode root = new TreeNode(preorder[preL]);
        root.left = helper(preorder, preL + 1, mid - inL + preL, inorder, inL, mid - 1, inMap);
        root.right = helper(preorder, mid - inL + 1 + preL, preR, inorder, mid + 1, inR, inMap);

        return root;
    }
}
