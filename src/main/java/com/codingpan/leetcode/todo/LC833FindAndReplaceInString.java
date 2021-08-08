package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC833FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        for (int i = 0; i < indexes.length; i++) {
            String src = sources[i];
            String tar = targets[i];
            if (S.substring(indexes[i], indexes[i] + src.length()).equals(src)) {
                sb.append(S.substring(pos, indexes[i]));
                sb.append(tar);
                pos = pos + indexes[i] + src.length();
            }
            if (pos >= S.length()) {
                break;
            }
        }
        if (pos <= S.length()) {
            sb.append(S.substring(pos));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LC833FindAndReplaceInString solu = new LC833FindAndReplaceInString();

//        String S = "abcd";
//        int[] indexes = {0, 2};
//        String[] sources = {"ab", "ec"};
//        String[] sources = {"a", "cd"};
//        String[] targets = {"eeee", "ffff"};

        String S = "wqzzcbnwxc";
        int[] indexes = {5,2,7};
        String[] sources = {"bn","zzc","wxc"};
        String[] targets = {"t","lwb","nee"};

        StdOut.println(solu.findReplaceString(S, indexes, sources, targets));
    }
}
