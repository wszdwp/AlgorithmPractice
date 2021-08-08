package com.codingpan.amazon;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class OA2 {
    List<String> retriveMostFreqUsedWords(String literalText, List<String> wordsToExcluded) {
        List<String> res = new ArrayList<>();
        if (literalText == null || wordsToExcluded == null) return res;
        if (literalText.isEmpty() || wordsToExcluded.size() == 0) return res;

        String[] words = literalText.trim().split("\\W+");
        Utility.printList(Arrays.asList(words));

        Set<String> excludes = new HashSet<String>();
        for (String excludeWord : wordsToExcluded) {
            String wd = getLowerCaseWord(excludeWord);
            excludes.add(wd);
        }

        Map<String, Integer> freqMap = new HashMap<>();
        int maxCount = 0;
        for (String word : words) {
            String wd = getLowerCaseWord(word);
            if (!excludes.contains(wd)) {
                if (freqMap.containsKey(wd)) {
                    int count = freqMap.get(wd) + 1;
                    freqMap.put(wd, count);
                    maxCount = Math.max(maxCount, count);
                } else {
                    freqMap.put(wd, 1);
                    maxCount = Math.max(maxCount, 1);
                }
            }
        }

        StdOut.println("maxCount = " + maxCount);

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                res.add(entry.getKey());
            }
        }

        return res;
    }

    private String getLowerCaseWord(String word) {
        if (word == null || word.isEmpty()) return word;
        return word.replaceAll("\\W", "").toLowerCase();
    }

    public static void main(String[] args) {
        OA2 oa2Test = new OA2();
        String literalText = "Jack   and Jill went to the market to buy bread and cheese. " +
                "Cheese is Jack's and Jill's favorite food.";
        String[] words = {"and", "he", "the", "to", "is", "Jack", "Jill"};
        List<String> wordsToExcluded = Arrays.asList(words);
        List<String> topWords = oa2Test.retriveMostFreqUsedWords(literalText, wordsToExcluded);
        Utility.printList(topWords);
    }
}
