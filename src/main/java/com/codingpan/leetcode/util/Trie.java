package com.codingpan.leetcode.util;

import edu.princeton.cs.algs4.StdOut;

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    if (word == null) return;
    TrieNode p = root;
    int idx = 0;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      idx = c - 'a';
      if (p.map[idx] == null) {
        p.map[idx] = new TrieNode();
      }
      p = p.map[idx];
      p.path++;
    }
    p.end++;
  }

  public void delete(String word) {
    if (search(word)) {
      TrieNode p = root;
      int idx = 0;
      for (int i = 0; i < word.length(); i++) {
        idx = word.charAt(i) - 'a';
        p.map[idx].path--;
        if (p.map[idx].path == 1) {
          p.map[idx] = null;
          return;
        }
        p = p.map[idx];
      }
      p.end--;
    }
  }

  public boolean search(String word) {
    if (word == null) return false;
    TrieNode p = root;
    int idx = 0;
    for (int i = 0; i < word.length(); i++) {
      idx = word.charAt(i) - 'a';
      if (p.map[idx] == null) {
        return false;
      }
      p = p.map[idx];
    }
    return p.end != 0;
  }

  public int prefixNumber(String word) {
    if (word == null || word.isEmpty()) return 0;
    TrieNode p = root;
    int idx = 0;
    for (int i = 0; i < word.length(); i++) {
      idx = word.charAt(i) - 'a';
      if (p.map[idx] == null) {
        return 0;
      }
      p = p.map[idx];
    }
    return p.path;
  }

  public static void main(String[] args) {
    Trie trieTest = new Trie();
    String[] words = {"abc", "abcd", "abd", "b", "bcd", "efg", "hik"};
    for (String w : words) trieTest.insert(w);
    StdOut.println(trieTest.search("abc"));
    StdOut.println(trieTest.search("abd"));
    StdOut.println(trieTest.prefixNumber("ab"));
    ;
  }
}
