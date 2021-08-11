package com.codingpan.amazon;

import edu.princeton.cs.algs4.StdOut;

import java.util.PriorityQueue;

public class AssemblyParts {
    public int minTimeToAssembly(int[] partsTime) {
        if (partsTime.length == 0) return 0;
        if (partsTime.length == 1) return partsTime[0];
        if (partsTime.length == 2) return partsTime[0] + partsTime[1];
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int time : partsTime) {
            pq.offer(time);
        }
        while (!pq.isEmpty()) {
            int time1 = pq.poll();
            int time2 = pq.poll();
            int sum = time1 + time2;
            total += sum;
            if (!pq.isEmpty()) {
                pq.offer(sum);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        AssemblyParts test = new AssemblyParts();
        // int[] partsTime = {8, 4, 6, 12};
        int[] partsTime = {8, 4, 6, 12, 16};

        StdOut.println(test.minTimeToAssembly(partsTime));
    }
}
