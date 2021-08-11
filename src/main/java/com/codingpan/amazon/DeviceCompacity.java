package com.codingpan.amazon;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DeviceCompacity {
    /**
     * 第二题就是 DeviceCapacity。 Input类似是这样 front = [[1,3000],[2,5000],[3,7000],[4,10000]]； back
     * =[[1,2000],[2,3000],[3,4000],[4,5000]]， Capacity = 10000, 要求就是所有front & back
     * 的combination中最大的且<= Capacity的id number。 像这个Input就要output出 [[2,4],[3,2]]。
     * 是的要考虑有可能有相同最多的且Valid的Capacity的组合。 还有另外一个情景就是那个Amazon Air的Optimal
     * 距离。也是给两个list，然后return最optimal的组合。 个人用的是暴力解，由于因为一定要从两个list中各取一个，lz觉得暴力解最直接， 也不会让code看起来too
     * complicated。如果有大神有更好的解法，欢迎讨论！
     */
    // O(N^2)
    //    public LinkedList<Pair> getCapacityPair(int[] front, int[] back, int capacity) {
    //        LinkedList<Pair> ans = new LinkedList<>();
    //
    //        for (int i = 0; i < front.length; i++) {
    //            for (int j = 0; j < back.length; j++) {
    //                int sum = front[i] + back[j];
    //                if (sum <= capacity) {
    //                    while (!ans.isEmpty() && front[ans.peekLast().x - 1] + back[ans.peekLast().y
    // - 1] < sum) {
    //                        ans.pollLast();
    //                    }
    //                    ans.addLast(new Pair(i + 1, j + 1));
    //                }
    //            }
    //        }
    //        return ans;
    //    }

    // O(NlgN)
    public LinkedList<Pair> getCapacityPair(int[] front, int[] back, int capacity) {
        LinkedList<Pair> ans = new LinkedList<>();
        Arrays.sort(back);
        for (int i = 0; i < front.length; i++) {
            int j = binarySearchLowerBound(back, capacity - front[i]);
            StdOut.println("j = " + j);
            if (j < 0 || j >= back.length) continue;
            int sum = front[i] + back[j];
            if (sum <= capacity) {
                while (!ans.isEmpty() && front[ans.peekLast().x - 1] + back[ans.peekLast().y - 1] < sum) {
                    ans.pollLast();
                }
                ans.addLast(new Pair(i + 1, j + 1));
            }
        }
        return ans;
    }

    private int binarySearchLowerBound(int[] arr, int key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= key) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        DeviceCompacity solu = new DeviceCompacity();
        int[] front = {3000, 5000, 7000, 10000};
        int[] back = {2000, 3000, 4000, 5000};
        int capacity = 10000;
        List<Pair> ans = solu.getCapacityPair(front, back, capacity);
        for (Pair p : ans) {
            StdOut.println(p.x + ", " + p.y);
        }
    }
}
