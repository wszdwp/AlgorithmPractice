package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class LC741CherryPickup {
    //	In a N x N grid representing a field of cherries, each cell is one of three possible integers.
    //
    //	0 means the cell is empty, so you can pass through;
    //	1 means the cell contains a cherry, that you can pick up and pass through;
    //	-1 means the cell contains a thorn that blocks your way.
    //	Your task is to collect maximum number of cherries possible by following the rules below:
    //
    //	Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid
    // path cells (cells with value 0 or 1);
    //	After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
    //	When passing through a path cell containing a cherry, you pick it up and the cell becomes an
    // empty cell (0);
    //	If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
    //	Example 1:
    //	Input: grid =
    //	[[0, 1, -1],
    //	 [1, 0, -1],
    //	 [1, 1,  1]]
    //	Output: 5
    //	Explanation:
    //	The player started at (0, 0) and went down, down, right right to reach (2, 2).
    //	4 cherries were picked up during this single trip, and the matrix becomes
    // [[0,1,-1],[0,0,-1],[0,0,0]].
    //	Then, the player went left, up, up, left to return home, picking up one more cherry.
    //	The total number of cherries picked up is 5, and this is the maximum possible.
    //	Note:
    //
    //	grid is an N by N 2D array, with 1 <= N <= 50.
    //	Each grid[i][j] is an integer in the set {-1, 0, 1}.
    //	It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1.

    class Coord {
        public int x;
        public int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int cherryPickup(int[][] grid) {
        List<List<Coord>> paths = new ArrayList<List<Coord>>();
        List<Coord> path = new ArrayList<>();
        boolean[][] mark = new boolean[grid.length][grid[0].length];
        pickProcess(grid, 0, 0, mark, path, paths);

        int maxP = 0;
        List<Coord> maxPath = new ArrayList<>();
        StdOut.println("Forward");
        for (List<Coord> coordList : paths) {
            int sum = 0;
            for (Coord coord : coordList) {
                // StdOut.print("(" + coord.x + "," + coord.y + ")" + ", ");
                int v = grid[coord.x][coord.y];
                sum += v;
            }
            // StdOut.println();
            if (maxP < sum) {
                maxP = sum;
                maxPath = coordList;
            }
        }
        StdOut.println("Max Path");
        for (Coord coord : maxPath) {
            StdOut.print("(" + coord.x + "," + coord.y + ")" + ", ");
            grid[coord.x][coord.y] = 0;
        }
        StdOut.println();

        int maxP2 = 0;
        paths = new ArrayList<List<Coord>>();
        path = new ArrayList<>();
        mark = new boolean[grid.length][grid[0].length];
        pickProcess2(grid, grid.length - 1, grid[0].length - 1, mark, path, paths);
        StdOut.println("Back");
        for (List<Coord> coordList : paths) {
            int sum2 = 0;
            for (Coord coord : coordList) {
                // StdOut.print("(" + coord.x + "," + coord.y + ")" + ", ");
                int v = grid[coord.x][coord.y];
                sum2 += v;
            }
            // StdOut.println();
            if (maxP2 < sum2) {
                maxP2 = sum2;
                maxPath = coordList;
            }
        }
        StdOut.println("Max back Path");
        for (Coord coord : maxPath) {
            StdOut.print("(" + coord.x + "," + coord.y + ")" + ", ");
            grid[coord.x][coord.y] = 0;
        }
        StdOut.println();
        return maxP + maxP2;
    }

    private void pickProcess(
            int[][] g, int i, int j, boolean[][] mark, List<Coord> path, List<List<Coord>> paths) {
        if (i == g.length - 1 && j == g[0].length - 1) {
            path.add(new Coord(i, j));
            paths.add(new ArrayList<Coord>(path));
            path.remove(path.size() - 1);
        } else {
            if (i < 0 || j < 0 || i >= g.length || j >= g[0].length) return;
            if (!mark[i][j]) {
                if (g[i][j] == -1) {
                    mark[i][j] = true;
                } else {
                    mark[i][j] = true;
                    path.add(new Coord(i, j));
                    pickProcess(g, i, j + 1, mark, path, paths);
                    path.remove(path.size() - 1);
                    mark[i][j] = false;

                    mark[i][j] = true;
                    path.add(new Coord(i, j));
                    pickProcess(g, i + 1, j, mark, path, paths);
                    path.remove(path.size() - 1);
                    mark[i][j] = false;
                }
            }
        }
    }

    private void pickProcess2(
            int[][] g, int i, int j, boolean[][] mark, List<Coord> path, List<List<Coord>> paths) {
        if (i == 0 && j == 0) {
            path.add(new Coord(i, j));
            paths.add(new ArrayList<Coord>(path));
            path.remove(path.size() - 1);
        } else {
            if (i < 0 || j < 0 || i >= g.length || j >= g[0].length) return;
            if (!mark[i][j]) {
                if (g[i][j] == -1) {
                    mark[i][j] = true;
                } else {
                    mark[i][j] = true;
                    path.add(new Coord(i, j));
                    pickProcess2(g, i, j - 1, mark, path, paths);
                    path.remove(path.size() - 1);
                    mark[i][j] = false;

                    mark[i][j] = true;
                    path.add(new Coord(i, j));
                    pickProcess2(g, i - 1, j, mark, path, paths);
                    path.remove(path.size() - 1);
                    mark[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        LC741CherryPickup solu = new LC741CherryPickup();
        //        int[][] grid = {
        //                {0, 1, -1},
        //                {1, 0, -1},
        //                {1, 1,  1}
        //        };
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1}
        };

        // [[1,1,1,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,0,0,1],[1,0,0,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,1,1,1]]
        // expected 15
        StdOut.println(solu.cherryPickup(grid));
    }
}
