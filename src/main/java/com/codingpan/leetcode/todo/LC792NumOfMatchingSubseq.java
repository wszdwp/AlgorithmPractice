package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC792NumOfMatchingSubseq {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (isMatchBruteForce(S, word)) {
                ans += 1;
            }
        }
        return ans;
    }

    private boolean isMatchBruteForce(String s, String w) {
        int start = 0;
        for (int i = 0; i < w.length(); i++) {
            boolean found = false;
            for (int j = start; j < s.length(); j++) {
                if (w.charAt(i) == s.charAt(j)) {
                    found = true;
                    start = j + 1;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LC792NumOfMatchingSubseq solu = new LC792NumOfMatchingSubseq();
        String[] strs = {"abcde"};
        String[][] wordsArr = {{"a", "bb", "acd", "ace"}};
        int[] ans = {3};
        for (int i = 0; i < ans.length; i++) {
            int res = solu.numMatchingSubseq(strs[i], wordsArr[i]);
            StdOut.print("ans is " + res);
            StdOut.println(" expected " + ans[i] + (res == ans[i] ? " pass " : " failed"));
        }
    }
}
