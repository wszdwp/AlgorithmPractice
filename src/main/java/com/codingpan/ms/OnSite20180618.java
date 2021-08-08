package com.codingpan.ms;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class OnSite20180618 {
    /**
     * 1st number combinations
     */
    private final static String[] LETTERS =
            {"0", "1", "2abc", "3def", "4ghi", "5jkl", "6mno", "7pqrs", "8tuv", "9wxyz"};

    public List<String> letterCombinations(String num) {
        List<String> res = new ArrayList<>();
        helper(num, 0, new StringBuilder(), res);
        return res;
    }

    private void helper(String num, int start, StringBuilder sb, List<String> res) {
        if (sb.length() == num.length()) {
            res.add(new String(sb));
        } else {
            for (int i = start; i < num.length(); i++) {
                int idx = Integer.valueOf(num.substring(i, i+1));
                String letter = LETTERS[idx];
                for (int j = 0; j < letter.length(); j++) {
                    sb.append(letter.charAt(j));
                    helper(num, i+1, sb, res);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }

    /**
     * maximum sub-array sum
     * @param arr
     */
    public int maxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int maxSum = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSoFar = Math.max(arr[i], maxSoFar + arr[i]);
            maxSum = maxSoFar > maxSum ? maxSoFar : maxSum;
        }
        return maxSum;
    }

    /**
     * swipe array in four directions, each time just move one step
     * arr[i] range is [2, 2^n]
     * rule 1: if no place stay curr pos
     * rule 2: after moving to the new pos, if neighbor are the same num,
     *         added onto the neighbour's cell if neighbour on the moving direction
     *         otherwise added on the current pos
     * rule 3:
     */
    public enum SwipeDir {UP, DOWN, LEFT, RIGHT};

    public void updateMatrix(int[][] m, SwipeDir dir) {
        int delta = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (dir == SwipeDir.DOWN || dir == SwipeDir.RIGHT) {
                    delta = 1;
                }
                if (dir == SwipeDir.UP || dir == SwipeDir.LEFT) {
                    delta = -1;
                }
            }
        }
    }

    private void updateHelper(int[][] m, int sRow, int sCol, int eRow, int eCol) {
        int r = sRow, c = sCol;
        while (r < eRow && c < eCol) {

        }
    }

    /**
     * design tic tac toe game
     * @param args
     */
    
    public static void main(String[] args) {
        OnSite20180618 solu = new OnSite20180618();

        // com.codingpan.test cases
//        String[] nums = {"123", "23", "", "0125", "98"};
//        for (String num : nums) {
//            StdOut.println(num + ": " + solu.letterCombinations(num));
//        }

        // 2 com.codingpan.test cases
        int[] arr = {-2, -4, -6, -1};
        StdOut.println(solu.maxSubArraySum(arr));

        // 3 com.codingpan.test cases

    }
}
