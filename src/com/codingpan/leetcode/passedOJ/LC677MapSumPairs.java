package com.codingpan.leetcode.passedOJ;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC677MapSumPairs {
    Map<String, Integer> dMap;
    Map<String, List<String>> kMap;

    /** Initialize your data structure here. */
    public LC677MapSumPairs() {
        dMap = new HashMap<String, Integer>();
        kMap = new HashMap<String, List<String>>();
    }

    public void insert(String key, int val) {
        dMap.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            String prefixKey = key.substring(0, i);
            if (!kMap.containsKey(prefixKey)) {
                List<String> keys = new ArrayList<>();
                keys.add(key);
                kMap.put(prefixKey, keys);
            } else {
                List<String> keys = kMap.get(prefixKey);
                if (!keys.contains(key)) {
                    keys.add(key);
                    kMap.put(prefixKey, keys);
                }
            }
        }
    }

    public int sum(String prefix) {
        int sum = 0;
        if (!kMap.containsKey(prefix)) return sum;

        List<String> keys = kMap.get(prefix);
        for (String key : keys) {
            sum += dMap.get(key);
        }
        return sum;
    }

    public static void main(String[] args) {
        LC677MapSumPairs solu = new LC677MapSumPairs();
        solu.insert("aa", 3);
        StdOut.println(solu.sum("a"));
        solu.insert("aa", 2);
        StdOut.println(solu.sum("a"));
    }
}
