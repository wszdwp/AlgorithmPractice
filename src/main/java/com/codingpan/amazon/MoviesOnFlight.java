package com.codingpan.amazon;

import com.codingpan.leetcode.util.Utility;

import java.util.Arrays;

public class MoviesOnFlight {
    public int[] getLongestPair(int[] movieDuration, int flightDuration) {
        return twoSumCloest(movieDuration, flightDuration);
    }

    // solu: sort and two pointer
    private int[] twoSumCloest(int[] movies, int flight) {
        if (flight - 30 < 0) return new int[2];
        int[] ans = new int[2];
        final int LIMIT = flight - 30;
        Arrays.sort(movies);
        int l = 0, r = movies.length - 1;
        while (l < r) {
            int duration = movies[l] + movies[r];
            if (duration > LIMIT) {
                --r;
            } else if (duration < LIMIT) {
                if (ans[1] + ans[0] < duration) {
                    ans[0] = movies[l];
                    ans[1] = movies[r];
                }
                l++;
            } else {
                ans[0] = movies[l];
                ans[1] = movies[r];
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MoviesOnFlight test = new MoviesOnFlight();
//        int[] movies = {90, 85, 75, 60, 120, 150, 125};
//        int d = 250;

        int[] movies = {90, 80, 90, 130, 110};
        int d = 250;
        int[] ans = test.getLongestPair(movies, d);
        Utility.printArray(ans);
    }
}
