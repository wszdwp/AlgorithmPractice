package com.codingpan.algm1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private Percolation percolation;
    private int trials;
    private int[] trialResults;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <=0 ) throw new IllegalArgumentException("Invalid n: " + n + " trials: " + trials);
        percolation = new Percolation(n);
        this.trials = n;

        trialResults = new int[trials];
        int i = 0;
        while (i < trials) {
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                percolation.open(row, col);
            }
            trialResults[i] = percolation.numberOfOpenSites();
            i++;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(trialResults);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
//        double mean = mean();
//        int sum = 0;
//        for (int i = 0; i < trials; i++) {
//            sum += Math.pow(trialResults[i]-mean, 2);
//        }
//        return Math.sqrt(sum / (trials-1));

        return StdStats.stddev(trialResults);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        double mean = StdStats.mean(trialResults);
        double stddev = StdStats.stddev(trialResults);
        return mean - (1.96 * stddev) / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double mean = StdStats.mean(trialResults);
        double stddev = StdStats.stddev(trialResults);
        return mean + (1.96 * stddev) / Math.sqrt(trials);
    }

    // com.codingpan.test client (described below)
    public static void main(String[] args) {

    }

}
