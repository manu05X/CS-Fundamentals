package com.manish.DSA.Graph.Basic.Dfs;

import java.util.*;
import java.lang.*;
import java.io.*;
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
            ArrayList<ArrayList<Integer>> adj =
                    new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfsStore = new ArrayList<>();
        boolean vis[] = new boolean[V + 1];

        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                dfs(i, vis, adj, dfsStore);
            }
        }
        return dfsStore;
    }
    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsStore){
        dfsStore.add(node);
        vis[node] = true;

        for(Integer i : adj.get(node)){
            if(vis[i] == false){
                dfs(i, vis, adj, dfsStore);
            }
        }
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


0----1----2
     |    |
     6----4

3----5

 */