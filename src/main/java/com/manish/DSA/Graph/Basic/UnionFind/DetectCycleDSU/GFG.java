package com.manish.DSA.Graph.Basic.UnionFind.DetectCycleDSU;//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);

            if(ans == 1)
                System.out.println("It has cycle.");
            else
                System.out.println("No cycle.");
        }
    }
}
// } Driver Code Ends


class Solution
{
    // Function to find the root of a node with path compression
    private int find(int x, int[] par) {
        if (par[x] == x) {
            return x; // x is the root of its set
        }
        // Path compression: attach the node directly to the root
        par[x] = find(par[x], par); 
        return par[x];
    }
    
    // Function to merge two sets
    private void union_set(int u, int v, int[] par, int[] rank) {
        int rootU = find(u, par);
        int rootV = find(v, par);
        
        if (rootU != rootV) {
            // Union by rank to keep the tree shallow
            if (rank[rootU] > rank[rootV]) {
                par[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                par[rootU] = rootV;
            } else {
                par[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
    
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int[] parent = new int[V];
        int[] rank = new int[V];
        
        for(int i = 0; i < V; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        // Traverse through the adjacency list and check for cycles
        for(int u = 0; u < V; u++)
        {
            for(int v : adj.get(u)){
                if (u < v) 
                { // Avoid processing the same edge twice (u, v) and (v, u)
                    int rootU = find(u, parent);
                    int rootV = find(v, parent);

                    // If both vertices are in the same set, a cycle is detected
                    if (rootU == rootV) {
                        return 1; // Cycle found
                    }

                    // Otherwise, union the sets
                    union_set(u, v, parent, rank);
                    
                }
            }
        }
        
        return 0;
    }
}
/*
1
5 5
0 2
0 3
0 4
1 3
2 4


1
5 4
1 3
3 0
0 2
2 4


 */