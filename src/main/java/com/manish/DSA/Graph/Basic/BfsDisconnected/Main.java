package com.manish.DSA.Graph.Basic.BfsDisconnected;

import java.util.*;
import java.io.*;

import java.lang.*;

// Traverse each node, handling disconnected components

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);  // Number of vertices
            int E = Integer.parseInt(s[1]);  // Number of edges
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            // Initialize the adjacency list for each vertex
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());

            // Read edges
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);  // Uncomment if it's an undirected graph
            }

            // Create a Solution object and perform BFS
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);

            // Print the result
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

class Solution {
    // Function to return Breadth First Traversal of the graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>(); // List to store BFS traversal
        boolean[] vis = new boolean[V]; // Visited array for V vertices

        // Traverse each node, handling disconnected components
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                bfsTraversal(i, vis, adj, bfs);
            }
        }
        return bfs;
    }

    // Helper method to perform BFS from a given node
    private void bfsTraversal(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> bfs) {
        Queue<Integer> q = new LinkedList<>();

        // Start BFS from the current node
        q.add(node);
        vis[node] = true;

        // BFS loop
        while (!q.isEmpty()) {
            int currNode = q.poll();
            bfs.add(currNode);  // Add the node to the BFS result

            // Visit all the adjacent nodes
            for (Integer neighbor : adj.get(currNode)) {
                if (!vis[neighbor]) {
                    q.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
    }
}
