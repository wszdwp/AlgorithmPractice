package com.codingpan.fb;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortingDemo {
  public static void sortMeetingIntervals(int[][] intervals) {
    Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] itv1, int[] itv2) {
            if (itv1[0] == itv2[0]) return itv1[1] - itv2[1];
            return itv1[0] - itv2[0];
          }
        });
  }

  public static int minMeetingRooms(int[][] intervals) {
    int ans = 0;
    final int N = intervals.length;
    Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] itv1, int[] itv2) {
            if (itv1[0] == itv2[0]) return itv1[1] - itv2[1];
            return itv1[0] - itv2[0];
          }
        });
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int[] interval : intervals) {
      if (pq.isEmpty()) {
        pq.offer(interval[1]);
        ++ans;
      } else {
        if (interval[0] >= pq.peek()) {
          pq.poll();
        } else {
          ++ans;
        }
        pq.offer(interval[1]);
      }
    }
    return ans;
  }

  public static void printInterval(int[][] intervals) {
    for (int[] interval : intervals) {
      StdOut.println("[" + interval[0] + ", " + interval[1] + "]");
    }
  }

  public static void main(String[] args) {
    int[][] intervals = {
      {4, 9},
      {4, 17},
      {9, 10}
    };
    printInterval(intervals);
    sortMeetingIntervals(intervals);
    printInterval(intervals);
    int ans = minMeetingRooms(intervals);
    StdOut.println("ans = " + ans);
  }
}
