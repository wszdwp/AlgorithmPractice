package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Contest90 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }

        char[] arr = A.toCharArray();
        char[] brr = B.toCharArray();
        int count = 0;
        int s = 0;
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != brr[i]) {
                count++;
                if (count == 1) {
                    s = i;
                }
                else if (count == 2) {
                    e = i;
                }
                else {
                    return false;
                }
            }
        }

        if (count != 2 && count != 0) {
            return false;
        } else {
            return arr[s] == brr[e] && brr[s] == arr[e];
        }
    }

    public int scoreOfParentheses(String S) {
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
        Contest90 solu = new Contest90();
        String A = "ac";
        String B = "ba";
        StdOut.println(solu.buddyStrings(A, B));


        String S = "((()))";
        StdOut.println(solu.scoreOfParentheses(S));
    }
}
