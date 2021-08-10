package com.codingpan.leetcode.todo;

/**
 * [451. ]()
 *
 * @author pan
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

    List<Map.Entry<Character, Integer>> myList =
        new ArrayList<Map.Entry<Character, Integer>>(cMap.entrySet());
    Collections.sort(
        myList,
        new Comparator<Map.Entry<Character, Integer>>() {

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
    String[] strs = {"tree", "cccaaa"}; // Expected: eetr, aaaccc
    for (String s : strs) {
      System.out.println(solu.frequencySort(s));
    }
  }

  //	public String frequencySort(String s) {
  //		Map<Character, Integer> freq = new HashMap<>();
  //		Character[] arr = new Character[s.length()];
  //		for (int i = 0; i < s.length(); i++) {
  //			arr[i] = s.charAt(i);
  //		}
  //
  //		for (char c : arr) {
  //			if (freq.containsKey(c)) {
  //				freq.put(c, freq.get(c) + 1);
  //			} else {
  //				freq.put(c, 1);
  //			}
  //		}
  //
  //		StdOut.println(freq);
  //		Arrays.sort(arr, new MyComparator(freq));
  //
  //		StringBuilder sb = new StringBuilder();
  //		for (char c : arr) {
  //			sb.append(c);
  //		}
  //
  //		return sb.toString();
  //	}
  //
  //	private class MyComparator implements Comparator<Character> {
  //		Map<Character, Integer> freq = new HashMap<>();
  //
  //		public MyComparator(Map<Character, Integer> freq) {
  //			this.freq = freq;
  //		}
  //
  //		@Override
  //		public int compare(Character o1, Character o2) {
  //			int f1 = freq.get(o1);
  //			int f2 = freq.get(o2);
  //			if (f1 == f2) return (int)(o2 - o1);
  //			return f2 - f1;
  //		}
  //	}
  //
  //	public static void main(String[] args) {
  //		LC451SortStringByFreq solu = new LC451SortStringByFreq();
  //
  //		//"eeeeoollvtdc"
  //		String s = "loveleetcode";
  //		StdOut.println(solu.frequencySort(s));
  //	}
}
