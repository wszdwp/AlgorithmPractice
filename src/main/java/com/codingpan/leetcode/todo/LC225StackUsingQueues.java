package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.Queue;

public class LC225StackUsingQueues {
  private Queue<Integer> q1;
  private Queue<Integer> q2;
  private boolean inQ1;

  /** Initialize your data structure here. */
  public LC225StackUsingQueues() {
    q1 = new LinkedList<Integer>();
    q2 = new LinkedList<Integer>();
    inQ1 = true;
  }

  /** Push element x onto stack. */
  public void push(int x) {
    if (inQ1) {
      q1.offer(x);
    } else {
      q2.offer(x);
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return getTop(false);
  }

  /** Get the top element. */
  public int top() {
    return getTop(true);
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }

  private int getTop(boolean peek) {
    int elem = 0;
    if (inQ1) {
      while (!q1.isEmpty()) {
        elem = q1.poll();
        if (q1.isEmpty()) {
          if (peek) q2.offer(elem);
        } else {
          q2.offer(elem);
        }
      }
      inQ1 = false;
    } else {
      while (!q2.isEmpty()) {
        elem = q2.poll();
        if (q2.isEmpty()) {
          if (peek) q1.offer(elem);
        } else {
          q1.offer(elem);
        }
      }
      inQ1 = true;
    }
    return elem;
  }

  public static void main(String[] args) {
    LC225StackUsingQueues solu = new LC225StackUsingQueues();
    solu.push(2);
    solu.push(1);
    StdOut.println(solu.pop());
    StdOut.println(solu.top());
  }
}
