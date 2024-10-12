package com.manish.DSA.Graph.BFS.ShortestPathDAG;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m,edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}


class Solution {

    // Function to find the shortest path in DAG using BFS for topological sort
    public int[] shortestPath(int N, int M, int[][] edges) {
        // Step 1: Create an adjacency list for the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Add the edges to the adjacency list
        int[] inDegree = new int[N]; // Array to store in-degrees of vertices
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
            inDegree[v]++; // Increase in-degree of vertex v
        }

        // Step 3: Initialize the distance array and BFS queue
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances as infinite
        dist[0] = 0; // Distance to the source (vertex 0) is 0

        Queue<Integer> queue = new LinkedList<>();

        // Step 4: Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 5: Process the graph in topologically sorted order using BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Relax all edges from the current node
            for (int[] neighbor : adj.get(node)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Relaxation step: update shortest path to vertex v
                if (dist[node] != Integer.MAX_VALUE && dist[node] + weight < dist[v]) {
                    dist[v] = dist[node] + weight;
                }

                // Decrease the in-degree of the neighbor
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // Step 6: Replace unreachable vertices' distances with -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}

/*
1
6 7
0 1 2
0 4 1
4 5 4
4 2 2
1 2 3
2 3 6
5 3 1
 */