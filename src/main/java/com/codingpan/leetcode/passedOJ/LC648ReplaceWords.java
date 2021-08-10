package com.codingpan.leetcode.passedOJ;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

public class LC648ReplaceWords {
  public String replaceWords(List<String> dict, String sentence) {
    TrieNode root = buildTrie(dict);

    StringBuilder sb = new StringBuilder();
    String[] words = sentence.trim().split(" ");
    for (String word : words) {
      sb.append(searchWord(word, root));
      sb.append(" ");
    }
    return sb.toString().trim();
  }

  private String searchWord(String word, TrieNode root) {
    TrieNode p = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = (int) (word.charAt(i) - 'a');
      if (p.word != null) return p.word;
      if (p.next[idx] == null) return word;
      p = p.next[idx];
    }
    return word;
  }

  class TrieNode {
    public TrieNode[] next = new TrieNode[26];
    public String word;
  }

  private TrieNode buildTrie(List<String> dict) {
    TrieNode root = new TrieNode();
    for (String word : dict) {
      TrieNode p = root;
      for (int i = 0; i < word.length(); i++) {
        int idx = (int) (word.charAt(i) - 'a');
        if (p.next[idx] == null) {
          p.next[idx] = new TrieNode();
        }
        p = p.next[idx];
      }
      p.word = word;
    }

    return root;
  }

  public static void main(String[] args) {
    LC648ReplaceWords solu = new LC648ReplaceWords();

    String[] values = {"cat", "bat", "rat"};
    List<String> dict = Arrays.asList(values);
    String sentence = "the cattle was rattled by the battery";
    // Output: "the cat was rat by the bat"

    TrieNode root = solu.buildTrie(dict);
    StdOut.println(sentence);
    StdOut.println(solu.replaceWords(dict, sentence));
  }
}
