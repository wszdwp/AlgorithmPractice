package com.codingpan.leetcode.todo;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

  private List<int[]> books = new ArrayList<>();

  public boolean book(int start, int end) {
    return checkEveryOverlap(start, end);
  }

  // overlap of 2 interval a b is (max(a0, b0), min(a1, b1))
  private boolean checkEveryOverlap(int start, int end) {
    for (int[] b : books) if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
    books.add(new int[] {start, end});
    return true;
  }

  // MinWindowSubString 2:
  // Keep existing books sorted and only check 2 books start right before & after the new book
  // starts
  // Another way to check overlap of 2 intervals is a started with b, or, b started within a.
  //
  // Keep the intervals sorted,
  // if the interval started right before the new interval contains the start, or
  // if the interval started right after the new interval started within the new interval.

  // TreeSet
  //    TreeSet<int[]> books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);
  //
  //    public boolean book(int s, int e) {
  //        int[] book = new int[] { s, e }, floor = books.floor(book), ceiling =
  // books.ceiling(book);
  //        if (floor != null && s < floor[1]) return false; // (s, e) start within floor
  //        if (ceiling != null && ceiling[0] < e) return false; // ceiling start within (s, e)
  //        books.add(book);
  //        return true;
  //    }

}
