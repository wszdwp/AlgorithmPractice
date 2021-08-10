package com.codingpan.leetcode.todo;

import java.util.Stack;

public class LC331VerifyPreOrderSerializationOfBST {
  public boolean isValidSerialization(String preorder) {
    // using a stack, scan left to right
    // case 1: we see a number, just push it to the stack
    // case 2: we see #, check if the top of stack is also #
    // if so, pop #, pop the number in a while loop, until top of stack is not #
    // if not, push it to stack
    // in the end, check if stack size is 1, and stack top is #

    // explanation 2
    // "9,3,4,#,#,1,#,#,2,#,6,#,#",
    // when you iterate through the preorder traversal string, for each char:
    // case 1: you see a number c, means you begin to expand a new tree rooted with c,
    // you push it to stack
    // case 2.1: you see a #, while top of stack is a number,
    // you know this # is a left null child, put it there as a mark for next coming node k to know
    // it is being the right child.
    // case 2.2: you see a #, while top of stack is #, you know you meet this # as right null child,
    // you now cancel the sub tree (rooted as t, for example) with these two-# children.
    // But wait, after the cancellation, you continue to check top of stack is whether # or a
    // number:
    // ---- if a number, say u, you know you just cancelled a node t which is left child of u.
    // You need to leave a # mark to the top of stack. So that the next node know it is a right
    // child.
    // ---- if a #, you know you just cancelled a tree whose root, t, is the right child of u.
    // So you continue to cancel sub tree of u, and the process goes on and on.

    /** _9_ / \ 3 2 / \ / \ 4 1 # 6 / \ / \ / \ # # # # # # */
    if (preorder == null) {
      return false;
    }
    Stack<String> st = new Stack<>();
    String[] strs = preorder.split(",");
    for (int pos = 0; pos < strs.length; pos++) {
      String curr = strs[pos];
      while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
        st.pop();
        if (st.isEmpty()) {
          return false;
        }
        st.pop();
      }
      st.push(curr);
      System.out.println("STK" + st);
    }
    return st.size() == 1 && st.peek().equals("#");
  }

  public static void main(String[] args) {
    String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
    LC331VerifyPreOrderSerializationOfBST sol = new LC331VerifyPreOrderSerializationOfBST();
    System.out.println("(exp: true) " + sol.isValidSerialization(preorder));
  }
}
