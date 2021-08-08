package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC670MaxiumSwap {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();

        if (s.length() <= 1) return num;
        int start = 0;
        int j = 0;
        int maxDigitPos = 0;
        boolean found = false;
        for (int i = 1; i < s.length(); i++) {
            int n2 = arr[j] - '0';
            int n = arr[i] - '0';
            if (!found &&  n2 <= n) {
                start = j;
                maxDigitPos = i;
                found = true;
            }
            if (found && arr[maxDigitPos] - '0' <= n) {
                maxDigitPos = i;
            }
            j = i;
        }
        StdOut.println("S=" + start + " end=" + maxDigitPos);
        swap(arr, start, maxDigitPos);
        s = new String(arr);
        return Integer.valueOf(s);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        LC670MaxiumSwap solu = new LC670MaxiumSwap();
        int num = 12;
        //num = 98368;
        //num = 115;
        //num = 1993;
        num = 10909091;
        StdOut.println(solu.maximumSwap(num));
    }
}
