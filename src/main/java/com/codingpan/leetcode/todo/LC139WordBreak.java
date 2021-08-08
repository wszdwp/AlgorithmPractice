package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class LC139WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
//        return canBreak(s, dict);
        boolean[] mark = new boolean[s.length()];
        return canBreakMemory(s, dict, mark);
    }

    private boolean canBreak(String s, Set<String> dict) {
        if (s.length()== 0) {
            return true;
        } else {
            for (int i = 0; i <= s.length(); i++) {
                String word = s.substring(0, i);
                if (dict.contains(word) && canBreak(s.substring(i), dict)) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean canBreakMemory(String s, Set<String> dict, boolean[] mark) {
        if (s.length()== 0) {
            return true;
        } else {
            for (int i = 0; i <= s.length(); i++) {
                String word = s.substring(0, i);
                if (dict.contains(word) && (mark[i] || canBreakMemory(s.substring(i), dict, mark))) {
                    mark[i] = true;
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LC139WordBreak solu = new LC139WordBreak();

        String s = "aaab";
        Set<String> dict = new HashSet<>();
        dict.add("b");
        dict.add("aa");
        StdOut.println(solu.wordBreak(s, dict));
    }

}
