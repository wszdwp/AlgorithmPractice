package com.codingpan.leetcode.TODO;

import java.util.ArrayList;
import java.util.List;
//You are given a string, s, 
// and a list of words, words, that are all of the same length. 
// Find all starting indices of substring(s) in s that 
// is a concatenation of each word in words exactly 
// once and without any intervening characters.
//
//For example, given:
//s: "barfoothefoobarman"
//words: ["foo", "bar"]
//
//You should return the indices: [0,9].
//(order does not matter).


public class LC030SubStrAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        
        return res;
    }

    public static void getAllPermutation(String[] words, int idx, StringBuilder soFar, StringBuilder rest, ArrayList<String> permutations) {
    	if (idx == words.length) {
    		permutations.add(soFar.toString()+rest.toString());
		} else {
    		for (int i = idx; i < words.length; i++) {
	    		String w = words[i];
	    		soFar.append(w);
				rest.delete(0, w.length());
				getAllPermutation(words, i+1, soFar, rest, permutations);
				rest.insert(0, w);
				soFar.delete(soFar.length()-w.length(), soFar.length());
			}
    	}
    }
    
    public static void main(String[] args) {
    	String[] words = {"foo", "bar", "soo"};
    	String s = "barfoothefoobarman";
    	
    	ArrayList<String> permutation = new ArrayList<String>();
    	StringBuilder soFar = new StringBuilder();
    	StringBuilder rest = new StringBuilder();
    	for (String w : words) {
    		rest.append(w);
		}
    	getAllPermutation(words, 0, soFar, rest, permutation);
    	System.out.println("permutation " + permutation);
    }
}
