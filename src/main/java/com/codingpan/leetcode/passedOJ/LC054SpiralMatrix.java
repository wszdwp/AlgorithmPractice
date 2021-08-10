package com.codingpan.leetcode.passedOJ;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class LC054SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
    int tR = 0, tC = 0;
    int dR = matrix.length - 1, dC = matrix[0].length - 1;
    while (tR <= dR && tC <= dC) {
      getSpiralList(matrix, tR++, tC++, dR--, dC--, res);
    }
    return res;
  }

  private void getSpiralList(int[][] m, int tR, int tC, int dR, int dC, List<Integer> res) {
    if (tR == dR) { // one row
      for (int i = tC; i <= dC; i++) {
        res.add(m[tR][i]);
      }
    } else if (tC == dC) { // one col
      for (int i = tR; i <= dR; i++) {
        res.add(m[i][tC]);
      }
    } else {
      int curC = tC;
      int curR = tR;
      while (curC != dC) {
        res.add(m[tR][curC]);
        curC++;
      }
      while (curR != dR) {
        res.add(m[curR][dC]);
        curR++;
      }
      while (curC != tC) {
        res.add(m[dR][curC]);
        curC--;
      }
      while (curR != tR) {
        res.add(m[curR][tC]);
        curR--;
      }
    }
  }

  public static void main(String[] args) {
    LC054SpiralMatrix solu = new LC054SpiralMatrix();
    for (int i = 0; i < 3; i++) {
      int[][] matrix = Utility.generateMatrix(i, i);
      List<Integer> res = solu.spiralOrder(matrix);
      Utility.printMatrix(matrix);
      Utility.printList(res);
    }
  }
}
