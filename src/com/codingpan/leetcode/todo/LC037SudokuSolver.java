package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.List;

public class LC037SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        solver(board, 0, 0);
    }

    private boolean solver(char[][] board, int i, int j) {
        if (j >= 9) return solver(board, i+1, 0);
        if (i == 9) return true;

        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k+'0');
                StdOut.println(board[i][j]);
                if (isValid(board, i, j)) {
                    if (solver(board, i, j+1)) return true;
                }
                board[i][j] = '.';
            }

        } else {
            return solver(board, i, j+1);
        }
        return false;
    }


    private boolean isValid(char[][] board, int row, int col) {
        //row check
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == board[row][col]) return false;
        }

        //col check
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == board[row][col]) return false;
        }

        //box check
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if ((i != row || j != col) && board[row][col] == board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * [["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]]
     *
     * solu:
     * [["5","3","4","6","7","8","9","1","2"],
     * ["6","7","2","1","9","5","3","4","8"],
     * ["1","9","8","3","4","2","5","6","7"],
     * ["8","5","9","7","6","1","4","2","3"],
     * ["4","2","6","8","5","3","7","9","1"],
     * ["7","1","3","9","2","4","8","5","6"],
     * ["9","6","1","5","3","7","2","8","4"],
     * ["2","8","7","4","1","9","6","3","5"],
     * ["3","4","5","2","8","6","1","7","9"]]
     **/

    /**
     * unit test
     * @param args
     */
    public static void main(String[] args) {
        LC037SudokuSolver solu = new LC037SudokuSolver();
        char[][] board = new char[9][9];
        //generate boards

        solu.solveSudoku(board);

        //print boards
    }

}
