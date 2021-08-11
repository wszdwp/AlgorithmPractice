package com.codingpan.leetcodecontests;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

public class Ctx35 {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(t, sb);
        return sb.toString();
    }

    private void dfs(TreeNode t, StringBuilder sb) {
        if (t != null) {
            sb.append("(");
            sb.append(t.val);
            sb.append(")");
            if (t.left != null && t.right != null) {

            } else if (t.left == null && t.right != null) {

            }
            dfs(t.left, sb);
            dfs(t.right, sb);
        }
    }

    public static void main(String[] args) {
        Ctx35 solu = new Ctx35();

        // 1(2(4)())(3()()) -> Output: "1(2(4))(3)"
        //        int[] in = {4, 2, 1, 3};
        //        int[] pre = {1, 2, 4, 3};

        // Output: "1(2()(4))(3)"
        int[] in = {2, 4, 1, 3};
        int[] pre = {1, 2, 4, 3};
        TreeNode root = Utility.createTreeFromInPre(in, pre);
        String res = solu.tree2str(root);
        StdOut.println(res);
    }
}
