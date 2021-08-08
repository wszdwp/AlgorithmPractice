package com.codingpan.ms;

import edu.princeton.cs.algs4.StdOut;

public class MSCC {
    private boolean[] marked;   // marked[v] = has vertex v been marked?
    private int[] id;           // company[v] = company of connected component containing v
    private int[] size;         // num of vertices in given component
    private int count;          // num of connected components

    public MSCC(MSGrapth G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(MSGrapth G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }

    public int count() {
        return count;
    }

    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public static void main(String[] args) {
        MSGrapth G = new MSGrapth(10);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(4, 5);
        G.addEdge(1, 4);
        G.addEdge(7, 8);
        G.addEdge(8, 9);
        MSCC msCC = new MSCC(G);
        //StdOut.println(msCC.count());

    }

}
