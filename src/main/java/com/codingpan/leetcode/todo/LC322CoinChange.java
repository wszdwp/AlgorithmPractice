package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC322CoinChange {
  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount < 0) return 0;
    int[][] waysMap = new int[coins.length + 1][amount + 1];
    double startTime = 0.0;
    double endTime = 0.0;
    int ans = 0;

    // recursion
    //        StdOut.print("Brute  force: ");
    //        startTime = System.currentTimeMillis();
    //        ans = recursiveBrute(coins, 0, amount);
    //        endTime = System.currentTimeMillis();
    //        StdOut.println("ans=" + ans + " running time: " + (endTime-startTime)/1000 + "
    // seconds");

    StdOut.print("Memorization: ");
    startTime = System.currentTimeMillis();
    ans = recursiveWithMemorization(coins, 0, amount, waysMap);
    endTime = System.currentTimeMillis();
    StdOut.println("ans=" + ans + " running time: " + (endTime - startTime) + " ms");

    // DP
    StdOut.print("DP  Solution1: ");
    startTime = System.currentTimeMillis();
    ans = dpVersion1(coins, amount);
    endTime = System.currentTimeMillis();
    StdOut.println("ans=" + ans + " running time: " + (endTime - startTime) + " ms");

    StdOut.print("DP  Solution2: ");
    startTime = System.currentTimeMillis();
    ans = dpVersion2(coins, amount);
    endTime = System.currentTimeMillis();
    StdOut.println("ans=" + ans + " running time: " + (endTime - startTime) + " ms");

    StdOut.print("DP  Solution3: ");
    startTime = System.currentTimeMillis();
    ans = dpVersion3(coins, amount);
    endTime = System.currentTimeMillis();
    StdOut.println("ans=" + ans + " running time: " + (endTime - startTime) + " ms");

    return ans;
  }

  private int recursiveBrute(int[] coins, int index, int amount) {
    int res = 0;
    if (index == coins.length) {
      res = (amount == 0) ? 1 : 0;
    } else {
      for (int i = 0; coins[index] * i <= amount; i++) {
        res += recursiveBrute(coins, index + 1, amount - coins[index] * i);
      }
    }
    return res;
  }

  private int recursiveWithMemorization(int[] coins, int index, int amount, int[][] waysMap) {
    int res = 0;
    if (index == coins.length) {
      res = (amount == 0) ? 1 : 0;
    } else {
      int mapValue;
      for (int i = 0; coins[index] * i <= amount; i++) {
        mapValue = waysMap[index + 1][amount - coins[index] * i];
        if (mapValue != 0) {
          res += (mapValue == -1) ? 0 : mapValue;
        } else {
          res += recursiveWithMemorization(coins, index + 1, amount - coins[index] * i, waysMap);
        }
      }
    }
    waysMap[index][amount] = (res == 0) ? -1 : res;
    return res;
  }

  private int dpVersion1(int[] coins, int amount) {
    int[][] dp = new int[coins.length][amount + 1];
    for (int i = 0; i < coins.length; i++) {
      dp[i][0] = 1;
    }
    for (int j = 1; coins[0] * j <= amount; j++) {
      dp[0][coins[0] * j] = 1;
    }
    int nums = 0;
    for (int i = 1; i < coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        nums = 0;
        for (int k = 0; j - coins[i] * k >= 0; k++) {
          nums += dp[i - 1][j - coins[i] * k];
        }
        dp[i][j] = nums;
      }
    }
    return dp[coins.length - 1][amount];
  }

  private int dpVersion2(int[] coins, int amount) {
    int[][] dp = new int[coins.length][amount + 1];
    for (int i = 0; i < coins.length; i++) {
      dp[i][0] = 1;
    }
    for (int j = 1; coins[0] * j <= amount; j++) {
      dp[0][coins[0] * j] = 1;
    }
    for (int i = 1; i < coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        dp[i][j] = dp[i - 1][j];
        dp[i][j] += (j - coins[i] >= 0) ? dp[i][j - coins[i]] : 0;
      }
    }
    return dp[coins.length - 1][amount];
  }

  private int dpVersion3(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int j = 0; coins[0] * j <= amount; j++) {
      dp[coins[0] * j] = 1;
    }
    for (int i = 1; i < coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        dp[j] += j - coins[i] >= 0 ? dp[j - coins[i]] : 0;
      }
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    LC322CoinChange solu = new LC322CoinChange();
    int[] coins = {5, 10, 25, 1};
    int amount = 2863;
    StdOut.println("benchmark tests");
    solu.coinChange(coins, amount);
  }
}
