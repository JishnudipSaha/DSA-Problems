package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GraphList{
    int vertices;
    ArrayList<ArrayList<Integer>> adjList;
    GraphList(int v){
        this.vertices = v; 
        adjList = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adjList.add(new ArrayList<>());
        }
    }
    void addEdge(int src, int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // remove for directed graph
    }
    void printGraph(){
        for(int i = 0; i < vertices; i++){
            System.out.print(i + " -> ");
            for(int neighbour: adjList.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
    void bfs(int start){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for(int neighbour: adjList.get(node)){
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }
}


public class BFSTraversal {
    public static void main(String[] args) {
        int vertices = 5; // total number/s of nodes
        GraphList graphList = new GraphList(vertices);

        // Undirected graph
        graphList.addEdge(0, 1);
        graphList.addEdge(1, 2);
        graphList.addEdge(1, 3);
        graphList.addEdge(2, 4);

        graphList.bfs(0);
    }
}
