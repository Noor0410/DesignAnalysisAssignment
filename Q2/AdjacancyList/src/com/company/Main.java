package com.company;
import java.util.LinkedList;

public class Main {

    private int V;
    private LinkedList<Integer>[] adjList;

    Main(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v);
    }

    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int w : adjList[i]) {
                System.out.print(w + " ");
            }
            System.out.println();
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