package com.codingpan.algm1;

/**
 * Author: Pan Wang Written: 03/24/2018 Last updated: 03/25/2018
 *
 * <p>Compilation: javac Percolation.java Execution: java Percolation
 *
 * <p>Find percolation in a n * n grid, grid is percolated when any cell on top row can find a open
 * path connected to bottom row
 */
public class Percolation {
  private int[][] grid;
  private int openSites;
  private WeightedQuickUnionUF UF;
  private int topNode;
  private int botNode;

  // Create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) throw new IllegalArgumentException("Invalid n: " + n);
    grid = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = 1;
      }
    }
    openSites = 0;
    UF = new WeightedQuickUnionUF(n * n + 2);
    topNode = n * n;
    botNode = topNode + 1;
  }

  // Open site (row, col) if it is not open already
  public void open(int row, int col) {
    if (isOpen(row, col)) return;

    int i = row - 1;
    int j = col - 1;
    grid[i][j] = 0;
    openSites++;
    updateUF(i, j);
  }

  // Is site (row, col) open?
  public boolean isOpen(int row, int col) {
    int i = row - 1;
    int j = col - 1;
    if (!validPos(i, j)) {
      throw new IllegalArgumentException("Invalid row: " + row + " col: " + col);
    }
    return grid[i][j] == 0;
  }

  // Is site (row, col) full?
  public boolean isFull(int row, int col) {
    int i = row - 1;
    int j = col - 1;
    if (!validPos(i, j)) {
      throw new IllegalArgumentException("Invalid row: " + row + " col: " + col);
    }
    return grid[i][j] == 1;
  }

  // number of open sites
  public int numberOfOpenSites() {
    return openSites;
  }

  // does the system percolate?
  public boolean percolates() {
    int row = 1;
    for (int col = 1; col <= grid[0].length; col++) {
      if (isOpen(row, col)) {
        UF.union(topNode, getUFPos(row - 1, col - 1));
      }
    }

    row = grid.length;
    for (int col = 1; col <= grid[0].length; col++) {
      if (isOpen(row, col)) {
        UF.union(botNode, getUFPos(row - 1, col - 1));
      }
    }

    return UF.connected(topNode, botNode);
  }

  private int getUFPos(int i, int j) {
    return i * grid[0].length + j;
  }

  private boolean validPos(int i, int j) {
    return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length);
  }

  private void updateUF(int i, int j) {
    int[] up = {i - 1, j};
    int[] bo = {i + 1, j};
    int[] lf = {i, j - 1};
    int[] rg = {i, j + 1};

    int srcUF = getUFPos(i, j);
    int upUF = getUFPos(up[0], up[1]);
    int boUF = getUFPos(bo[0], bo[1]);
    int lfUF = getUFPos(lf[0], lf[1]);
    int rgUF = getUFPos(rg[0], rg[1]);

    if (validPos(up[0], up[1]) && grid[up[0]][up[1]] == 0) {
      UF.union(srcUF, upUF);
    }
    if (validPos(bo[0], bo[1]) && grid[bo[0]][bo[1]] == 0) {
      UF.union(srcUF, boUF);
    }
    if (validPos(lf[0], lf[1]) && grid[lf[0]][lf[1]] == 0) {
      UF.union(srcUF, lfUF);
    }
    if (validPos(rg[0], rg[1]) && grid[rg[0]][rg[1]] == 0) {
      UF.union(srcUF, rgUF);
    }
  }

  // com.codingpan.test client (optional)
  public static void main(String[] args) {
    //        StdOut.println("Enter file name:");
    //
    //        while (!StdIn.isEmpty()) {
    //            String name = StdIn.readLine();
    //            In in = new In(name);
    //            int N = in.readInt();
    //
    //            while (!in.isEmpty()) {
    //                int p = in.readInt();
    //                int q = in.readInt();
    //            }
    //            StdOut.println("Quick Union union time: " + N);
    //
    //        }
  }
}
