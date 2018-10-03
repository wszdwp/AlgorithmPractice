package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeLinkNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.Queue;

public class LC117PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
    }

    public void connectMyVersion(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        TreeLinkNode head = null;
        int level = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            TreeLinkNode nd = queue.poll();
            level--;
            if (head != null) {
                head.next = nd;
            }
            head = nd;
            if (nd.left != null) {
                queue.offer(nd.left);
                nextLevel++;
            }
            if (nd.right != null) {
                queue.offer(nd.right);
                nextLevel++;
            }
            if (level == 0) {
                level = nextLevel;
                nextLevel = 0;
                head = null;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(7);

        LC117PopulatingNextRightPointersinEachNodeII solu = new LC117PopulatingNextRightPointersinEachNodeII();
        solu.connect(root);
        Utility.printLinkTree(root, Utility.TreeOrder.LEVEL);

        TreeLinkNode head = root;
        while (head != null) {
            TreeLinkNode curr = head;
            while (curr != null) {
                StdOut.print(curr.val + "->") ;
                curr = curr.next;
            }
            StdOut.println("NULL");
            head = head.left;
        }
    }

}
