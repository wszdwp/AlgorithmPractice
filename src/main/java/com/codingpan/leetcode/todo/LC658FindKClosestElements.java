package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class LC658FindKClosestElements {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> res = new ArrayList<>();
    if (arr == null || arr.length == 0 || k <= 0) return res;
    int lo = 0, hi = arr.length - k;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (x - arr[mid] > arr[mid + k] - x) lo = mid + 1;
      else hi = mid;
    }
    for (int i = lo; i < lo + k; i++) {
      res.add(arr[i]);
    }
    return res;
  }

  private int binarySearch(int[] arr, int l, int r, int x) {
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (arr[m] == x) return l;
      else if (arr[m] < x) l = m + 1;
      else r = m - 1;
    }
    return l;
  }

  public static void main(String[] args) {
    LC658FindKClosestElements solu = new LC658FindKClosestElements();

    int[] arr = {1, 2, 3, 4, 5};
    int k = 4;
    int x = 5;

    List<Integer> res = solu.findClosestElements(arr, k, x);
    Utility.printList(res);

    //        int[] cases = {1, -1, 5, 4, 6};
    //        for (int i : cases) {
    //            StdOut.println(solu.binarySearch(arr, 0, arr.length - 1, i));
    //        }
  }
}
