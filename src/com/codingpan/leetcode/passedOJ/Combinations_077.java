package com.codingpan.leetcode.passedOJ;

import java.util.ArrayList;
import java.util.List;

public class Combinations_077 {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> cur = new ArrayList<Integer>();
    	
    	helper(n, k, 1, cur, res);
    	
    	return res;
    }
    
    private void helper(int n, int k, int start, List<Integer> cur, List<List<Integer>> res) {
    	if (cur.size() == k) {
    		res.add(new ArrayList<Integer>(cur));
    		return;
    	} else {
    		for (int i = start; i <= n; i++) {
    			cur.add(i);
    			helper(n, k, i+1, cur, res);
    			cur.remove(cur.size()-1);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int n = 4;
    	int k = 2;
    	Combinations_077 sol = new Combinations_077();
    	List<List<Integer>> res = sol.combine(n, k);
    	System.out.println("res" + res);
    }
}
