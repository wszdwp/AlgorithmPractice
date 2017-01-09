package com.codingpan.leetcode.TODO;

import java.util.ArrayList;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

public class RecoverBST_099 {
	public void recoverTree(TreeNode root) {        
        ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        helper(root, prev, res);
        if (res.size() == 2) {
        	int temp = res.get(0).val;
        	res.get(0).val = res.get(1).val;
        	res.get(1).val = temp;
        }
    }
	
	private void helper(TreeNode root, ArrayList<TreeNode> prev, ArrayList<TreeNode> res) {
        if (root == null)	return;
        
        helper(root.left, prev, res);
        if (prev.size() != 0 && prev.get(0).val > root.val) {
        	if (res.size() == 0) {
        		res.add(prev.get(0));
        		res.add(root);
        	} else {
        		res.set(1, root);
        	}
        }
        if (prev.size() == 0) {
        	prev.add(root);
        } else {
        	prev.set(0, root);
        }
        helper(root.right, prev, res);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(10);
		root.left.right.left = new TreeNode(55);	//switched node
		root.right = new TreeNode(38);
		root.right.right = new TreeNode(9);			//switched node
		root.right.left = new TreeNode(35);
		root.right.left.left = new TreeNode(21);
		root.right.left.right = new TreeNode(37);
		
		Utility.printTree(root, Utility.TreeOrder.IN);
		System.out.println();
		RecoverBST_099 sol = new RecoverBST_099();
		sol.recoverTree(root);
		Utility.printTree(root, Utility.TreeOrder.IN);
		System.out.println();
	}
}
