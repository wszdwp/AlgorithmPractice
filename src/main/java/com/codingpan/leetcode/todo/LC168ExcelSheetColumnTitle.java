package com.codingpan.leetcode.todo;

/**
 * @author pan
 * <p>Given a positive integer, return its corresponding column title as appear in an Excel
 * sheet.
 * <p>For example:
 * <p>1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB Credits:
 */
public class LC168ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        String s = "";

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int i = n % 27;
            char c = (char) (i + 'A' - 1);
            // System.out.println(i);
            sb.append(c);
            n = n / 27;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int i = 0;
        while (i < 101) {
            System.out.println(i + " " + convertToTitle(i));
            i++;
        }
    }
}
