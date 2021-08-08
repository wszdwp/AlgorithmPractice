package com.codingpan.gg;

import edu.princeton.cs.algs4.StdOut;

public class Compression {
    public String compress(String s) {
        return s;
    }

    public String decompress(String s) {
        StringBuilder sb = new StringBuilder();
//        decompressUtil(s, 0, s.length() - 1, sb);
        decompressUtil(s, 0, 0, sb);
        return sb.toString();
    }

//    private int decompressUtil(char[] s, int l, int r, StringBuilder sb) {
//        if (r - l == 1) {
//            printTest(sb, 1);
//            return 1;
//        }
//        int b = 0;
//        for (int i = l; i < r; i++) {
//            if (s[i] != '[' || s[i] != ']') {
//                sb.append(s[i]);
//                continue;
//            }
//            if (s[i] == '[') ++b;
//            if (s[i] == ')') --b;
//            if (b == 0) {
//                int count1 = decompressUtil(s, l, i, sb);
//                printTest(sb, count1);
//                int count2 = decompressUtil(s, i + 1, r, sb);
//                printTest(sb, count2);
//                return count1 + count2;
//            }
//        }
//        int count = 2 * decompressUtil(s, l + 1, r - 1, sb);
//        printTest(sb, count);
//        return count;
//    }

    private void decompressUtil(String s, int start, int curr, StringBuilder sb) {
        if (start == s.length()) {
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < curr; j++) {
                sb2.append(sb.toString());
            }
            if (curr == 0) sb2.append(sb.toString());
            StdOut.println("end  " + sb2.toString());
            return;
        }

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = Character.getNumericValue(c) + curr * 10;
                continue;
            }
            if (Character.isAlphabetic(c)) {
                sb.append(c);
                continue;
            }
            if (c == '[') {
                sb = new StringBuilder();
                continue;
            }
            else if (c == ']') {  // if (c == ']')
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < curr; j++) {
                    sb2.append(sb.toString());
                }
                StdOut.println("]   " + sb2.toString());
                sb = new StringBuilder();
                decompressUtil(s, i + 1, 0, sb2);
            }
        }
    }

    private void printTest(StringBuilder sb, int count) {
        StringBuilder resSb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            resSb.append(sb.toString());
        }
        StdOut.println(resSb.toString());
    }

//    int score(const string& S, int l, int r) {
//        if (r - l == 1) return 1; // "()"
//        int b = 0;
//        for (int i = l; i < r; ++i) {
//            if (S[i] == '(') ++b;
//            if (S[i] == ')') --b;
//            if (b == 0) // balanced
//                // score("(A)(B)") = score("(A)") + score("(B)")
//                return score(S, l, i) + score(S, i + 1, r);
//        }
//        // score("(A)") = 2 * score("A")
//        return 2 * score(S, l + 1, r - 1);
//    }


    public static void main(String[] args) {
        Compression solu = new Compression();
        String s = "abcabcabcababababc";       // exp: 3[abc]4[ab]c
        String compS = "3[abc]4[ab]c";

        //StdOut.println("compress com.codingpan.test pass: " + solu.compress(s).equals(compS));
        String ans = solu.decompress(compS);
        StdOut.println("decompress " + ans);
        StdOut.println("decompress com.codingpan.test pass: " + ans.equals(s));

    }
}
