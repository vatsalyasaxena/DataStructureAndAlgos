package com.ds_and_algo.leetcode.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphBfs {
    private int vertices;
    private List<Integer> adj [];

    GraphBfs(int v){
        vertices = v;
        adj = new LinkedList[vertices];
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int e){
        adj[v].add(e);
    }

    //Passed start of graph
    void BFS(int s){
        boolean[] visited = new boolean[vertices];
        //queue to hold index of visited
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while(queue.size() > 0){
            s = queue.poll();
            System.out.println(" s "+ s);
            Iterator<Integer> iter = adj[s].listIterator();
            while(iter.hasNext()){
                int n = iter.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFS(int index, boolean [] visited){
        visited[index] = true;
        System.out.println("s "+ index);
        Iterator<Integer> i =  adj[index].listIterator();
        while(i.hasNext()){
            int in = i.next();
            if (!visited[in])
                DFS(in, visited);
        }
    }

    public static void main(String[] args) {
        GraphBfs g = new GraphBfs(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        //g.BFS(0);
        boolean[] visited = new boolean[4];

        g.DFS(2,visited);
    }
}
