package com.codingpan.bestsolubook;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class RecursionDP {

    public static int findChangeWays(int[] arr, int aim) {
        int ans = 0;
        double time = System.currentTimeMillis();
//        ans = bruteRecursiveSearch(arr, 0, aim);
//        time = System.currentTimeMillis()-time;
//        System.out.println("1 time = " + time + " ans = " + ans);

        int[][] cache = new int[arr.length+1][aim+1];
        time = System.currentTimeMillis();
        ans = cacheRecursiveSearch(arr, 0, aim, cache);
        time= System.currentTimeMillis() - time;
        System.out.println("2 time = " + time + " ans = " + ans);

        return ans;
    }

    public static int bruteRecursiveSearch(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length ) {
            res = (aim == 0) ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += bruteRecursiveSearch(arr, index +1, aim-arr[index]*i);
            }
        }
        return res;
    }

    public static int cacheRecursiveSearch(int[] arr, int index, int aim, int[][] cache) {
        int res = 0;
        if (index == arr.length) {
            res = (aim == 0) ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index]*i <= aim; i++) {
                mapValue = cache[index+1][aim-arr[index]*i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += cacheRecursiveSearch(arr, index + 1, aim - arr[index]*i, cache);
                }
            }
        }
        cache[index][aim] = (res == 0) ? -1 : res;
        return res;
    }

//    public int coinChange(int[] coins, int amount) {
//        if (coins == null || coins.length == 0 || amount < 0) return 0;
//        List<List<Integer>> res = new ArrayList<>();
//        helper(coins, 0, amount, new ArrayList<Integer>(), res);
//        int minCount = Integer.MAX_VALUE;
//        for (List<Integer> one : res) {
//            int total = 0;
//            for (Integer count : one) total += count;
//            minCount = Math.min(total, minCount);
//        }
//        return minCount == 0 ? -1 : minCount;
//    }
//
//    private void helper(int[] coins, int start, int amount, List<Integer> one, List<List<Integer>> res) {
//        if (amount == 0) {
//            Utility.printList(one);
//            res.add(new ArrayList<Integer>(one));
//        } else {
//            if (start >= coins.length || amount < 0) return;
//            for (int i = 1; amount - i * coins[start] >= 0 ; i++) {
//                one.add(i);
//                helper(coins, start+1, amount-coins[start]*i, one, res);
//                one.remove(one.size()-1);
//            }
//        }
//    }
//    public int coinChange(int[] coins, int amount) {
//        if (coins == null || coins.length == 0 || amount < 0) return 0;
//        List<List<Integer>> res = new ArrayList<>();
//        process(coins, 0, amount, new ArrayList<Integer>(), res);
//        int minCount = Integer.MAX_VALUE;
//        for (List<Integer> one : res) {
//            int total = 0;
//            for (Integer count : one) total += count;
//            minCount = Math.min(total, minCount);
//        }
//        return minCount == 0 ? -1 : minCount;
//    }
//
//    private void process(int[] coins, int index, int amount, List<Integer> one, List<List<Integer>> res) {
//        if (index == coins.length || amount == 0) {
//            if (amount == 0) {
//                Utility.printList(one);
//                res.add(new ArrayList<Integer>(one));
//            }
//        } else {
//            if (index >= coins.length || amount < 0) return;
//            for (int i = 1; amount - i * coins[index] >= 0 ; i++) {
//                one.add(i);
//                process(coins, index+1, amount-coins[index]*i, one, res);
//                one.remove(one.size()-1);
//            }
//        }
//    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return 0;
        List<List<Integer>> res = new ArrayList<>();
        int[][] wayMap = new int[coins.length+1][amount+1];
        process2(coins, 0, amount, wayMap, new ArrayList<Integer>(), res);
        int minCount = Integer.MAX_VALUE;
        for (List<Integer> one : res) {
            int total = 0;
            for (Integer count : one) total += count;
            minCount = Math.min(total, minCount);
        }
        return minCount == 0 ? -1 : minCount;
    }

    private void process2(int[] coins, int index, int amount, int[][] wayMap, List<Integer> one, List<List<Integer>> res) {
        if (amount == 0) {
            Utility.printList(one);
            res.add(new ArrayList<Integer>(one));
        } else {
            if (index >= coins.length || amount < 0) {
                return;
            }
            for (int i = 1; amount - i * coins[index] >= 0 ; i++) {
                one.add(i);
                if (wayMap[index+1][amount-coins[index]*i] == 0) {
                    process2(coins, index + 1, amount - coins[index] * i, wayMap, one, res);
                } else {
                   if(wayMap[index+1][amount-coins[index]*i] != -1) {
                       //one.add()
                   }
                }
                one.remove(one.size()-1);
            }
        }
    }


    public static void main(String[] args) {
//        int[] arr = {5, 10, 25, 1};
//        int aim = 1000;
//        int[] arr = {20000, 10000, 1000};
//        int aim = 2000000000;
//        int ans = findChangeWays(arr, aim);
//        System.out.println("142511 : " + ans);
        RecursionDP solu = new RecursionDP();

        int[] coins = {1, 2, 5};
        int amount = 11;
        int minCount = solu.coinChange(coins, amount);
        StdOut.println("minCount = " + minCount);

    }
}
