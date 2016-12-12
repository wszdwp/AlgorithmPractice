package com.codingpan.leetcode.TODO;

/**
 * 
 * [389. Find the Difference](https://leetcode.com/problems/find-the-difference/)
 * 
 * Given two strings s and t which consist of only lowercase letters.
 * String t is generated by random shuffling string s 
 * and then add one more letter at a random position.
 * Find the letter that was added in t.
 * 
 * Example:
 * Input:
 * s = "abcd"
 * t = "abcde"
 * 
 * Output: e
 * 
 * Explanation: 'e' is the letter that was added.
 * 
 * */

public class FindTheDifference_389 {
	public char findTheDifference(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        
        int asciis = 0;
        int asciit = 0;
        
        for(int i = 0; i < array1.length; i++){
            asciis ^= (int)array1[i];
        }
        
        for(int i = 0; i < array2.length; i++){
            asciit ^= (int)array2[i];
        }
        
        return (char)(asciit-asciis);
    }

    public static void main(String[] args) {
    	FindTheDifference_389 test = new FindTheDifference_389();
        String s = "abcdr";
        String t = "abcd";
        char res = test.findTheDifference(s, t);
        System.out.println("res = " + (int)res);
    }
}
