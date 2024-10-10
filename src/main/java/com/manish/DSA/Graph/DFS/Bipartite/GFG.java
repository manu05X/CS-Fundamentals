package com.manish.DSA.Graph.DFS.Bipartite;

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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);

            // Output the result
            if (ans)
                System.out.println("The graph is bipartite"); // If the graph is bipartite, print 1
            else
                System.out.println("The graph is Not bipartite"); // If not bipartite, print 0
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color[] = new int[V + 1];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(!dfs(i, color, adj))
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int color[], ArrayList<ArrayList<Integer>>adj){
        // if(color[node] == -1) color[node] = 0;
        
        for(Integer i : adj.get(node)){
            if(color[i] == -1){
                color[i] = 1 - color[node];
                if(!dfs(i, color, adj))
                    return false;
            }
            else if(color[i] == color[node]){
                return false;
            }
        }
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