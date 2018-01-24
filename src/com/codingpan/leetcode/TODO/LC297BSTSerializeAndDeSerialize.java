package com.codingpan.leetcode.TODO;

import java.util.LinkedList;
import java.util.Queue;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

public class LC297BSTSerializeAndDeSerialize {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)   return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()) {
        	TreeNode node = q.poll();
        	if (node != null) {
	        	sb.append(String.valueOf(node.val) + ",");
	        	q.add(node.left);
	        	q.add(node.right);
        	} else {
        		sb.append("#,");
        	}
        }
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data == null || data.isEmpty()) {
    		return null;
    	}
    	String[] arr = data.split(",");
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
    	q.add(root);
    	
    	int i = 1;
    	while (!q.isEmpty()) {
    		TreeNode nd = q.poll();
    		if (nd == null)	continue;
    		
    		if (!arr[i].equals("#")) {
    			nd.left = new TreeNode(Integer.parseInt(arr[i]));
    			q.offer(nd.left);
    		} else {
    			nd.left = null;
    			q.offer(null);
    		}
    		i++;
    		
    		if (!arr[i].equals("#")) {
    			nd.right = new TreeNode(Integer.parseInt(arr[i]));
    			q.offer(nd.right);
    		} else {
    			nd.right = null;
    			q.offer(null);
    		}
    		i++;
    	}    	
    	
    	return root;
    }
    
    public static void main(String[] args) {
    	int[] treeArr = {1, 2, 3, 4, 5, 6};
    	TreeNode root = Utility.createTree(treeArr);
    	LC297BSTSerializeAndDeSerialize test = new LC297BSTSerializeAndDeSerialize();
    	String serialized = test.serialize(root);
    	System.out.println(serialized);
    	
    	TreeNode root2 = test.deserialize(serialized);
    	printTree(root);
    	System.out.println();
    	System.out.println("isSameTree: " + isSameTree(root, root2));
    }
    
    public static void printTree(TreeNode root) {
    	if (root != null) {
    		printTree(root.left);
    		System.out.print(root.val + ", ");
    		printTree(root.right);
    	}
    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	if (p == null && q == null)	{
    		return true;
    	} else if (p == null || q == null){
    		return false;
    	}
    	
    	return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
