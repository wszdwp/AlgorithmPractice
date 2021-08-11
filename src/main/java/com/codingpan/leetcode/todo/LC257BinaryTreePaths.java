package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC257BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<LinkedList<String>> res = new LinkedList<LinkedList<String>>();
        LinkedList<String> ans = new LinkedList<String>();

        if (root == null) {
            return convertRes(res);
        }

        ans.add(String.valueOf(root.val));
        helper(root, ans, res);
        //        Stack<TreeNode> stk = new Stack<TreeNode>();
        //        stk.push(root);
        //
        //        while (!stk.isEmpty()) {
        //            TreeNode nd = stk.peek();
        //            if (nd.left == null && nd.right == null) {
        //                sb.append(nd.val);
        //            	stk.pop();
        //                res.add(sb.toString());
        //            	sb.deleteCharAt(sb.length()-1);
        //            } else {
        //                if (nd.left != null) {
        //                    stk.push(nd.left);
        //                    sb.append(nd.val);
        //                    nd.left = null;
        //                } else {
        //                    if (nd.right != null) {
        //                        stk.push(nd.right);
        //                        sb.append(nd.val);
        //                        nd.right = null;
        //                    }
        //                }
        //            }
        //        }

        return convertRes(res);
    }

    private static List<String> convertRes(List<LinkedList<String>> res) {
        List<String> result = new LinkedList<String>();

        for (LinkedList<String> ans : res) {
            StringBuilder sb = new StringBuilder();
            for (String s : ans) {
                sb.append(s);
                sb.append("->");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }

        return result;
    }

    private static void helper(
            TreeNode root, LinkedList<String> ans, LinkedList<LinkedList<String>> res) {
        if (root.left == null && root.right == null) {
            res.add(new LinkedList<String>(ans));
        } else {
            if (root.left != null) {
                ans.add(String.valueOf(root.left.val));
                helper(root.left, ans, res);
                ans.remove(ans.size() - 1);
            }

            if (root.right != null) {
                ans.add(String.valueOf(root.right.val));
                helper(root.right, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(27);
        root.right = new TreeNode(43);
        root.left.right = new TreeNode(65);

        System.out.println(binaryTreePaths(root));
    }
}
