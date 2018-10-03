package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class LC828UniqueLetterString {
    public int uniqueLetterString(String S) {
        final int MOD = (int)Math.pow(10, 9) + 7;
        Set<String> pre = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            Set<String> temp = new HashSet<>();
            temp.add(S.substring(i, i+1));
            for (String s : pre) temp.add(s + S.substring(i, i+1));
            pre = temp;
            res.addAll(temp);
        }
        int totalCount = 0;
        for (String one : res) {
            int count = uniqueCharCount(one.toCharArray()) % MOD;
            StdOut.println(one + " " + count);
            totalCount += count;
        }
        return totalCount;
    }

    private int uniqueCharCount(char[] arr) {
        int count = 0;
        int[] cMap = new int[26];
        for (int i = 0; i < arr.length; i++) {
            cMap[arr[i] - 'A'] = 1;
        }
        for (int i = 0; i < 26; i++) count += cMap[i] ;
        return count;
    }

    public static void main(String[] args) {
        LC828UniqueLetterString solu = new LC828UniqueLetterString();
        String S = "BABABBABAA";
        StdOut.println(solu.uniqueLetterString(S));
    }
}
