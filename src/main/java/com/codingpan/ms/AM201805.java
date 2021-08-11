package com.codingpan.ms;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AM201805 {
    public List<String> reorderLines(int size, List<String> logs) {
        List<String> words = new ArrayList<>();
        List<String> nums = new ArrayList<>();

        for (String log : logs) {
            String[] sentence = log.split(" ");
            try {
                int seqNo = Integer.parseInt(sentence[0]);
                nums.add(log);
            } catch (NumberFormatException e) {
                words.add(log);
            }
        }
        Collections.sort(
                words,
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String[] s1 = o1.split(" ");
                        String[] s2 = o2.split(" ");
                        return s1[0].compareTo(s2[0]);
                    }
                });
        Collections.sort(
                nums,
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String[] s1 = o1.split(" ");
                        String[] s2 = o2.split(" ");
                        return s1[0].compareTo(s2[0]);
                    }
                });
        List<String> res = new ArrayList<>();
        for (String w : words) res.add(w);
        for (String n : nums) res.add(n);

        return res;
    }

    public static void main(String[] args) {
        AM201805 solu = new AM201805();
        List<String> logs = new ArrayList<>();
        String[] logFile = {
                "e this is a com.codingpan.test",
                "8 88 60 71 29",
                "c this is a test2",
                "9 23 24 64",
                "a this is a test3",
                "1 123 224 4"
        };
        for (String l : logFile) logs.add(l);

        List<String> sorted = solu.reorderLines(logFile.length, logs);
        for (String log : sorted) StdOut.println(log);
    }
}
