package com.codingpan.amazon;

import com.codingpan.leetcode.util.Utility;

import java.util.*;

public class SubStringWithKDistinctChars {
    /**
     * 给定一个string 和K值，求包含k个不同字符的子串集合 Given a very long String, find how many substrings with K
     * distinct characters are contained in this long string. "abcbba", k=3 -> "abc" -> answer
     */
    public List<String> findSubstringWithKDistinctChars(String s, int k) {
        List<String> res = new ArrayList<>();
        if (k <= 0 || s.isEmpty() || s.length() < k) return res;

        HashMap<Character, Integer> hMap = new HashMap<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (hMap.containsKey(c)) {
                int newLeft = Math.max(l, hMap.get(c) + 1);
                while (l + k - 1 < newLeft) {
                    res.add(s.substring(l, l + k));
                    l++;
                }
            }
            hMap.put(c, r);
            r++;
        }
        while (l + k - 1 < r) {
            res.add(s.substring(l, l + k));
            l++;
        }

        return res;
    }

    public List<String> findAllSubstring(String s, int k) {
        List<String> res = new ArrayList<>();
        if (k <= 0 || s.isEmpty() || s.length() < k) return res;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + k; j <= s.length(); j++) {
                String ss = s.substring(i, j);
                if (ss.length() == k && isUniqueString(ss)) res.add(ss);
            }
        }

        return res;
    }

    public List<String> findAllSubstring2(String s, int k) {
        List<String> res = new ArrayList<>();
        if (k <= 0 || s.isEmpty() || s.length() < k) return res;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String ss = s.substring(i, j);
                if (ss.length() >= k && isUniqueString(ss)) res.add(ss);
            }
        }

        return res;
    }

    private boolean isUniqueString(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    //    public List<Integer> findAllKSub(String s, int k) {
    //        List<Integer> result = new LinkedList<>();
    //        if(k> s.length()) return result;
    //        Map<Character, Integer> map = new HashMap<>();
    //        for(char c : s.toCharArray()){
    //            if (map.containsKey(c)) {
    //                map.put(c, map.get(c) + 1);
    //            } else {
    //                map.put(c, 1);
    //            }
    //        }
    //        int counter = map.size();
    //
    //        int begin = 0, end = 0;
    //        int head = 0;
    //        int len = Integer.MAX_VALUE;
    //
    //        while(end < s.length()){
    //            char c = s.charAt(end);
    //            if(map.containsKey(c) ){
    //                map.put(c, map.get(c)-1);
    //                if(map.get(c) == 0) counter--;
    //            }
    //            end++;
    //
    //            while(counter == 0){
    //                char tempc = s.charAt(begin);
    //                if(map.containsKey(tempc)){
    //                    map.put(tempc, map.get(tempc) + 1);
    //                    if(map.get(tempc) > 0){
    //                        counter++;
    //                    }
    //                }
    //                if(end-begin == t.length()){
    //                    result.add(begin);
    //                }
    //                begin++;
    //            }
    //
    //        }
    //        return result;
    //    }

    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubStringWithKDistinctChars solu = new SubStringWithKDistinctChars();

        String s = "abcdecabc";
        // String s = "abcdefg";
        int k = 3;
        List<String> res = solu.findSubstringWithKDistinctChars(s, k);
        Utility.printList(res);

        List<String> benchmark = solu.findAllSubstring(s, k);
        Utility.printList(benchmark);

        List<String> benchmark2 = solu.findAllSubstring2(s, k);
        Utility.printList(benchmark2);
    }
}
