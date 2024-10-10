package com.manish.DSA.Graph.DFS.DetectCycleDfs;// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean hasCycle  = obj.isCycle(V, adj);

            if (hasCycle)
                System.out.println("Yes the Graph has Cycle");
            else
                System.out.println("No The Graph has No Cycle");

            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V + 1];
        Arrays.fill(vis, false);
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(cycleDFS(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
    public boolean cycleDFS(int node, int par, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(Integer i : adj.get(node)){
            if(vis[i] == false){
                if(cycleDFS(i, node, vis, adj) == true) return true; 
            }
            else if(i != par) return true;
        }
        return false;
    }
}

/*

1
5 4
0 1
0 2
2 3
2 4


1
5 5
0 1
0 2
1 3
2 3
2 4

 */