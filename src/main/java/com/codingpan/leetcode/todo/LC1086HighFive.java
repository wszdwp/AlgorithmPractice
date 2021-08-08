package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

public class LC1086HighFive {
    private static void insertionSort(int[] scores, int score) {
        int i = scores.length - 1;
        if (score <= scores[i]) return;
        while (i >= 0 && score > scores[i] ) {
            --i;
        }
        ++i;
        int j = scores.length - 1;
        while (j > i) {
            scores[j] = scores[j - 1];
            --j;
        }
        scores[j] = score;
    }

    private static int avg(int[] scores) {
        int sum = 0;
        for (int sc : scores) {
            sum += sc;
        }
        return sum / 5;
    }

    public static void main(String[] args) {
        int[] scores = new int[5];
        for (int sc = 10; sc < 20; sc++) {
            insertionSort(scores, sc);
        }
        insertionSort(scores, 98);
        insertionSort(scores, 54);


        Utility.printArray(scores);

        StdOut.println(avg(scores));
    }
}
