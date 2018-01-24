package com.codingpan.leetcode.passedOJ;

/**
 * Input:Digit string "23"
 * 
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
import java.util.ArrayList;
import java.util.List;

public class LC017LetterCombinationsOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
        final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        helper(LETTERS, digits, 0, sb ,res);
        
        return res;
    }
    
    private void helper(String[] letters, String digits, int start, StringBuilder sb, List<String> res) {
        if (start == digits.length() && sb.length() == digits.length()) {
            res.add(new String(sb.toString()));
            return;
        } else {
            for (int i = start; i < digits.length(); i++) {
                int idx = Integer.parseInt(digits.substring(i, i+1));
//                System.out.println("idx=" + idx);
                String letter = letters[idx];
                for (int j = 0; j < letter.length(); j++) {
                    sb.append(letter.charAt(j));
//                    System.out.println(sb);
                    helper(letters, digits, i+1, sb, res);
                    sb.deleteCharAt(sb.length()-1);
                }
            }

        }
    }
    
    public static void main(String[] args) {
    	String digits = "234";
    	
    	LC017LetterCombinationsOfPhoneNumber sol = new LC017LetterCombinationsOfPhoneNumber();
    	System.out.println("res" + sol.letterCombinations(digits));
    }
}
