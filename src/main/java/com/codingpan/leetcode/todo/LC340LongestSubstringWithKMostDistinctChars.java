package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

public class LC340LongestSubstringWithKMostDistinctChars {
    /**
     * Given a string, find the length of the longest substring T that contains at most k distinct
     * characters.
     *
     * <p>Example 1:
     *
     * <p>Input: s = "eceba", k = 2 Output: 3 Explanation: T is "ece" which its length is 3. Example
     * 2:
     *
     * <p>Input: s = "aa", k = 1 Output: 2 Explanation: T is "aa" which its length is 2.
     *
     * @param s
     * @param k
     * @return
     */
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int ans = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() <= k) {
                ans = Math.max(ans, i - start + 1);
            } else {
                while (map.size() > k) {
                    char l = s.charAt(start);
                    int count = map.get(l);
                    if (count == 1) {
                        map.remove(l);
                    } else {
                        map.put(l, map.get(l) - 1);
                    }
                    start++;
                }
            }
        }

        StdOut.println("substring " + s.substring(start, start + ans));
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaabceddd";
        int k = 3;
        int ans = lengthOfLongestSubstringKDistinct(s, k);
        StdOut.println("ans (exp: 7) " + ans);
    }
}
