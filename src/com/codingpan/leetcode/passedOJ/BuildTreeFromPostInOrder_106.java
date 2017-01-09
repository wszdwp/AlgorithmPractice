package com.codingpan.leetcode.passedOJ;

import java.util.HashMap;
import java.util.Map;

import com.codingpan.leetcode.util.TreeNode;

/**
 * [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
 * 
 * @author pan
 *
 */
public class BuildTreeFromPostInOrder_106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null)   return null;
        int len1 = inorder.length;
        int len2 = postorder.length;
        if (len1 == 0 || len2 == 0 || len1 != len2) return null;
        
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i< inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return helper(inorder, 0, len1-1, postorder, 0, len2-1, inMap);
        
    }
    
    private TreeNode helper(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR, Map<Integer, Integer> inMap) {
        if (inL > inR || postL > postR) return null;
        
        TreeNode root = new TreeNode(postorder[postR]);
        int divide = inMap.get(postorder[postR]);
        root.left = helper(inorder, inL, divide-1, postorder, postL, postL + (divide-inL-1), inMap);
        root.right = helper(inorder, divide+1, inR, postorder, postR-(inR-divide), postR-1, inMap);
        
        return root;
    }
}
