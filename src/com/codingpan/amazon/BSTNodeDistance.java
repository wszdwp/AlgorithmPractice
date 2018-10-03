package com.codingpan.amazon;

import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class BSTNodeDistance {
    //[http://www.1point3acres.com/](http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=434297&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311)
    /**
     * 给定一个integer数组（无序）和2个node值，求构建bst(不可调整树）后，两个node的距离。
     * Given a list of numbers, construct a BST from it and find the distance between two nodes.
     *
     */
    public int bstDistance(int[] values, int node1, int node2) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(values);
        TreeNode root = buildBST(values, 0, values.length-1);
        Utility.printTree(root, Utility.TreeOrder.LEVEL);
        Utility.printTreeStructure(root);

        TreeNode lca = lowestCommonAncestor(root, new TreeNode(node1), new TreeNode(node2));
//        TreeNode lca = lowestCommonAncestorBST(root, new TreeNode(node1), new TreeNode(node2));

        int d1 = getDepth(root, node1, 1);
        int d2 = getDepth(root, node2, 1);
        if (d1 == 0 || d2 == 0) return -1;

        int d0 = getDepth(root, lca.val, 1);

        return d1 + d2 - 2 * d0;
    }

    public TreeNode buildBST(int[] values, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(values[mid]);
        root.left = buildBST(values, start, mid-1);
        root.right = buildBST(values, mid+1, end);
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val  || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        else if (left != null) {
            return left;
        }
        else if (right != null) {
            return right;
        }
        else {
            return null;
        }
    }

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val  || root.val == q.val) return root;

        if (root.val > p.val && root.val < q.val) {
            return root;
        }
        else if (root.val > p.val && root.val > q.val) {
            lowestCommonAncestorBST(root.left, p, q);
        }
        else if (root.val < p.val && root.val < q.val) {
            lowestCommonAncestorBST(root.right, p, q);
        }

        return root;
    }

    private int getDepth(TreeNode root, int n, int level) {
        if (root == null) {
            return 0;
        }

        if (root.val == n) {
            return level;
        }

        int downlevel = 0;
        if (root.val > n) {
            downlevel = getDepth(root.left, n, level + 1);
        } else {
            downlevel = getDepth(root.right, n, level + 1);
        }
        return downlevel;
//        if (downlevel != 0) {
//            return downlevel;
//        } else {
//            return 0;
//        }
    }



    /**
     * 给定一个string 和K值，求包含k个不同字符的子串集合
     * Given a very long String, find how many substrings with K distinct characters are contained in this long string.
     "abcbba", k=3 -> "abc" -> answer
     */

    public List<String> findSubstringWithKDistinctChars(String s, int k) {
        List<String> res = new ArrayList<>();
        if (k <= 0 || s.isEmpty() || s.length() < k) return res;

        HashMap<Character, Integer> hMap = new HashMap<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (hMap.containsKey(c)) {
                int newLeft = Math.max(l, hMap.get(c) + 1);
                while (l + k - 1< newLeft) {
                    res.add(s.substring(l, l+k));
                    l++;
                }
            }
            hMap.put(c, r);
            r++;
        }
        while (l + k - 1 < r) {
            res.add(s.substring(l, l+k));
            l++;
        }

        return res;
    }

    public List<String> findAllSubstring(String s, int k) {
        List<String> res = new ArrayList<>();
        if (k <= 0 || s.isEmpty() || s.length() < k) return res;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+k; j <= s.length(); j++) {
                String ss = s.substring(i ,j);
                if (ss.length() == k && isUniqueString(ss)) res.add(ss);
            }
        }

        return res;
    }

    private boolean isUniqueString(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        BSTNodeDistance solu = new BSTNodeDistance();

//        int[] values = {5,6,3,1,2,4};
        int[] values = {1, 1, 1};
        int n1 = 1;
        int n2 = 1;
        int distance = solu.bstDistance(values, n1, n2);
        StdOut.println("distance = " + distance);


        //
        //String s = "abcabcabc";
//        String s = "abcdefg";
//        int k = 4;
//        List<String> res = solu.findSubstringWithKDistinctChars(s, k);
//        Utility.printStringList(res);
//
//        List<String> benchmark = solu.findAllSubstring(s, k);
//        Utility.printStringList(benchmark);

    }

}
