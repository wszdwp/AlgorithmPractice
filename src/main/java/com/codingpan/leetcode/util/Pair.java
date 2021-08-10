package com.codingpan.leetcode.util;

public class Pair<T> {
  private T first;
  private T second;

  public Pair() {
    first = null;
    second = null;
  }

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }

  public void setFirst(T newFirst) {
    first = newFirst;
  }

  public void setSecond(T newSecond) {
    second = newSecond;
  }

  public static <T> T getMiddle(T[] a) {
    return a[a.length / 2];
  }

  public static <T extends Comparable> T getMin(T[] a) {
    if (a == null || a.length == 0) {
      return null;
    }
    T smallest = a[0];
    for (int i = 1; i < a.length; i++) {
      if (smallest.compareTo(a[i]) > 0) {
        smallest = a[i];
      }
    }

    return smallest;
  }
}
