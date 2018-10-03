package com.codingpan.contests;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Ctx90 {
    public int scoreOfParentheses(String S) {
        if (S.length() == 0 || S.length() == 1) return 0;
//        return process1(S);
        return process1_2(S);
    }

    private int process1(String S) {
        int res[] = new int[30], i = 0;
        for (char c : S.toCharArray())
            if (c == '(') res[++i] = 0;
            else res[i - 1] += Math.max(res[i--] * 2, 1);
        return res[0];
    }

    private int process1_2(String S) {
        Stack<Integer> stk = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') stk.push(0);
            else {
                int top = stk.pop();
                top += Math.max(top*2, 1);
                stk.push(top);
            }
        }
        int res = 0;
        while (!stk.isEmpty()) res = stk.pop();
        return res;
    }



    private int process2(String S) {
        Stack<Integer> stk = new Stack<Integer>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stk.push(-1);
            } else {
                int curr = 0;
                while (stk.peek() != -1) {
                    curr += stk.pop();
                }
                stk.pop();
                stk.push(curr == 0 ? 1 : curr * 2);
            }
        }
        int sum = 0;
        while (!stk.isEmpty()) {
            sum += stk.pop();
        }
        return sum;
    }



    public static void main(String[] args) {
        Ctx90 solu = new Ctx90();
        String s = "(()(()))";
        int res = solu.scoreOfParentheses(s);
        StdOut.println(res);
    }

}
