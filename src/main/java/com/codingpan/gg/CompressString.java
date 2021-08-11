package com.codingpan.gg;

import edu.princeton.cs.algs4.StdOut;

public class CompressString {
    // aaa  -> 3a
    // aa -> 2a
    // a -> 1a
    // abcbbbed -> abc3bed
    // 3333aaa222111 -> {'4', '3', '3', 'a', '3', '2', '3', '1'};
    private char[] compressed;
    int N = 10;

    public CompressString() {
        compressed = new char[N];
    }

    public String compress(String s) {
        compressed = new char[compressedLen(s)];
        char c = s.charAt(0);
        int count = 1;
        int idx = 0;
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                count++;
            } else {
                compressed[idx++] = (char) (count + '0');
                compressed[idx++] = c;
                c = s.charAt(i);
                count = 1;
            }
            if (i == s.length() - 1) {
                compressed[idx++] = (char) (count + '0');
                compressed[idx++] = c;
            }
        }
        return new String(compressed);
    }

    /**
     * The Challenge In this exercise, you're going to decompress a compressed string. Your input is a
     * compressed string of the format number[string] and the decompressed output form should be the
     * string written number times. For example: The input 3[abc]4[ab]c
     *
     * <p>Would be output as abcabcabcababababc
     *
     * <p>Other rules Number can have more than one digit. For example, 10[a] is allowed, and just
     * means aaaaaaaaaa
     *
     * <p>One repetition can occur inside another. For example, 2[3[a]b] decompresses into aaabaaab
     *
     * <p>Characters allowed as input include digits, small English letters and brackets [ ].
     *
     * <p>Digits are only to represent amount of repetitions.
     *
     * <p>Letters are just letters.
     *
     * <p>Brackets are only part of syntax of writing repeated substring. Input is always valid, so no
     * need to check its validity.
     *
     * @param s
     * @return
     */
    public String decompress(String s) {
        int l = 0;
        int n = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']' || i == s.length() - 1) {
                if (i == s.length() - 1) {
                    sb.append(getRepeatedString(s.substring(l), n));
                } else {
                    sb.append(getRepeatedString(s.substring(l, i), n));
                }
                n = 0;
                l = i + 1;
            } else if (c == '[') {
                l = i + 1;
            } else if (Character.isDigit(c)) {
                n = n * 10 + Character.getNumericValue(c);
            } else if (Character.isAlphabetic(c)) {

            }
        }
        return sb.toString();
    }

    private String getRepeatedString(String s, int repeats) {
        if (repeats <= 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeats; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    private int compressedLen(String s) {
        if (s == null || s.length() == 0) return 0;
        char c = s.charAt(0);
        int len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (c != s.charAt(i)) {
                c = s.charAt(i);
                ++len;
            }
        }

        return 2 * len;
    }

    public static void main(String[] args) {
        CompressString solu = new CompressString();
        //        String[] strs = {"aaa", "abcd", "abccddee", "edeeeaabbefe"};
        //        int[] expLens = {2, 8, 10, 16};
        //        for (int i = 0; i < strs.length; i++) {
        //            String s = strs[i];
        //            int len = testCompressString.compressedLen(s);
        //            StdOut.println("len = " + len + " exp(" + expLens[i] + ")");
        //            StdOut.println("origial len = " + s.length() + " compressed len = " + len);
        //            StdOut.println("compressed " + s + " = " + testCompressString.compress(s));
        //        }

        // com.codingpan.test decompress
        //        String s = "3[abc]4[ab]c";
        //        String exp = "abcabcabcababababc";
        String s = "2[3[a]b]";
        String exp = "aaabaaab";
        String ans = solu.decompress(s);
        StdOut.println(ans + "  " + ans.equals(exp));
    }
}
