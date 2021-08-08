package com.codingpan.ggPhone;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class SearchProblems {
    // 问题2: 给一个只包含0， 1， ＊ 的String，将所有的＊ 替换成0 或者 1， 返回所有的可能行。
    // For example, “00*1*0” => {“001100”, “001110”, “000110”, “000100”｝

    public List<String> allPossibleStrings(String s) {
        List<String> ans = new ArrayList<>();
        // dfs(s, 0, new StringBuilder(), ans);
        dfs(s.toCharArray(), 0, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(char[] arr, int start, StringBuilder sb, List<String> ans) {
        if (sb.length() == arr.length) {
            ans.add(new String(sb));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == '*') {
                sb.append('0');
                dfs(arr, i + 1, sb, ans);
                sb.deleteCharAt(sb.length() - 1);

                sb.append('1');
            } else {
                sb.append(arr[i]);
            }
            dfs(arr, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void dfs(String s, int start, StringBuilder sb, List<String> ans) {
        if (start == s.length() && sb.length() == s.length()) {
            ans.add(new String(sb));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(start) == '*') {
                sb.append('0');
                dfs(s, i + 1, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
                sb.append('1');
                dfs(s, i + 1, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
                dfs(s, i + 1, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SearchProblems solu = new SearchProblems();
        String s = "00*1*0";
        double t1 = System.currentTimeMillis();
        List<String> ans = solu.allPossibleStrings(s);
        double t2 = System.currentTimeMillis();
        StdOut.println((t2 - t1));

        Utility.printList(ans);
    }
}
