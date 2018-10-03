package com.codingpan.leetcode.passedOJ;

import java.util.ArrayList;
import java.util.List;

public class LC077Combinations {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> combs = new ArrayList<List<Integer>>();
    	if (n <=0 || n < k) return combs;
    	List<Integer> comb = new ArrayList<Integer>();
		combination(n, k, 1, comb, combs);
    	return combs;
    }

    private void combination(int n, int k, int start, List<Integer> comb, List<List<Integer>> combs) {
    	if (comb.size() == k) {
			combs.add(new ArrayList<Integer>(comb));
		} else {
			for (int i = start; i <= n; i++) {
				comb.add(i);
				combination(n, k, i+1, comb, combs);
				comb.remove(comb.size()-1);
			}
		}
	}
    
    public static void main(String[] args) {
    	int n = 4;
    	int k = 2;
    	LC077Combinations sol = new LC077Combinations();
    	List<List<Integer>> res = sol.combine(n, k);
    	System.out.println("res" + res);
    }
}
