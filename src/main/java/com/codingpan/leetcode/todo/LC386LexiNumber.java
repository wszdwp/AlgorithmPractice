package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;

import java.util.*;

public class LC386LexiNumber {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        dfs(1, n, ans);
        return ans;
    }

    private void dfs(int i, int n, List<Integer> ans) {
        if (i > n) return;
        ans.add(i);
        dfs(i*10, n, ans);
        if (i % 10 != 9) dfs(i+1, n, ans);
    }

    public List<Integer> lexicalOrderTest(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }
        Collections.sort(ans, new LexiComparator());
        return ans;
    }

    private static class LexiComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return String.valueOf(o1).compareTo(String.valueOf(o2));
        }
    }

    public static void main(String[] args) {
        LC386LexiNumber solu = new LC386LexiNumber();
        int n = 49999;
        List<Integer> ans = solu.lexicalOrder(n);
        Utility.printList(ans);

        List<Integer> testAns = solu.lexicalOrderTest(n);
        Utility.printList(ans);
    }
}
