package com.manish.DSA.Graph.Basic.DijkstraAlgoForShortestDistance;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            // Input number of nodes (n) and number of edges (m)
            int n = sc.nextInt();
            int m = sc.nextInt();

            // Input edges and their weights
            int[][] edge = new int[m][3];
            for(int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }

            // Input source node
            int src = sc.nextInt();

            // Get the result
            Solution obj = new Solution();
            int[] res = obj.shortestPath(edge, n, m, src);

            // Print the result
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}

class Pair {
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] shortestPath(int edges[][], int n, int m, int src) {
        // Create an adjacency list of pairs where each pair is {node, weight}
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Fill the adjacency list
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        // Distance array to store the shortest distance to each node
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9); // Initialize distances with infinity
        dist[src] = 0;

        // Priority queue to process the nodes based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        pq.add(new Pair(0, src)); // Start from the source

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.second;
            int distance = current.first;

            // Process all neighbors of the current node
            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.first;
                int edgeWeight = neighbor.second;

                // If a shorter path to adjNode is found
                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        // Replace all unreachable nodes (still having the value 1e9) with -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}




/*
1
9 10
0 1 1
0 3 1
3 4 2
4 5 1
5 6 4
1 2 1
2 6 1
6 7 6
7 8 1
6 8 3
0

 */