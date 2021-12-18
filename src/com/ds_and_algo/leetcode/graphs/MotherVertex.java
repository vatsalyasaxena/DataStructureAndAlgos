package com.ds_and_algo.leetcode.graphs;

import java.util.LinkedList;

public class MotherVertex {
    private int vertices;
    private LinkedList<Integer> adj[] ;

    MotherVertex(int size){
        vertices = size;
        adj = new LinkedList[vertices];
        for(int i=0;i<vertices;i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int s,int w){
        adj[s].add(w);
    }

    void dfsutil(int s,boolean[] visited){
        visited[s] = true;
        for(int a : adj[s]){
            if (!visited[a])
                dfsutil(a,visited);
        }
    }

    int motherVertex(LinkedList<Integer> [] adj,int v){
        boolean visited[] = new boolean[vertices];
        int res =-1;
        for(int i=0;i<v;i++){
            if (!visited[i]) {
                dfsutil(i, visited);
                res = i;
            }
        }
        boolean[] check = new boolean[v];
        dfsutil(res,check);
        for(boolean b : check){
            if (!b)
                res = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int V = 7;
        int E = 8;
        MotherVertex mv = new MotherVertex(V);

        mv.addEdge(0, 1);
        mv.addEdge(1, 3);
        mv.addEdge(4, 1);
        mv.addEdge(0, 2);
        mv.addEdge(6, 4);
        mv.addEdge(5, 6);
        mv.addEdge(5, 2);
        mv.addEdge(6, 0);

        System.out.println("The mother vertex is " +
                mv.motherVertex(mv.adj, V));
    }
}
