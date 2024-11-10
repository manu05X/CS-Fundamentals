package com.manish.DSA.Graph.Basic.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim()); // Number of test cases

        while(T-- > 0){
            String[] s = br.readLine().trim().split(" ");
            int vertex = Integer.parseInt(s[0]); // Number of vertices
            int edges = Integer.parseInt(s[1]); // Number of edges

            // Adjacency list representation of the graph
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            //Input no of vertices
            for(int i = 0; i < vertex; i++){
                adjList.add(new ArrayList<>());
            }

           //Input edges
            for(int i = 0; i < edges; i++){
                String[] x = br.readLine().trim().split(" ");
                int u = Integer.parseInt(x[0]);
                int v = Integer.parseInt(x[1]);

                if (u < vertex && v < vertex) { // Ensure u and v are within the vertex limit
                    adjList.get(u).add(v);
                    // If the graph is undirected, add reverse edge
                    adjList.get(v).add(u);
                }
            }

            int startNode =  Integer.parseInt(br.readLine().trim());
            // Ensure the startNode is within bounds
            if (startNode < 0 || startNode >= vertex) {
                System.out.println("Invalid start node.");
                continue;
            }

            ArrayList<Integer> ans = new ArrayList<>();
            ans = bfsOfGraph(vertex, adjList, startNode);

            for (int i = 0; i < ans.size(); i++){
                System.out.print(ans.get(i)+" ");
            }

            System.out.println();
        }
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjList, int startNode){
        ArrayList<Integer> ans = new ArrayList<>();
        // The size of the visited[] array should be V instead of V + 1 since the vertices are zero-indexed, and you are not working with any vertex labeled V
        boolean[] visited = new boolean[V]; //visited array to mark the visited node
        Queue<Integer> q = new LinkedList<>();

        q.add(startNode); // Start bfs from given startNode
        visited[startNode] = true; // mark it as true

        while(!q.isEmpty()){
            int u = q.poll(); // get the front node of q

            ans.add(u); // add that node into ans

            for(int i = 0; i < adjList.get(u).size(); i++) {
                int neighbor = adjList.get(u).get(i); // Get the adjacent node
                if (visited[neighbor] == false) {
                    q.add(neighbor); // as the neighbor if not visited then add it to queue
                    visited[neighbor] = true; // mark it as visited
                }
            }
        }
        return ans;
    }
}





/*
1
7 12
0 1
1 0
1 2
1 6
2 1
2 4
3 5
4 2
4 6
5 3
6 1
6 4
2
 */