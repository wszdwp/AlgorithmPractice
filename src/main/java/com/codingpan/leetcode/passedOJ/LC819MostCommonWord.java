package com.codingpan.leetcode.passedOJ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[!?',;.]+", "").split(" ");
        Set<String> wordSet = new HashSet<>();
        for (String w : banned) {
            wordSet.add(w);
        }

        Map<String, Integer> wordsCount = new HashMap<>();
        String mostFreqWord = "";
        int maxCount = 0;
        for (String w : words) {
            String word = w.trim().toLowerCase();
            if (!wordSet.contains(word)) {
                if (wordsCount.containsKey(word)) {
                    int count = wordsCount.get(word) + 1;
                    if (count > maxCount) {
                        mostFreqWord = word;
                        maxCount = count;
                    }
                    wordsCount.put(word, count);
                } else {
                    wordsCount.put(word, 1);
                    if (1 > maxCount) {
                        mostFreqWord = word;
                        maxCount = 1;
                    }
                }
            }
        }
        return mostFreqWord;
    }

    public static void main(String[] args) {
        LC819MostCommonWord solu = new LC819MostCommonWord();
        String paragraph = "Bob hit a ball,! the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String res = solu.mostCommonWord(paragraph, banned);
        System.out.println(res);
    }
}
