package com.codingpan.contests;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ctx99 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            StdOut.println(Arrays.toString(count));
            seen.add(Arrays.toString(count));
        }
        StdOut.println("-------");
        for(String s : seen) {
            StdOut.print(s + " ");
            StdOut.println();
        }
        return seen.size();
    }

    public static void main(String[] args) {
        Ctx99 solu = new Ctx99();
        String[][] test = {
                {"a","b","c","a","c","c"},                  // 3 groups ["a","a"], ["b"], ["c","c","c"]
                {"aa","bb","ab","ba"},                      // 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
                {"abc","acb","bac","bca","cab","cba"},      // 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
                {"abcd","cdab","adcb","cbad"}               // 1 group ["abcd","cdab","adcb","cbad"]
        };
        for (String[] A : test) {
            int res = solu.numSpecialEquivGroups(A);
            StdOut.println(res);
        }
    }
}
