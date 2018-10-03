package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC403FrogJump {
    public boolean canCross(int[] stones) {
//        return canCrossHelper(stones, 0, 1);
        int[][] map = new int[stones.length][stones.length];
        return canCrossHelper2(stones, 0, 1, map);
    }

    private boolean canCrossHelper(int[] stones, int start, int k) {
        if (start == stones.length-1) {
            return true;
        } else {
            if (start > stones.length) return false;
            boolean success1 = false, success2 = false, success3 = false;
            for (int i = start+1; i < stones.length; i++) {
                if (stones[start] + k == stones[i]) {
                    success1 = canCrossHelper(stones, i, k);
                }
                if (start != 0 && stones[start] + k - 1 == stones[i]) {
                    success2 = canCrossHelper(stones, i, k-1);
                }
                if (start != 0 && stones[start] + k + 1 == stones[i]) {
                    success3 = canCrossHelper(stones, i, k+1);
                }
            }
            return success1 || success2 || success3;
        }
    }

    private boolean canCrossHelper2(int[] stones, int start, int k, int[][] map) {
        if (start == stones.length-1) {
            map[start][k] = 1;
            return true;
        } else {
            if (start > stones.length) {
                return false;
            }
            boolean success1 = false, success2 = false, success3 = false;
            for (int i = start+1; i < stones.length; i++) {
                if (stones[start] + k == stones[i]) {
                    if (map[start][k] == 0) {
                        success1 = canCrossHelper2(stones, i, k, map);
                        map[start][k] = success1 ? 1 : -1;
                    } else {
                        success1 = map[start][k] == 1 ? true : false;
                    }
                }
                if (start != 0 && stones[start] + k - 1 == stones[i]) {
                    if (map[start][k-1] == 0) {
                        success2 = canCrossHelper2(stones, i, k-1, map);
                        map[start][k-1] = success2 ? 1 : -1;
                    } else {
                        success2 = map[start][k-1] == 1 ? true : false;
                    }
                }
                if (start != 0 && stones[start] + k + 1 == stones[i]) {
                    if (map[start][k+1] == 0) {
                        success3 = canCrossHelper2(stones, i, k+1, map);
                        map[start][k+1] = success3 ? 1 : -1;
                    } else {
                        success3 = map[start][k+1] == 1 ? true : false;
                    }
                }
            }
            return success1 || success2 || success3;
        }
    }

    public static void main(String[] args) {
        LC403FrogJump solu = new LC403FrogJump();
        //int[] stones = {0,1,3,5,6,8,12,17};   //true
        int[] stones = {0,1,2,3,4,8,9,11};  //false
        //int[] stones = {0,2};               //false
        StdOut.println("true " + solu.canCross(stones));
    }
}
