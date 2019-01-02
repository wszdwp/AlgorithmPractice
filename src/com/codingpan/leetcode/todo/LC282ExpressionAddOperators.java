package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class LC282ExpressionAddOperators {
    static String n;
    static List<String> res;
    static int t;

    public List<String> addOperators(String num, int target) {
        n = num;
        List<String> res = new ArrayList<>();
        t = target;
        dfs("", 0, 0, 0);
        return res;
    }

    private void dfs(String expr, int pos, int prev, int curr) {
        if (curr == t && pos == n.length()) {
            res.add(expr);
        } else {
            for (int i = pos; i < n.length(); i++) {
                StdOut.println("pos " + pos + " i = " + i);
                String numStr = n.substring(pos, i+1);
                if (numStr.length() > 1 && numStr.charAt(0) == '0') break;
                if (isFlow(numStr)) continue;
                int num = Integer.valueOf(numStr);
                if (pos == 0) {
                    dfs(expr, i+1, num, num);
                    continue;
                }
                //add
                dfs(expr + "+" + num, i, +num, curr + num);
                //minus;
                dfs(expr + "-" + num, i, -num, curr - num);
                //muptiply
                dfs(expr + "*" + num, i, prev * num, curr - prev + prev * num);
            }
        }
    }

    private boolean isFlow(String s) {
        boolean flowed = true;
        try {
            long num = Long.parseLong(s);
            if (num >= Integer.MIN_VALUE || num <= Integer.MAX_VALUE) flowed = false;
        } catch (NumberFormatException e) {
        }
        return flowed;
    }

    public static void main(String[] args) {
        LC282ExpressionAddOperators solu = new LC282ExpressionAddOperators();
        solu.addOperators("123", 6);
        Utility.printList(res);
    }
}
