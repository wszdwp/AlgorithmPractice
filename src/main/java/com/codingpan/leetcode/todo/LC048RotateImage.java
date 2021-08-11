package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;

public class LC048RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int sR = 0, sC = 0;
        int tR = matrix.length - 1, tC = matrix.length - 1;
        while (sR <= tR && sC <= tC) {
            rotateEdge(matrix, sR++, sC++, tR--, tC--);
        }
    }

    private void rotateEdge(int[][] m, int sR, int sC, int tR, int tC) {
        int times = tC - sC;
        for (int i = 0; i < times; i++) {
            int temp = m[sR][sC + i];
            m[sR][sC + i] = m[tR - i][sC];
            m[tR - i][sC] = m[tR][tC - i];
            m[tR][tC - i] = m[sR + i][tC];
            m[sR + i][tC] = temp;
        }
    }

    public static void main(String[] args) {
        LC048RotateImage solu = new LC048RotateImage();
        for (int i = 1; i < 5; i++) {
            int[][] matrix = Utility.generateMatrix(i, i);
            Utility.printMatrix(matrix);
            solu.rotate(matrix);
            Utility.printMatrix(matrix);
        }
    }
}
