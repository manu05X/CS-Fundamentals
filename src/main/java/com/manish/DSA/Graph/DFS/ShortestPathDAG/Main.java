package com.manish.DSA.Graph.DFS.ShortestPathDAG;

import java.io.IOException;
import java.util.*;

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

    // Function to find the shortest path in DAG
    public int[] shortestPath(int N, int M, int[][] edges) {
        // Step 1: Create an adjacency list for the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Add the edges to the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
        }

        // Step 3: Perform topological sort
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack, adj);
            }
        }

        // Step 4: Initialize distances from the source vertex
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances in array as infinite
        dist[0] = 0;   // Distance to the source (vertex 0) is 0

        // Step 5: Process vertices in topologically sorted order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            // If the node has been reached (distance != inf)
            if (dist[node] != Integer.MAX_VALUE) {
                // Relax all edges from this node
                for (int[] neighbor : adj.get(node)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                    if (dist[node] + weight < dist[v]) {
                        dist[v] = dist[node] + weight;
                    }
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

    // Helper function to perform DFS-based topological sort
    private void topologicalSort(int node, boolean[] visited, Stack<Integer> topoStack, List<List<int[]>> adj) {
        visited[node] = true;

        for (int[] neighbor : adj.get(node)) {
            int v = neighbor[0];
            if (!visited[v]) {
                topologicalSort(v, visited, topoStack, adj);
            }
        }

        topoStack.push(node);
    }
}

/*

Explanation:
1> Adjacency List:
        We create an adjacency list where each vertex points to its neighbors along with the edge weights.
2> Topological Sort:
        We perform a topological sort using a DFS-based approach. Vertices are pushed onto a stack after all their neighbors are visited.

3> Relaxing Edges:
        Once we have the topologically sorted order of vertices, we process each vertex in the order and relax the edges (i.e., update the shortest path to the neighboring vertices).

4> Handling Unreachable Vertices:
        After processing all vertices, any vertex that has a distance equal to Integer.MAX_VALUE is unreachable and its distance is set to -1.

*/


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