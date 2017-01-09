package com.codingpan.leetcode.util;


public class Utility {
	public static enum TreeOrder {
		PRE, IN, POST, LEVEL,
	}
	
	public static TreeNode createTree(int[] arr) {
		 return createTreeHelper(arr, 0, arr.length-1);
	}
	 
	private static TreeNode createTreeHelper(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		} else {
			int mid = (start + end) / 2;
			TreeNode root = new TreeNode(arr[mid]);
			root.left = createTreeHelper(arr, start, mid-1);
			root.right = createTreeHelper(arr, mid+1, end);
			return root;
		}
	}
	
	public static void printTree(TreeNode root, TreeOrder order) {
		if (root != null) {
			if (order == TreeOrder.IN) {
				printTree(root.left, order);
				System.out.print(root.val + ", ");
				printTree(root.right, order);
			} else if (order == TreeOrder.PRE) {
				System.out.print(root.val + ", ");
				printTree(root.left, order);
				printTree(root.right, order);
			} else if (order == TreeOrder.POST) {
				printTree(root.left, order);
				printTree(root.right, order);
				System.out.print(root.val + ", ");
			} else if (order == TreeOrder.LEVEL) {
				
			}
		}
	}
	
}
