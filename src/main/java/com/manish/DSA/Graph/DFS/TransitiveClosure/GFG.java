package com.manish.DSA.Graph.DFS.TransitiveClosure;

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];

            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}

class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
        // Initialize the result matrix based on the input graph
        ArrayList<ArrayList<Integer>> closure = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                // Initialize with the given graph
                row.add(graph[i][j]);
            }
            closure.add(row);
        }

        // Set diagonal to 1 (every vertex can reach itself)
        for (int i = 0; i < N; i++) {
            closure.get(i).set(i, 1);
        }

        // Apply Floyd-Warshall algorithm to compute transitive closure
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // If vertex k is on the path from i to j, then set closure[i][j] to 1
                    closure.get(i).set(j, closure.get(i).get(j) | (closure.get(i).get(k) & closure.get(k).get(j)));
                }
            }
        }

        return closure;
    }
}