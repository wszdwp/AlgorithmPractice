package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC214ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String r = reverse(s);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String ss = s.substring(0, n - i);
            String rr = r.substring(i);
            StdOut.println(ss + "   " + rr);
            if (ss.equals(rr)) {
                return r.substring(0, i) + s;
            }
        }
        return "";
    }

//    public String shortestPalindrome2(String s) {
//        char[] arr = s.toCharArray();
//        int n = s.length();
//        for (int i = 1; i < n; i++) {
//            if (compare(arr, 0, n - i, n - i, i)) {
//                return getReversedString(arr, i, n - 1) + s;
//            }
//        }
//        return "";
//    }
//
//    private boolean compare(char[] arr, int i, int j, int ri, int rj) {
//        while (i < j && ri > rj) {
//            if (arr[i] != arr[ri]) return false;
//            i++;
//            ri--;
//        }
//        return true;
//    }

    private String getReversedString(char[] arr, int s, int e) {
        StringBuilder sb = new StringBuilder();
        for (int i = e ; i >= s; i--) sb.append(arr[i]);
        return sb.toString();
    }


    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) sb.append(s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        LC214ShortestPalindrome solu = new LC214ShortestPalindrome();
        String s = "aacecaaa";
        StdOut.println(solu.shortestPalindrome(s));
    }
}