package com.codingpan.ms;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OTS20190803 {
    public int solution(String S) {
        // write your code in Java SE 8
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            count[c - 'a'] += 1;
        }
        Arrays.sort(count);
        Set<Integer> seen = new HashSet<>();
        int ans = 0;
        for (int i = 25; i >= 0; i--) {
            if (count[i] > 0) {
                if (seen.contains(count[i])) {
                    ans += seen.contains(count[i] - 1) ? count[i] : 1;
                    seen.add(count[i] - 1);
                }
                seen.add(count[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        OTS20190803 solu = new OTS20190803();

        String[] ss = {"ccaaffddecee"};
        for (String s : ss) {
            int ans = solu.solution(s);
            StdOut.println("ans " + ans);
        }
    }
}
