package com.manish.DSA.Graph.Basic.Bipartite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // To read input
        int T = Integer.parseInt(br.readLine().trim()); // Number of test cases

        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]); // Number of vertices
            int E = Integer.parseInt(S[1]); // Number of edges

            // Creating adjacency list representation of the graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<Integer>());
            }

            // Reading the edges and adding them to the adjacency list
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);  // Add edge u -> v
                adj.get(v).add(u);  // Since it's an undirected graph, add edge v -> u
            }

            Solution obj = new Solution(); // Creating an object of Solution class
            boolean ans = obj.isBipartite(V, adj); // Check if the graph is bipartite

            // Output the result
            if (ans)
                System.out.println("The graph is bipartite"); // If the graph is bipartite, print 1
            else
                System.out.println("The graph is Not bipartite"); // If not bipartite, print 0
        }
    }
}

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V]; // Array to store the color of each vertex (-1 means uncolored)
        Arrays.fill(color, -1); // Initially, all vertices are uncolored (-1)

        // Traverse all the vertices
        for(int i = 0; i < V; i++){
            // If the vertex is not yet colored
            if(color[i] == -1)
            {
                // Perform BFS, if we find it's not bipartite, return false
                if(bfs(i, color, adj) == false){
                    return false;
                }
            }
        }
        // If we traverse all vertices and don't find a conflict, return true (bipartite)
        return true;
    }

    public boolean bfs(int sv, int[] color, ArrayList<ArrayList<Integer>>adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv); // Start BFS from the given node
        color[sv] = 1;  // Color the starting node with color 1

        // Perform BFS
        while(!q.isEmpty()){
            int curr = q.poll(); // Get the current node from the queue

            // Traverse all adjacent nodes
            for(Integer nighbor : adj.get(curr)){
                // If the adjacent node is not colored
                if(color[nighbor] == -1){
                    q.add(nighbor); // Add it to the queue
                    color[nighbor] = 1 - color[curr]; // Color it with the opposite color of the current node
                }
                // If the adjacent node has the same color, return false
                else if(color[nighbor] == color[curr]){
                    return false; // The graph is not bipartite
                }
            }
        }

        // If no conflict in coloring, return true
        return true;
    }
}

/*
------
1
7 7
0 1
1 2
1 6
2 3
3 4
4 5
5 6
_________

  -0-
4/    \1
 \3__2/

1
5 5
0 1
1 2
2 3
3 4
4 0

 */