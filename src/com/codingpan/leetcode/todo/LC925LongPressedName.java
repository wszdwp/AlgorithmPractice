package com.codingpan.leetcode.todo;

import com.sun.tools.javac.util.Assert;
import edu.princeton.cs.algs4.StdOut;

public class LC925LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) return false;

        int ln = 0, rn = name.length() - 1;
        int lt = 0, rt = typed.length() - 1;
        while (ln < rn && lt < rt) {
            while (lt < rt && name.charAt(ln) != typed.charAt(lt)) ++lt;
            while (lt < rt && name.charAt(rn) != typed.charAt(rt)) --rt;
            if (lt == rt && ln != rn) return false;
            ln++;
            rn--;
            lt++;
            rt--;
        }
        if (lt == rt && ln != rn) return false;
        if (lt != rt) return false;
        return true;
    }

    public static void main(String[] args) {
        LC925LongPressedName solu = new LC925LongPressedName();
        String[] names = {"alex", "saeed", "leelee", "laiden"};
        String[] typed = {"aaleex", "ssaaedd", "lleeelee", "laiden"};
        boolean[] ans = {true, false, true, true};
        for (int i = 0; i < names.length; i++) {
            boolean testRes = solu.isLongPressedName(names[i], typed[i]);
                    StdOut.println(testRes
                    + " expected " + ans[i]
                    + (ans[i]==testRes ? " pass" : " fail"));
        }
    }
}
