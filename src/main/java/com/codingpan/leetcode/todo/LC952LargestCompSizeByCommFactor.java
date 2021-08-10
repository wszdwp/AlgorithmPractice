package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC952LargestCompSizeByCommFactor {
  public int largestComponentSize(int[] A) {
    int N = 0;
    for (int a : A) N = Math.max(a, N);
    UF uf = new UF(N + 1);
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        if (hasEdge(A[i], A[j])) {
          uf.union(A[i], A[j]);
        }
      }
    }
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        StdOut.println(
            A[i] + " " + A[j] + (uf.connected(A[i], A[j]) ? " Connected" : " Not Connected"));
      }
    }
    StdOut.println("uf count = " + uf.count);
    return uf.maxSize();
  }

  private class UF {
    private int[] id;
    private int[] sz;
    private int count;
    private int N;
    private int maxSize;

    public UF(int N) {
      this.N = N;
      this.count = N;
      this.id = new int[N];
      this.sz = new int[N];
      this.maxSize = 1;
      for (int i = 0; i < N; i++) {
        id[i] = i;
        sz[i] = 1;
      }
    }

    public int maxSize() {
      return maxSize;
    }

    public int count() {
      return count;
    }

    public void union(int p, int q) {
      int pId = find(p);
      int qId = find(q);
      if (pId == qId) return;
      if (sz[pId] < sz[qId]) {
        id[pId] = qId;
        sz[qId] += sz[pId];
        maxSize = Math.max(maxSize, sz[qId]);
      } else {
        id[qId] = pId;
        sz[pId] += sz[qId];
        maxSize = Math.max(maxSize, sz[pId]);
      }
      count--;
    }

    public int find(int p) {
      while (p != id[p]) {
        p = id[p];
      }
      return p;
    }

    public boolean connected(int p, int q) {
      return find(p) == find(q);
    }
  }

  private boolean hasEdge(int a, int b) {
    int gcd = gcd(a, b);
    // StdOut.println("gcd of " + a + ", " + b + " is " + gcd);
    return gcd > 1;
    //        int lcm = lcm(a, b, gcd);
    //        //StdOut.println("lcm of " + a + ", " + b + " is " + lcm);
    //        return lcm > 1 && lcm <= a && lcm <= b;
  }

  private int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  private int lcm(int a, int b, int gcd) {
    if (a == 0 || b == 0) {
      return 0;
    }
    return (a * b) / gcd(a, b);
  }

  public static void main(String[] args) {
    LC952LargestCompSizeByCommFactor solu = new LC952LargestCompSizeByCommFactor();
    //        int[] inp = {2,3,6,7,4,12,21,39};
    int[] inp = {20, 50, 9, 63};
    int ans = solu.largestComponentSize(inp);
    StdOut.println("ans = " + ans);
  }
}
