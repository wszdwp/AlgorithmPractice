package com.codingpan.leetcode.todo;

public class LTContest53 {
  public static boolean hasAlternatingBits(int n) {
    String binaryN = Integer.toBinaryString(n);
    if (binaryN.length() <= 1) return false;

    char c = binaryN.charAt(0);
    for (int i = 1; i < binaryN.length(); i++) {
      char cc = binaryN.charAt(i);
      if ((c == '0' && cc != '1') || (c == '1' && cc != '0')) {
        return false;
      }
      c = cc;
    }
    return true;
  }

  public static int minStickers(String[] stickers, String target) {
    for (String sticker : stickers) {
      getCharMap(sticker);
    }
    int[] targetMap = getCharMap(target);

    return -1;
  }

  public static int[] getCharMap(String s) {
    int[] cMap = new int[26];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      cMap[c - 'a'] += 1;
    }
    for (int i = 0; i < 26; i++) {
      System.out.print(cMap[i] + " ");
    }
    System.out.println();
    return cMap;
  }

  public static void main(String[] args) {
    //    	int[] nums = {5, 7, 11, 10};
    //
    //    	for (int n : nums) {
    //    		System.out.println(n + " " + Integer.toBinaryString(n) + " " +
    // Integer.toBinaryString(n));
    //
    //    		System.out.println(n + " hasAlternatingBits " + hasAlternatingBits(n));
    //    	}
    String[] stickers = {"with", "example", "science"};
    String target = "thehat";
    int res = minStickers(stickers, target);
    System.out.println(res);
  }
}
