package com.codingpan.gg;

public class NextClosestTime {
    // brute force
    public String nextClosestTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        while (true) {
            if (++min == 60) {
                min = 0;
                ++hour;
                hour %= 24;
            }
            String curr = String.format("%02d:%02d", hour, min);
            boolean valid = true;
            for (int i = 0; i < curr.length(); i++) {
                if (time.indexOf(curr.charAt(i)) < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) return curr;
        }
    }

    // dfs O(4^4)
    public String dfsNextClosestTime(String time) {
        return "";
    }

    private int toTime(int h, int m) {
        return h * 60 + m;
    }

    private int timeDiff(int t1, int t2) {
        if (t1 == t2) return Integer.MAX_VALUE; // 1440 (24 hrs)
        return ((t2 - t1) + 24 * 60) % (24 * 60);
    }

    // 3. 想贡献一个新的解法
    // （假设初始是h1h2:m1m2)，第一步在m1m2到59之间，
    // 看能不能找到一个最小两位数能用h1,h2,m1,m2来表达，
    // 如果可以，就是解。
    // 第二步，在h1h2+1到h1h2+24（超过24减24来表达）之间找到一个两位数可以用h1h2,m1m2来表达，
    // 然后在00，m1m2中找到最小两位数可以用h1,h2,m1,m2来表达，这个就是解。﻿
}
