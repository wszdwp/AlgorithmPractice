package com.codingpan.leetcode.todo;

public class PalindromicProblem {
    public static String longestPalindromicSubstring(String s) {
        String res = s;

        res = bruteForce(s);
        return res;
    }

    private static String bruteForce(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (isPalindromic(subStr)) {
                    if (subStr.length() > (end - start)) {
                        end = j;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, end);
    }

    private static boolean isPalindromic(String s) {
        if (s.length() <= 1) return true;

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "forgeeksskeegfor"; // res = "geeksskeeg"

        System.out.println("Brute force n^3");
        System.out.println(System.currentTimeMillis());
        System.out.println(longestPalindromicSubstring(s));
        System.out.println(System.currentTimeMillis());
    }
}
