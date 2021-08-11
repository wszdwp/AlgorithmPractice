package com.codingpan.leetcode.todo;

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
        return lt == rt;
    }
}
