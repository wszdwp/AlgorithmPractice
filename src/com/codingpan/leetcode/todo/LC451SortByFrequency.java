package com.codingpan.leetcode.todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [451. ]()
 * @author pan
 *
 */
public class LC451SortByFrequency {
	public String frequencySort(String s) {
		char[] charArr = s.toCharArray();
		HashMap<Character, Integer> cMap = new HashMap<Character, Integer>();
		for (int i = 0; i < charArr.length; i++) {
			char c = charArr[i];
			if (cMap.containsKey(c)) {
				cMap.put(c, cMap.get(c) + 1);
			} else {
				cMap.put(c, 1);
			}
		}

		List<Map.Entry<Character, Integer>> myList = new ArrayList<Map.Entry<Character, Integer>>(cMap.entrySet());
		Collections.sort(myList, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
				return e2.getValue().compareTo(e1.getValue());
			} 
		});
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : cMap.entrySet()) {
			int count = entry.getValue();
			while (count > 0) {
				sb.append(entry.getKey());
				count--;
			}
		}

		return new String(sb);
	}

	public static void main(String[] args) {
		LC451SortByFrequency solu = new LC451SortByFrequency();
		String[] strs = {"tree", "cccaaa"};     // Expected: eetr, aaaccc
		for (String s : strs) {
			System.out.println(solu.frequencySort(s));
		}
	}
}

