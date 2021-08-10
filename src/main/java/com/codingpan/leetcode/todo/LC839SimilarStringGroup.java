package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class LC839SimilarStringGroup {
  public int numSimilarGroups(String[] A) {
    UF uf = new UF(A.length);
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A.length; j++) {
        if (uf.connected(i, j)) continue;
        if (isSimilar(A[i], A[j])) {
          uf.union(i, j);
        }
      }
    }

    return uf.count();
  }

  private boolean isSimilar(String s, String t) {
    if (s.equals(t)) {
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < s.length(); i++) {
        set.add(s.charAt(i));
      }
      return set.size() < s.length();
    } else {
      int l = 0, r = 0;
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != t.charAt(i)) {
          count++;
          if (count == 1) {
            l = i;
          } else {
            r = i;
          }
        }
        if (count > 2) return false;
      }
      return (count == 2) && (s.charAt(l) == t.charAt(r)) && (s.charAt(r) == t.charAt(l));
    }
  }

  class UF {
    int count;
    int[] id;
    int[] size;

    public UF(int N) {
      count = N;
      id = new int[N];
      size = new int[N];
      for (int i = 0; i < N; i++) {
        id[i] = i;
        size[i] = 1;
      }
    }

    public int count() {
      return count;
    }

    public boolean connected(int p, int q) {
      return root(p) == root(q);
    }

    public void union(int p, int q) {
      int i = root(p);
      int j = root(q);
      if (i == j) return;

      if (size[i] < size[j]) {
        id[i] = j;
        size[j] += size[i];
      } else {
        id[j] = i;
        size[i] += size[j];
      }
      count--;
    }

    private int root(int i) {
      while (i != id[i]) {
        id[i] = id[id[i]];
        i = id[i];
      }
      return i;
    }
  }

  // solution 2 dfs
  //    public int numSimilarGroups(String[] A) {
  //        int count = 0;
  //        for(int index = 0; index < A.length; index ++){
  //            if(!A[index].equals("")){
  //                dfs(A, index);
  //                count ++;
  //            }
  //        }
  //        return count;
  //    }
  //
  //    private void dfs(String[] A, int parent){
  //        String compare = A[parent];
  //        A[parent] = "";
  //        for(int index = 0; index < A.length; index ++){
  //            if(!A[index].equals("") && similar(A, index, compare)){
  //                dfs(A, index);
  //            }
  //        }
  //    }
  //
  //    private boolean similar(String[] A, int j, String compare){
  //        int count = 0;
  //        for(int index = 0; index < compare.length(); index ++){
  //            if(compare.charAt(index) != A[j].charAt(index)){
  //                count++;
  //                if(count == 3){
  //                    return false;
  //                }
  //            }
  //        }
  //        return true;
  //    }

  public static void main(String[] args) {
    LC839SimilarStringGroup solu = new LC839SimilarStringGroup();
    // String[] A = {"tars","rats","arts","star"};
    String[] A = {
      "kccomwcgcs",
      "socgcmcwkc",
      "sgckwcmcoc",
      "coswcmcgkc",
      "cowkccmsgc",
      "cosgmccwkc",
      "sgmkwcccoc",
      "coswmccgkc",
      "kowcccmsgc",
      "kgcomwcccs"
    };
    StdOut.println(solu.numSimilarGroups(A));
  }
}
