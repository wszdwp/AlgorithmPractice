package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.List;

public class LC279PerfectSquares {
  public int numSquares(int n) {
    List<Integer> squares = getSquares(n);
    if (squares.size() == 0 || n < 0) return 0;
    Utility.printList(squares);
    if (n == 1 || n == squares.get(0)) return 1;
    int[] minCount = new int[2];
    minCount[0] = Integer.MAX_VALUE;
    minCount[1] = 0;
    int count = numSquaresHelper(n, squares, 0, minCount);
    return minCount[0];
  }

  //    private int numSquaresHelper(int n, List<Integer> squares, int idx) {
  //        int count = 0;
  //        if (idx == squares.size()) {
  //            count = n == 0 ? 1 : 0;
  //        } else {
  //            for (int i = 0; squares.get(idx) * i <= n; i++) {
  //                count += numSquaresHelper(n - squares.get(idx) * i, squares, idx+1);
  //            }
  //        }
  //        return count;
  //    }

  private int numSquaresHelper(int n, List<Integer> squares, int idx, int[] minCount) {
    int count = 0;
    if (idx == squares.size()) {
      if (n == 0) {
        count = 1;
        minCount[0] = Math.min(minCount[0], minCount[1] + 1);
        minCount[1] = 0;
      } else {
        count = 0;
        minCount[1] = 0;
      }
    } else {
      for (int i = 0; squares.get(idx) * i <= n; i++) {
        minCount[1] += i;
        count += numSquaresHelper(n - squares.get(idx) * i, squares, idx + 1, minCount);
      }
    }
    return count;
  }

  private List<Integer> getSquares(int n) {
    List<Integer> squares = new LinkedList<>();
    int i = 1;
    int square = 1;
    while (square <= n) {
      squares.add(0, square);
      i++;
      square = i * i;
    }
    return squares;
  }

  public static void main(String[] args) {
    LC279PerfectSquares solu = new LC279PerfectSquares();
    int n = 12;
    StdOut.println(solu.numSquares(n));
  }
}
