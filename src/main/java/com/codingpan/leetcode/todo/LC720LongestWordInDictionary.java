package com.codingpan.leetcode.todo;

import java.util.HashSet;
import java.util.Set;

public class LC720LongestWordInDictionary {
  // 720. Longest Word in Dictionary
  public String longestWord(String[] words) {
    String ans = "";

    Set<String> wordSet = new HashSet<String>();
    for (String w : words) {
      wordSet.add(w);
    }

    for (String w : words) {
      if (isValidWord(w, wordSet)) {
        System.out.println(w);
        if (w.length() > ans.length()) {
          ans = w;
        } else if (w.length() == ans.length() && w.compareTo(ans) > 0) {
          ans = w;
        }
      }
    }

    return ans;
  }

  private boolean isValidWord(String word, Set<String> mySet) {
    for (int i = 1; i < word.length(); i++) {
      String prefix = word.substring(0, i);
      if (mySet.contains(prefix)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    LC720LongestWordInDictionary test = new LC720LongestWordInDictionary();
    String[] words1 = {"w", "wo", "wor", "worl", "world"}; // world
    String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"}; // apple

    System.out.println("world : " + test.longestWord(words1));
    System.out.println("apple : " + test.longestWord(words2));
  }
}
