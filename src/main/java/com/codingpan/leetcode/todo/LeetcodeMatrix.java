package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeMatrix {
	/* 251 题目链接: https://leetcode.com/problems/flatten-2d-vector/
		Implement an iterator to flatten a 2d vector.
		For example,
		Given 2d vector =
		[
		  [1,2],
		  [3],
		  [4,5,6]
		]
		By calling next repeatedly until hasNext returns false, 
		the order of elements returned by next should be: [1,2,3,4,5,6].

		Hint:
		How many variables do you need to keep track?
			Two variables is all you need. Try with x and y.
			Beware of empty rows. It could be the first few rows.
			To write correct code, think about the invariant to maintain. What is it?
			The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
			Not sure? Think about how you would implement hasNext(). Which is more complex?
			Common logic in two different places should be refactored into a common method.
		Follow up:
		As an added challenge, 
		1. try to code it using only iterators in C++ or iterators in Java.
		2. add remove() */
	class Vector2D {
		private List<List<Integer>> vector2D = new ArrayList<>();
		private int row = 0;
		private int col = 0;

		public Vector2D(List<List<Integer>> myList) {
			vector2D = myList;
			row = 0;
			col = 0;
		}

		public int next() {
			return vector2D.get(row).get(col++);
		}

		public boolean hasNext() {
			while (row < vector2D.size()) {
				if (col < vector2D.get(row).size()) {
					return true;
				} else {
					row++;
					col = 0;
				}
			}
			return false;
		}
	}

    // zigzag print matrix
    public void printZigZag(int[][] matrix) {
        int tR = 0, tC = 0;
        int dR = 0, dC = 0;
        int endR = matrix.length-1;
        int endC = matrix[0].length-1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        StdOut.println();
    }

    public void printZigZag2(int[][] m) {
	    int tR = 0, tC = m[0].length - 1;
	    int dR = 0, dC = m[0].length - 1;
	    int endR = m.length - 1;
	    int endC = 0;
	    boolean fromUp = false;
	    while (tR != endR + 1) {
	        printLevel2(m, tR, tC, dR, dC, fromUp);
	        tR = tC == endC ? tR + 1 : tR;
	        tC = tC == endC ? tC : tC - 1;
	        dC = dR == endR ? dC - 1 : dC ;
	        dR = dR == endR ? dR : dR + 1;
	        fromUp = !fromUp;
        }
        StdOut.println();
    }

    private void printLevel2(int[][] m, int tR, int tC, int dR, int dC, boolean fromTop) {
	    if (fromTop) {
	        while (tR != dR + 1) {
	            StdOut.print(m[tR++][tC++] + " ");
            }
            StdOut.println();
        } else {
	        while (dR != tR - 1) {
	            StdOut.print(m[dR--][dC--] + " ");
            }
            StdOut.println();
        }
    }

    private void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                StdOut.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                StdOut.print(m[dR--][dC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        LeetcodeMatrix solu = new LeetcodeMatrix();
        for (int i = 1; i < 5; i++) {
            int[][] matrix = Utility.generateMatrix(i, i);
            Utility.printMatrix(matrix);
            //solu.printZigZag(matrix);
            solu.printZigZag2(matrix);
            //Utility.printMatrix(matrix);
        }
    }

}
