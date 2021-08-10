package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class LC212WordSearch2 {
  public List<String> findWords(final char[][] bd, String[] words) {
    List<String> ans = new ArrayList<>();
    TrieNode root = buildTrie(words);
    int m = bd.length;
    int n = bd[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(bd, i, j, root, ans);
      }
    }
    return ans;
  }

  private void dfs(char[][] bd, final int i, final int j, TrieNode p, List<String> ans) {
    if (i < 0 || j < 0 || i >= bd.length || j >= bd[0].length) return;
    char c = bd[i][j];
    int index = c - 'a';
    if (c == '#' || p.next[index] == null) return;
    p = p.next[index];
    if (p.word != null) {
      ans.add(p.word);
      p.word = null;
    }
    bd[i][j] = '#';
    dfs(bd, i + 1, j, p, ans);
    dfs(bd, i - 1, j, p, ans);
    dfs(bd, i, j + 1, p, ans);
    dfs(bd, i, j - 1, p, ans);
    bd[i][j] = c;
  }

  class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
  }

  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode p = root;
      for (char c : word.toCharArray()) {
        int i = c - 'a';
        if (p.next[i] == null) {
          p.next[i] = new TrieNode();
        }
        p = p.next[i];
      }
      p.word = word;
    }
    return root;
  }

  public static void main(String[] args) {
    LC212WordSearch2 solu = new LC212WordSearch2();
    char[][] board = {
      {'o', 'a', 'a', 'n'},
      {'e', 't', 'a', 'e'},
      {'i', 'h', 'k', 'r'},
      {'i', 'f', 'l', 'v'}
    };
    String[] words = {"oath", "pea", "eat", "rain"};
    List<String> res = solu.findWords(board, words);
    Utility.printList(res);
  }
}
