package com.manish.DSA.Graph.DFS.ShortestPathUDG;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

class Solution {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create an adjacency list of size N for storing the undirected graph.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // A dist array of size N initialized with a large number to
        // indicate that initially all the nodes are untraversed.
        int dist[] = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0; // Distance to the source is always 0

        // Visited array to keep track of visited nodes in DFS
        boolean[] visited = new boolean[n];

        // Call DFS starting from the source
        dfs(src, adj, dist, visited);

        // Unreachable nodes are marked as -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    // DFS function to update the distances
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] dist, boolean[] visited) {
        visited[node] = true;

        // Traverse all adjacent nodes
        for (int neighbor : adj.get(node)) {
            // If visiting the neighbor can give a shorter path
            if (dist[node] + 1 < dist[neighbor]) {
                dist[neighbor] = dist[node] + 1;
            }

            // If the neighbor has not been visited yet, continue DFS
            if (!visited[neighbor]) {
                dfs(neighbor, adj, dist, visited);
            }
        }
    }
}

/*

1
9 10
0 1
0 3
3 4
4 5
5 6
1 2
2 6
6 7
7 8
6 8
0

ANS: 0 1 2 1 5 4 3 4 4


 */