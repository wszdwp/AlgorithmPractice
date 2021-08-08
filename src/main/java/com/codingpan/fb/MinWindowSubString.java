package com.codingpan.fb;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {
    public String minWindow1(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            ++map[c];
        }

        int start = 0, end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map[c] > 0) --count;
            --map[c];
            ++end;
            while (count == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                ++map[c2];
                if (map[c2] > 0) ++count;
                ++start;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public String minWindow2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        int start = 0, end = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE, count = t.length();
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map.containsKey(c1)) {
                if (map.get(c1) > 0) --count;
                map.put(c1, map.get(c1) - 1);
            } else {
                map.put(c1, -1);
            }
            ++end;
            while (count == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                } else {
                    map.put(c2, 1);
                }
                if (map.get(c2) > 0) ++count;
                ++start;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    private void testUtil(String[] ss, String[] tt) {
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            String t = tt[i];
            String a = this.minWindow1(s, t);
            String b = this.minWindow2(s, t);

            StdOut.println("ans(" + a + ") " + b + (a.equalsIgnoreCase(b) ? " pass " : " fail"));

        }
    }

    public static void main(String[] args) {
        MinWindowSubString solu = new MinWindowSubString();
        String[] ss = {"ADOBECODEBANC", "bba"};
        String[] tt = {"ABC", "ab"};
        solu.testUtil(ss, tt);
    }


}
