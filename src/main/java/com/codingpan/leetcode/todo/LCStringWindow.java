package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class LCStringWindow {
    // 3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int len = 1;
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c) + 1);
                // map.remove(c);
            }
            map.put(c, r);
            len = Math.max(len, r - l + 1);
            r++;
        }

        return len;
    }

    public static void main(String[] args) {
        LCStringWindow solu = new LCStringWindow();
        String s = "abcabcbb";
        // s = "bbbbb";
        // s = "pwwkew";
        // s = "a";
        // s = "";
        // s = "abcd";
        s = "abba";

        StdOut.println(solu.lengthOfLongestSubstring(s));
    }
}
