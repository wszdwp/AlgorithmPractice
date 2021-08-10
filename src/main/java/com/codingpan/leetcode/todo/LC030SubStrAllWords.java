package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;
// You are given a string, s,
// and a list of words, words, that are all of the same length.
// Find all starting indices of substring(s) in s that
// is a concatenation of each word in words exactly
// once and without any intervening characters.
//
// For example, given:
// s: "barfoothefoobarman"
// words: ["foo", "bar"]
//
// You should return the indices: [0,9].
// (order does not matter).

public class LC030SubStrAllWords {
  //    public List<Integer> findSubstring(String s, String[] words) {
  //        List<String> res = new ArrayList<String>();
  //		getAllPermutation(words, 0, new StringBuilder(), new StringBuilder(), res);
  //        return new LinkedList<Integer>();
  //    }
  //
  //    public static void getAllPermutation(String[] words, int idx, StringBuilder soFar,
  // StringBuilder rest, List<String> permutations) {
  //    	if (idx == words.length) {
  //    		permutations.add(soFar.toString()+rest.toString());
  //		} else {
  //    		for (int i = idx; i+3 < words.length; i+=3) {
  //	    		String w = words[i];
  //	    		soFar.append(w);
  //				rest.delete(0, w.length());
  //				getAllPermutation(words, i+3, soFar, rest, permutations);
  //				rest.insert(0, w);
  //				soFar.delete(soFar.length()-w.length(), soFar.length());
  //			}
  //    	}
  //    }

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    final Set<String> wordSet = getWordSet(words);
    int len = words[0].length();

    return res;
  }

  //	private void helper(String s, int start, int len, Set<String> wordSet, List<Integer> res) {
  //		if (start + len > s.length()) {
  //			if (wordSet.isEmpty()) {
  //				res.add(start);
  //			}
  //		} else {
  //			if (wordSet.isEmpty()) {
  //				res.add(start);
  //			} else {
  //				for (int i = start; i + len <= s.length(); i++) {
  //					String word = s.substring(i, i + len);
  //					if (wordSet.contains(word)) {
  //						wordSet.remove(word);
  //						helper(s, i + len, len, wordSet, res);
  //						wordSet.add(word);
  //					}
  //				}
  //			}
  //		}
  //
  //	}

  private Set<String> getWordSet(String[] words) {
    Set<String> wordSet = new HashSet<>();
    for (String w : words) wordSet.add(w);
    return wordSet;
  }

  public static void main(String[] args) {
    LC030SubStrAllWords solu = new LC030SubStrAllWords();
    String[] words = {"foo", "bar"};
    String s = "barfoothefoobarman";

    StdOut.println(solu.findSubstring(s, words));

    //    	ArrayList<String> permutation = new ArrayList<String>();
    //    	StringBuilder soFar = new StringBuilder();
    //    	StringBuilder rest = new StringBuilder();
    //    	for (String w : words) {
    //    		rest.append(w);
    //		}
    //    	getAllPermutation(words, 0, soFar, rest, permutation);
    //    	System.out.println("permutation " + permutation);
  }
}
