package com.codingpan.amazon;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SubsetsTest {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        res.add(new ArrayList<Integer>(curr));
        subsetHelper(S, 0, curr, res);
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        return res;
    }

    private void subsetHelper(int[] S, int start, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res) {
        for (int i = start; i < S.length; i++) {
            if (i > start && S[i] == S[i-1]) continue;
            curr.add(S[i]);
            res.add(new ArrayList<Integer>(curr));
            subsetHelper(S, i + 1, curr, res);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        SubsetsTest solu = new SubsetsTest();
//        int[] S = {1, 2, 3};
        int[] S = {8, 7, 12, 8};
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = solu.subsets(S);
        int i = 1;
        for (ArrayList<Integer> one : res) {
            StdOut.print(i + ": ");
            Utility.printList(one);
            i++;
        }
    }

}
