package com.codingpan.ms;

import edu.princeton.cs.algs4.Bag;

public class MSGrapth {
  private final int V;
  private int E;
  private Bag<Integer>[] adj;

  public MSGrapth(int V) {
    this.V = V;
    this.E = 0;
    adj = (Bag<Integer>[]) new Bag[V];
    for (int v = 0; v < V; v++) {
      adj[v] = new Bag<Integer>();
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(int v, int w) {
    validateVertex(v);
    validateVertex(w);
    E++;
    adj[v].add(w);
    adj[w].add(v);
  }

  public Iterable<Integer> adj(int v) {
    validateVertex(v);
    return adj[v];
  }

  public int degree(int v) {
    validateVertex(v);
    return adj[v].size();
  }

  private void validateVertex(int v) {
    if (v < 0 || v >= V) {
      throw new IllegalArgumentException("vertext " + v + " is not between 0 and " + (V - 1));
    }
  }
}
