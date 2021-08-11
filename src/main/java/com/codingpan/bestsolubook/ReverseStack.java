package com.codingpan.bestsolubook;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class ReverseStack {
    public void reverseStack(Stack<Integer> stk) {
        reserseHelper(stk);
        while (!stk.isEmpty()) {
            StdOut.println(stk.pop());
        }
    }

    private void reserseHelper(Stack<Integer> stk) {
        if (stk.isEmpty()) return;
        int last = popLastElem(stk);
        reserseHelper(stk);
        stk.push(last);
    }

    private int popLastElem(Stack<Integer> stk) {
        int result = stk.pop();
        if (stk.isEmpty()) {
            return result;
        } else {
            int elem = popLastElem(stk);
            stk.push(result);
            return elem;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);

        ReverseStack solu = new ReverseStack();
        solu.reverseStack(stk);
    }
}
