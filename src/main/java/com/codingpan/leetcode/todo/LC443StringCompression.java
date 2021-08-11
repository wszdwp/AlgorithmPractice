package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

public class LC443StringCompression {
    public int compress(char[] chars) {
        if (chars.length <= 1) return chars.length;

        int pos = 0;
        int i = 0;
        int j = 0;
        while (i < chars.length) {
            if (j == chars.length || chars[i] != chars[j]) {
                chars[pos++] = chars[i];
                if (j - i <= 1) {
                    i = j;
                } else {
                    String countStr = String.valueOf(j - i);
                    for (int k = 0; k < countStr.length(); k++) {
                        chars[pos++] = countStr.charAt(k);
                    }
                    i = j;
                }
            } else {
                j++;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        // char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        // Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

        // char[] chars = {'a','a','b','b','c','c','c'};
        // Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

        // char[] chars = {'a','b','c','d','d','f'};

        char[] chars = {'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        // Return 6, {'a', '3', 'b', '2', 'a', '2'}

        LC443StringCompression solu = new LC443StringCompression();
        int res = solu.compress(chars);
        StdOut.println(res);
        Utility.printCharArray(chars);
    }
}
