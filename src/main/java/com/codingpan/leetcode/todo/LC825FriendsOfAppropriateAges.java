package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

/**
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of
 * the ith person. Person A will NOT friend request person B (B != A) if any of the following
 * conditions are true: age[B] <= 0.5 * age[A] + 7 age[B] > age[A] age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B. Note that if A requests B, B does not necessarily request A.
 * Also, people will not friend request themselves. How many total friend requests are made?
 */
public class LC825FriendsOfAppropriateAges {
    //    public int numFriendRequests(int[] ages) {
    //        int count = 0;
    //        for (int i = 0; i < ages.length; i++) {
    //            int p1 = ages[i];
    //            for (int j = i+1; j < ages.length; j++) {
    //                int p2 = ages[j];
    //                if (p2 <= 0.5 * p1 + 7 || p2 > p1 || p2 > 100 && p1 < 100) {
    //                } else {
    //                    count++;
    //                    StdOut.println(p1 + "->" + p2);
    //                }
    //                if (p1 <= 0.5 * p2 + 7 || p1 > p2 || p1 > 100 && p2 < 100) {
    //                } else {
    //                    count++;
    //                    StdOut.println("rev " + p2 + "->" + p1);
    //                }
    //            }
    //        }
    //
    //        return count;
    //    }

    public int numFriendRequests(int[] ages) {
        int[] f = new int[121];
        for (int v : ages) {
            f[v]++;
        }
        int ret = 0;
        for (int i = 0; i <= 120; i++) {
            for (int j = 0; j <= 120; j++) {
                if (j * 2 <= i + 14 || j > i || j > 100 && i < 100) {
                } else {
                    if (i == j) {
                        ret += f[i] * (f[i] - 1);
                    } else {
                        ret += f[i] * f[j];
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC825FriendsOfAppropriateAges solu = new LC825FriendsOfAppropriateAges();
        // int[] ages = {16, 16};      //2
        // int[] ages = {16,17,18};    //2
        int[] ages = {20, 30, 100, 110, 120}; // 3

        StdOut.println(solu.numFriendRequests(ages));
    }
}
