package com.codingpan.amazon;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class OnSiteCareerCup {
    public String findLongestUniqueSubstring(String[] words) {
        String longestUniqueSubString = "";
        for (String word : words) {
            String uniqueWord = longestUniqueSubString(word);
            if (uniqueWord.length() > longestUniqueSubString.length()) {
                longestUniqueSubString = uniqueWord;
            }
        }

        return longestUniqueSubString;
    }

    private String longestUniqueSubString(String word) {
        if (word.length() <= 1) return word;

        String longestSubString = "";
        HashMap<Character, Integer> cMap = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < word.length()) {
            char c = word.charAt(r);
            if (cMap.containsKey(c)) {
                l = Math.max(l, cMap.get(c) + 1);
            }
            cMap.put(c, r);
            if (longestSubString.length() < word.substring(l, r + 1).length()) {
                longestSubString = word.substring(l, r + 1);
            }
            r++;
        }

        return longestSubString;
    }

    public static void main(String[] args) {
        OnSiteCareerCup solu = new OnSiteCareerCup();
        String[] words = {"wolld", "hellowrld", "bob"};
        StdOut.println(solu.findLongestUniqueSubstring(words));
    }
}
