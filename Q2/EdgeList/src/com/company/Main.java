package com.company;

import java.util.LinkedList;

public class Main {
    private int V;
    private LinkedList<Edge> edgeList;

    public Main(int v) {
        V = v;
        edgeList = new LinkedList<Edge>();
    }

    public void addEdge(int v, int w) {
        edgeList.add(new Edge(v, w));
    }

    public void printGraph() {
        for (Edge edge : edgeList) {
            System.out.println("Edge (" + edge.v + ", " + edge.w + ")");
        }
    }

    private static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Main g = new Main(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.printGraph();
    }
}