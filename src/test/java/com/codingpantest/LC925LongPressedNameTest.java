package com.codingpantest;

import com.codingpan.leetcode.todo.LC925LongPressedName;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class LC925LongPressedNameTest {

    @Test
    public void testIsLongPressedName() {
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
