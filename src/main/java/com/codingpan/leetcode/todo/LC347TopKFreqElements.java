package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC347TopKFreqElements {
  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> ans = new ArrayList<>();
    if (nums.length == 0 || k <= 0) return ans;

    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      if (map.containsKey(n)) {
        map.put(n, map.get(n) + 1);
      } else {
        map.put(n, 1);
      }
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(k, new MyComparator(map));
    for (int n : map.keySet()) {
      pq.offer(n);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    while (!pq.isEmpty()) {
      ans.add(pq.poll());
    }
    return ans;
  }

  public class MyComparator implements Comparator<Integer> {
    Map<Integer, Integer> map = new HashMap<>();

    public MyComparator(Map<Integer, Integer> map) {
      this.map = map;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
      return map.get(o1) - map.get(o2);
    }
  }

  public static void main(String[] args) {
    LC347TopKFreqElements solu = new LC347TopKFreqElements();

    int[] nums = {1, 1, 1, 2, 2, 3};
    int k = 2;
    //        int[] nums = {1};
    //        int k = 1;
    StdOut.println(solu.topKFrequent(nums, k));
  }
}
