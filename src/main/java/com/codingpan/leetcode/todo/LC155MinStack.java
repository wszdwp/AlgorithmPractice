package com.codingpan.leetcode.todo;

public class LC155MinStack {

    private Integer[] data;
    private Integer[] min;
    private int N;

    /**
     * initialize your data structure here.
     */
    public LC155MinStack() {
        N = 0;
        data = new Integer[1];
        min = new Integer[1];
    }

    private void resize(int size) {
        Integer[] dataCopy = new Integer[size];
        Integer[] minCopy = new Integer[size];
        for (int i = 0; i < N; i++) {
            dataCopy[i] = data[i];
            minCopy[i] = min[i];
        }
        data = dataCopy;
        min = minCopy;
    }

    public void push(int x) {
        data[N] = x;
        if (N == 0 || x <= getMin()) {
            min[N] = x;
        } else {
            min[N] = top();
        }
        N++;
        if (N == data.length) resize(2 * N);
    }

    public void pop() {
        if (N == 0) return;
        data[N - 1] = null;
        N--;
        if (N > 0 && N == data.length / 4) resize(data.length / 2);
    }

    public int top() {
        if (N == 0) return 0;
        return data[N - 1];
    }

    public int getMin() {
        if (N == 0) return 0;
        return min[N - 1];
    }

    public static void main(String[] args) {
        LC155MinStack obj = new LC155MinStack();
        obj.push(1);
        obj.pop();
        int top = obj.top();
        int min = obj.getMin();
    }
}
