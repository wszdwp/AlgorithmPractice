package com.codingpan.leetcode.util;


import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Utility {
	public static final String PATH = "/Users/pan/Documents/Playspace/AlgorithmPractice/src/com/codingpan/leetcode/testcase/";
	public static enum TreeOrder {
		PRE, IN, POST, LEVEL,
	}

	public static ListNode createLinkedList(int[] arr) {
		if (arr == null || arr.length == 0) return null;

		ListNode head = new ListNode(arr[0]);
		ListNode p = head;
		for (int i = 1; i < arr.length; i++) {
			ListNode nd = new ListNode(arr[i]);
			p.next = nd;
			p = p.next;
		}

		return head;
	}

	public static void printLinkedList(ListNode head) {
		while (head != null) {
			StdOut.print(head.val + "->");
			head = head.next;
		}
		StdOut.println("NULL");
	}
	
	public static TreeNode createTree(int[] arr) {
		 return createTreeHelper(arr, 0, arr.length-1);
	}

	public static TreeNode createTreeLevelOrder(int[] arr) {
		return createTreeLevelOrderHelper(arr);
	}

	private static TreeNode createTreeLevelOrderHelper(int[] arr) {
		if (arr.length == 0) return null;

		Queue<TreeNode> queue = new LinkedList<>();
		int i = 0;
		TreeNode root = new TreeNode(arr[i]);
		i++;
		queue.offer(root);
		while (!queue.isEmpty() && i < arr.length) {
			TreeNode nd = queue.poll();
			if (arr[i] < nd.val) {
				nd.left = new TreeNode(arr[i]);
				queue.offer(nd.left);
				i++;
			}
			if (arr[i] > nd.val) {
				nd.right = new TreeNode(arr[i]);
				queue.offer(nd.right);
				i++;
			}
		}

		return root;
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

	public static TreeNode createTreeFromInPre(int[] in, int[] pre) {
		if (in == null || pre == null || in.length != pre.length)
			throw new IllegalArgumentException("Invalid arguments");
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			inMap.put(in[i], i);
		}
		return inPreHelper(in, 0, in.length-1, pre, 0, pre.length-1, inMap);
	}

	private static TreeNode inPreHelper(int[] in, int inL, int inR, int[] pre, int preL, int preR, Map<Integer, Integer> inMap) {
		if (preL > preR) return null;
		TreeNode head = new TreeNode();
		head.val = pre[preL];
		int inPos = inMap.get(head.val);
		head.left = inPreHelper(in, inL, inPos-1, pre, preL+1, preL+inPos-inL, inMap);
		head.right = inPreHelper(in, inPos+1, inR, pre, preL+inPos-inL+1, preR, inMap);
		return head;
	}

	public static TreeNode createTreeFromInPost(int[] in, int[] post) {
		if (in == null || post == null || in.length != post.length)
			throw new IllegalArgumentException("Invalid arguments");
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			inMap.put(in[i], i);
		}
		return inPostHelper(in, 0, in.length-1, post, 0, post.length-1, inMap);
	}

	private static TreeNode inPostHelper(int[] in, int inL, int inR, int[] post, int poL, int poR, Map<Integer, Integer> inMap) {
		if (poL > poR) return null;
		TreeNode root = new TreeNode(post[poR]);
		int inIdx = inMap.get(root.val);
		root.right = inPostHelper(in, inIdx+1, inR, post, poR-inIdx+inL, poR-1, inMap);
		root.left = inPostHelper(in, inL, inIdx-1, post, poL, poR-inIdx+inL-1, inMap);
		return root;
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
				Queue<TreeNode> queue = new LinkedList<TreeNode>();
				queue.offer(root);
				int levelCount = 1;
				int nextLevelCount = 0;
				while (!queue.isEmpty()) {
				    TreeNode nd = queue.poll();
				    levelCount--;
                    System.out.print(nd.val + ", ");
                    if (nd.left != null) {
                    	queue.offer(nd.left);
						nextLevelCount++;
					}
                    if (nd.right != null) {
                    	queue.offer(nd.right);
						nextLevelCount++;
					}
                    if (levelCount == 0) {
                    	levelCount = nextLevelCount;
                    	nextLevelCount = 0;
						System.out.println();
					}
                }
			}
		}
	}

    public static void printLinkTree(TreeLinkNode root, TreeOrder order) {
        if (root != null) {
            if (order == TreeOrder.IN) {
                printLinkTree(root.left, order);
                System.out.print(root.val + ", ");
                printLinkTree(root.right, order);
            } else if (order == TreeOrder.PRE) {
                System.out.print(root.val + ", ");
                printLinkTree(root.left, order);
                printLinkTree(root.right, order);
            } else if (order == TreeOrder.POST) {
                printLinkTree(root.left, order);
                printLinkTree(root.right, order);
                System.out.print(root.val + ", ");
            } else if (order == TreeOrder.LEVEL) {
                Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
                queue.offer(root);
                int levelCount = 1;
                int nextLevelCount = 0;
                while (!queue.isEmpty()) {
                    TreeLinkNode nd = queue.poll();
                    levelCount--;
                    System.out.print(nd.val + ", ");
                    if (nd.left != null) {
                        queue.offer(nd.left);
                        nextLevelCount++;
                    }
                    if (nd.right != null) {
                        queue.offer(nd.right);
                        nextLevelCount++;
                    }
                    if (levelCount == 0) {
                        levelCount = nextLevelCount;
                        nextLevelCount = 0;
                        System.out.println();
                    }
                }
            }
        }
    }

	public static void printArray(int[] nums) {
		for (int n : nums) {
			System.out.print(n + ", ");
		}
		System.out.println();
	}

	public static void printCharArray(char[] chars) {
		for (char c : chars) {
			System.out.print(c + ", ");
		}
		System.out.println();
	}

	public static<E> void printList(List<E> aList) {
		for (E e : aList) {
			System.out.print(e + ", ");
		}
		System.out.println();
	}

	public static int[][] generateMatrix(int row, int col) {
		int[][] matrix = new int[row][col];
		int elem = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = elem;
				elem++;
			}
		}

		return matrix;
	}

	public static void printMatrix(int[][] matrix) {
        StdOut.println("[");
        for (int i = 0; i < matrix.length; i++) {
            StdOut.print("  [");
            for (int j = 0; j < matrix[0].length; j++) {
                StdOut.print(matrix[i][j]);
                if (j != matrix[0].length-1) {
                    StdOut.print(", ");
                }
            }
            StdOut.println("],");
        }
        StdOut.println("]");
    }

	public static void printBooleanMatrix(boolean[][] matrix) {
		StdOut.println("[");
		for (int i = 0; i < matrix.length; i++) {
			StdOut.print("  [");
			for (int j = 0; j < matrix[0].length; j++) {
				StdOut.print(matrix[i][j]);
				if (j != matrix[0].length-1) {
					StdOut.print(", ");
				}
			}
			StdOut.println("],");
		}
		StdOut.println("]");
	}

    public static void morrisTranversal(TreeNode root, TreeOrder order) {
		if (root == null) return;

		TreeNode curr = root;
		TreeNode p = null;
		while (curr != null) {
			p = curr.left;
			if (p != null) {
				while (p.right != null && p.right != curr) {
					p = p.right;
				}
				if (p.right == null) {
					p.right = curr;
					if (order == TreeOrder.PRE) {
						StdOut.print(curr.val + " ");
					}
					curr = curr.left;
					continue;
				} else {
					p.right = null;
					if (order == TreeOrder.POST) {
						printEdge(curr.left);
					}
				}
			} else {
				if (order == TreeOrder.PRE) {
					StdOut.print(curr.val + " ");
				}
			}
			if (order == TreeOrder.IN) {
				StdOut.print(curr.val + " ");
			}
			curr = curr.right;
		}
		if (order == TreeOrder.POST) {
			printEdge(root);
		}
		StdOut.println();

	}

	public static void printEdge(TreeNode head) {
		TreeNode tail = reverseEdge(head);
		TreeNode cur = tail;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.right;
		}
		reverseEdge(tail);
	}

	public static TreeNode reverseEdge(TreeNode from) {
		TreeNode pre = null;
		TreeNode next = null;
		while (from != null) {
			next = from.right;
			from.right = pre;
			pre = from;
			from = next;
		}
		return pre;
	}

	public static void printTreeStructure(TreeNode head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(TreeNode head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.val + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void permutate(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> ans) {
		if (cur.size() == nums.length) {
			ans.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			used[i] = true;
			cur.add(nums[i]);
			permutate(nums, used, cur, ans);
			cur.remove(cur.size() - 1);
			used[i] = false;
		}
	}

	public static void getCombination(int[] nums, int s, List<Integer> cur, List<List<Integer>> ans) {
		if (s == nums.length) {
			ans.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = s; i < nums.length; i++) {
			cur.add(nums[i]);
			getCombination(nums, i + 1, cur, ans);
			cur.remove(cur.size() - 1);
		}
	}

	// way 2
	public static void combination(int[] nums, int d, int n, int s, List<Integer> cur, List<List<Integer>> ans) {
		if (s == n) {
			ans.add(new ArrayList<>(cur));
		}
		if (d == n) {
			StdOut.print("sum = ");
			printList(cur);
			return;
		}

		for (int i = s; i < nums.length; i++) {
			cur.add(nums[i]);
			combination(nums, d + 1, n, i + 1, cur, ans);
			cur.remove(cur.size() - 1);
		}
	}

	/**
	 * Unit test utility functions
	 * @param args
	 */
	public static void main(String[] args) {
		int[] in = {4, 2, 5, 1, 6, 3, 7};
		int[] pre = {1, 2, 4, 5, 3, 6, 7};
		int[] post = {4, 5, 2, 6, 7, 3, 1};
		TreeNode root = createTreeFromInPre(in, pre);
		//printTree(root, TreeOrder.LEVEL);

        TreeNode root2 = createTreeFromInPost(in, post);
        //printTree(root2, TreeOrder.LEVEL);

//		morrisTranversal(root, TreeOrder.PRE);
//		morrisTranversal(root, TreeOrder.IN);
//		morrisTranversal(root, TreeOrder.POST);

		//int[] level = {7, 4, 12, 3, 6, 8, 1, 5, 10};
		int[] level = {8, 6, 9, 1, 7, 12};

//		TreeNode root3 = createTreeLevelOrder(level);
//		Utility.printTreeStructure(root3);

		int[] nums = {1, 2, 3};
		boolean[] used = new boolean[nums.length];
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> cur = new ArrayList<Integer>();

		//permutate(nums, used, new ArrayList<Integer>(), ans);
		//getCombination(nums, 0, new ArrayList<Integer>(), ans);
		combination(nums, 0, nums.length, 0, cur, ans);
		for (List<Integer> one : ans) {
			printList(one);
		}
	}
	
}
