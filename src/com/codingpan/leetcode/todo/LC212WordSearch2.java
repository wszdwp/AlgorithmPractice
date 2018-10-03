package com.codingpan.leetcode.todo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC212WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> wSet = new HashSet<>();
        for (String w : words) wSet.add(w);
        boolean[][] mark = new boolean[board.length][board[0].length];
        findWords(board, wSet, mark, ans);
        return ans;
    }

    private void findWords(char[][] bd, Set<String> wSet, boolean[][] mark, List<String> ans) {
        int m = bd.length;
        int n = bd[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!mark[i][j]) {
                    
                }
            }
        }
    }

    public static void main(String[] args) {
        LC212WordSearch2 solu = new LC212WordSearch2();
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
    }
}
