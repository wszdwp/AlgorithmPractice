package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class LC386LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int i = 1;
        for (int j = 0; j < n; j++) {
            ans.add(i);
            if (i * 10 <= n) {
                i *= 10;
            } else {
                if (i >= n) i /= 10;
                i += 1;
                while (i % 10 == 0) i /= 10;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 13;
        LC386LexicographicalNumbers solu = new LC386LexicographicalNumbers();
        List<Integer> ans = solu.lexicalOrder(n);
        Utility.printIntList(ans);
    }
}
