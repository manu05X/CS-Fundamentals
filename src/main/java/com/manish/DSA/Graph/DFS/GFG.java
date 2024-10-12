package com.manish.DSA.Graph.DFS;

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

            ArrayList<Integer> ans = new ArrayList<>();
            ans = dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }

    private static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                dfsTraversal(i,visited,adj, ans);
            }
        }
        return ans;
    }

    private static void dfsTraversal(int currVertex, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        ans.add(currVertex);
        vis[currVertex] = true;

        // traversing the neighbour
        for(Integer u : adj.get(currVertex)){
            if(vis[u] == false){
                dfsTraversal(u,vis,adj,ans);
            }
        }
    }
}