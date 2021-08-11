package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC884DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        if (K < 1 || S.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                int repeats = c - '0';
                String temp = sb.toString();
                while (repeats - 1 > 0) {
                    sb.append(temp);
                    repeats--;
                }
            } else {
                sb.append(c);
            }
            if (sb.length() >= K) {
                return sb.substring(K - 1, K);
            }
        }
        return sb.substring(K - 1, K);
    }

    public static void main(String[] args) {
        LC884DecodedStringAtIndex solu = new LC884DecodedStringAtIndex();
        String S = "a2b3c4d5e6f7g8h9";
        int K = 10;

        S = "y959q969u3hb22odq595";
        K = 222280369;
        StdOut.println(solu.decodeAtIndex(S, K));
    }
}
