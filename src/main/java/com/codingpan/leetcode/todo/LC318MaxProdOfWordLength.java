package com.codingpan.leetcode.todo;

import java.util.HashSet;

/**
 * @author Pan
 * <p>Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters. You may assume that each word will contain
 * only lower case letters. If no such two words exist, return 0. Example 1: Given ["abcw",
 * "baz", "foo", "bar", "xtfn", "abcdef"] Return 16 The two words can be "abcw", "xtfn".
 * <p>Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return 4 The two words can
 * be "ab", "cd".
 * <p>Example 3: Given ["a", "aa", "aaa", "aaaa"] Return 0 No such pair of words.
 * <p>Follow up: Could you do better than O(n2), where n is the number of words?
 */
public class LC318MaxProdOfWordLength {

    public int maxProduct(String[] words) {
        int maxProdOfWdLen = 0;
        int len = words.length;
        if (len < 2) return maxProdOfWdLen;

        HashSet<Character> letters = new HashSet<Character>();
        for (String wd : words) {
            char[] chars = wd.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                letters.add(chars[i]);
            }
        }

        return maxProdOfWdLen;
    }
}
