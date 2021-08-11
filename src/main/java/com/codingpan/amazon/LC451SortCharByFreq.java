package com.codingpan.amazon;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class LC451SortCharByFreq {
    //    public String frequencySort(String s) {
    //        Map<Character, Integer> cMap = getCharFreqMap(s);
    //        List<Map.Entry<Character, Integer>> myList = new ArrayList<>(cMap.entrySet());
    //
    //        Collections.sort(myList, new Comparator<Map.Entry<Character, Integer>>() {
    //            @Override
    //            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer>
    // o2) {
    //                return o2.getValue() - o1.getValue();
    //            }
    //        });
    //
    //        StringBuilder sb = new StringBuilder();
    //        for (Map.Entry<Character, Integer> entry: myList) {
    //            int count = entry.getValue();
    //            char c = entry.getKey();
    //            while (count > 0) {
    //                sb.append(c);
    //                count--;
    //            }
    //        }
    //
    //        return new String(sb);
    //    }
    //
    //    private Map<Character, Integer> getCharFreqMap(String s) {
    //        Map<Character, Integer> cMap = new HashMap<>();
    //        for (char c : s.toCharArray()) {
    //            if (cMap.containsKey(c)) {
    //                cMap.put(c, cMap.get(c)+1);
    //            } else {
    //                cMap.put(c, 1);
    //            }
    //        }
    //        return cMap;
    //    }

    public String frequencySort(String s) {
        int[] countArr = new int[128];
        for (char c : s.toCharArray()) {
            countArr[c - 'a'] += 1;
        }
        Arrays.sort(countArr);
        StringBuilder sb = new StringBuilder();
        for (int i = 127; i >= 0; i--) {
            if (countArr[i] != 0) {
                char c = (char) (i - 'a');
                int count = countArr[i];
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        LC451SortCharByFreq solu = new LC451SortCharByFreq();
        String s = "tree"; // eert or eetr
        // String s = "cccaaa";    //cccaaa, or aaaccc
        // String s = "Aabb";    //bbAa or bbaA

        StdOut.println(solu.frequencySort(s));
    }
}
