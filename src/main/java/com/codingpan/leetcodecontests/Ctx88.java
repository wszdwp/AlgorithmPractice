package com.codingpan.leetcodecontests;

import edu.princeton.cs.algs4.StdOut;

public class Ctx88 {
    public String shiftingLetters(String S, int[] shifts) {
        if (S == null || S.isEmpty() || shifts == null || shifts.length == 0) return S;

        int sum = 0;
        for (int i = 0; i < shifts.length; i++) {
            sum = (sum + shifts[i]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shifts.length; i++) {
            char c = getShiftChar(S.charAt(i), sum);
            sb.append(c);
            sum = sum - shifts[i] % 26;
        }
        return sb.toString();
    }

    private char getShiftChar(char c, int shift) {
        return (char) ((shift - 'a' + c) % 26 + 'a');
    }

    public static void main(String[] args) {
        Ctx88 solu = new Ctx88();
        // rpl
        //        String S = "abc";
        //        int[] shifts = {3, 5, 9};

        // rul
        //        String S = "ruu";
        //        int[] shifts = {26, 9, 17};

        // "wqqwlcjnkphhsyvrkdod"
        String S = "mkgfzkkuxownxvfvxasy";
        int[] shifts = {
                505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950,
                81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837,
                622939912, 116899933, 983296461, 536563513
        };
        StdOut.println(solu.shiftingLetters(S, shifts));
    }
}
