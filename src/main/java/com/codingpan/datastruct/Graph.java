package com.codingpan.datastruct;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int V;
    private Bag<Integer>[] adj;
    /**
     * Create an empty graph with V vertices
     * @param V
     */
    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

//    /**
//     * Create a graph from input stream
//     * @param in
//     */
//    public Graph(In in) {
//    }

    /**
     * add an edge v-w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * vertices adjacent to v
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * number of vertices
     * @return
     */
    public int V() {
        return V;
    }

    /**
     * number of edges
     * @return
     */
    public int E() {
        int count = 0;
        for (int v = 0; v < V;  v++) {
            for (int w : adj[v]) {
                count++;
            }
        }
        return count / 2;   // each edge counted twice
    }

    /**
     * string representation
     * @return
     */
    public String toString() {
        return "";
    }

    /**
     * compute the degree of v
     * @param G
     * @param v
     * @return
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) { degree++; }
        return degree;
    }

    /**
     * compute the maximum degree
     * @param G
     * @return
     */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    /**
     * compute average degree
     * @param G
     * @return
     */
    public static double averageDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /**
     * count self-loops
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) { count++; }
            }
        }
        return count / 2;   // each edge counted twice
    }
}
