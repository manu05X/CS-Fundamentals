package com.manish.DSA.Graph.DFS.DirCycleGraph;// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("Yes the Graph has Cycle");
            else
                System.out.println("No The Graph has No Cycle");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[] = new int[V + 1];
        int dfsVis[] = new int[V + 1];
        Arrays.fill(vis, 0);
        Arrays.fill(dfsVis, 0);
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                if(cycleDFS(i, vis, dfsVis, adj)) return true;
            }
        }
        return false;
    }
    public boolean cycleDFS(int node, int vis[], int dfsVis[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        dfsVis[node] = 1;
        
        for(Integer i : adj.get(node)){
            if(vis[i] == 0){
                if(cycleDFS(i, vis, dfsVis, adj)) return true;
            }
            else if(dfsVis[i] == 1) return true;
        }
        dfsVis[node] = 0;
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
0 3
2 3
2 4


1
5 5
0 1
0 2
2 3
3 0
2 4



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
 */