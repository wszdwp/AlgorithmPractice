package com.codingpan.algm1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private static final int QF = 0;
    private static final int QU = 1;
    private static final int WU = 2;

    private int type;
    private QuickFindUF qf;
    private QuickUnionUF qu;
    private WeightedQuickUnionUF wu;

    public UF(int N, int type) {
        if (N < 0 || type < 0 || type > 3) {
            throw new IllegalArgumentException("Illegal Arguments N " + N + " type " + type);
        }
        this.type = type;
        if (type == QF) {
            qf = new QuickFindUF(N);
        }
        else if (type == QU) {
            qu = new QuickUnionUF(N);
        }
        else if (type == WU) {
            wu = new WeightedQuickUnionUF(N);
        }
    }

    public void union(int p, int q) {
        if (type == QF) {
            qf.union(p, q);
        }
        else if (type == QU) {
            qu.union(p, q);
        }
        else if (type == WU) {
            wu.union(p, q);
        }
    }

    public boolean connected(int p, int q) {
        boolean isConnected = false;
        if (type == QF) {
            isConnected = qf.connected(p, q);
        }
        else if (type == QU) {
            isConnected = qu.connected(p, q);
        }
        else if (type == WU) {
            isConnected = wu.connected(p, q);
        }
        return isConnected;
    }

    public int count() {
        int count = 0;
        if (type == QF) {
            count = qf.count();
        }
        else if (type == QU) {
            count = qu.count();
        }
        else {
            count = wu.count();
        }
        return count;
    }

    public static void main(String[] args) {
        StdOut.println("Enter file name:");

        while (!StdIn.isEmpty()) {
            String name = StdIn.readLine();
            In in = new In(name);
            int N = in.readInt();

//            UF uf1 = new UF(N, QF);
            UF uf2 = new UF(N, QU);
            UF uf3 = new UF(N, WU);

            double ts1 = System.currentTimeMillis();
            double ts2;
//            while (!in.isEmpty()) {
//                int p = in.readInt();
//                int q = in.readInt();
//                if (!uf1.connected(p, q)) {
//                    uf1.union(p, q);
//                    StdOut.println(p + "-" + q);
//                }
//            }
//            ts2 = System.currentTimeMillis();
//            StdOut.println("Quick Find union time: " + (ts2 - ts1));

            ts1 = System.currentTimeMillis();
            ts2 = System.currentTimeMillis();
            while (!in.isEmpty()) {
                int p = in.readInt();
                int q = in.readInt();
                if (!uf2.connected(p, q)) {
                    uf2.union(p, q);
                    StdOut.println(p + "-" + q);
                }
            }
            ts2 = System.currentTimeMillis();
            StdOut.println("Quick Union union time: " + (ts2 - ts1));

            ts1 = System.currentTimeMillis();
            ts2 = System.currentTimeMillis();
            while (!in.isEmpty()) {
                int p = in.readInt();
                int q = in.readInt();

                if (!uf3.connected(p, q)) {
                    uf3.union(p, q);
                    StdOut.println(p + "-" + q);
                }
            }
            ts2 = System.currentTimeMillis();
            StdOut.println("Weighted Quick Union union time: " + (ts2 - ts1));
        }
    }
}