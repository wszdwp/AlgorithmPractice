package com.codingpan.leetcode.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * [30. Substring with Concatenation of All
 * Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/#/description)
 *
 * <p>You are given a string, s, and a list of words, words, that are all of the same length. Find
 * all starting indices of substring(s) in s that is a concatenation of each word in words exactly
 * once and without any intervening characters.
 *
 * <p>For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 *
 * <p>You should return the indices: [0,9]. (order does not matter).
 *
 * <p>Subscribe to see which companies asked this question.
 *
 * @author pan
 */
public class LeetCodeString {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.isEmpty() || words.length == 0) return res;

        int wordLen = words[0].length();
        int windowSize = words.length * wordLen;
        HashMap<String, Integer> hMap = new HashMap<String, Integer>();
        for (String w : words) {
            if (hMap.containsKey(w)) {
                hMap.put(w, hMap.get(w) + 1);
            } else {
                hMap.put(w, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            String wd = s.substring(i, i + wordLen);
        }

        return res;
    }
}
