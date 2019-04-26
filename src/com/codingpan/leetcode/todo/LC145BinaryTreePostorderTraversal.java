package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        TreeNode prev = null;
        while (!stk.isEmpty()) {
            TreeNode curr = stk.peek();

            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stk.push(curr.left);
                }
                else if (curr.right != null) {
                    stk.push(curr.right);
                }
                else {
                    stk.pop();
                    res.add(curr.val);
                }
            }
            else if (curr.left == prev) {
                if (curr.right != null) {
                    stk.push(curr.right);
                }
                else {
                    stk.pop();
                    res.add(curr.val);
                }
            }
            else if (curr.right == prev) {
                stk.pop();
                res.add(curr.val);
            }
            prev = curr;
        }

        return res;
    }

    public static void main(String[] args) {
        LC145BinaryTreePostorderTraversal solu = new LC145BinaryTreePostorderTraversal();
        int[] arr = {2, 4, 5, 7, 8, 9};
        TreeNode root = Utility.createTree(arr);
        Utility.printTree(root, Utility.TreeOrder.LEVEL);
        List<Integer> res = solu.postorderTraversal(root);
        Utility.printList(res);
    }
}
