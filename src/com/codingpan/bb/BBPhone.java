package com.codingpan.bb;

import edu.princeton.cs.algs4.StdOut;

public class BBPhone {
    //递归实现双重for循环
    public void doubleForRecurrsion(int m, int n) {
        doubleForHelper(0, 0, m, n);
    }

    private void doubleForHelper(int i, int j, int iLen, int jLen) {
        if (j == jLen && i < iLen) {
            StdOut.println();
            doubleForHelper(i+1, 0, iLen, jLen);
        }
        else if (i == iLen) {
            return;
        }
        else {
            System.out.print(j + ",");
            doubleForHelper(i, j+1, iLen, jLen);
        }
    }

    public static void main(String[] args) {
        BBPhone solu = new BBPhone();
        int m = 3;
        int n = 5;
        solu.doubleForRecurrsion(m, n);

    }

}
