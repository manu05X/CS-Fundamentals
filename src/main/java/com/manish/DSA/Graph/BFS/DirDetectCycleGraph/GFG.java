package com.manish.DSA.Graph.BFS.DirDetectCycleGraph;

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
            for (int i = 0; i < V; i++) {
                adj.add(i, new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v); // Directed edge from u to v
            }

            Solution obj = new Solution();
            boolean hasCycle  = obj.isCycle(V, adj);

            if (hasCycle)
                System.out.println("Yes, the Graph has a Cycle");
            else
                System.out.println("No, the Graph has No Cycle");
        }
    }
}


class Solution {
    // Function to check if the directed graph has a cycle using BFS (Kahn's Algorithm)
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V]; // Array to store in-degrees of all vertices

        // Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Queue for vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        
        // Enqueue all vertices with in-degree 0
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int visitedCount = 0; // Count of vertices processed in the topological sort

        // Process the vertices in topological order
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            visitedCount++;

            // Decrease the in-degree of all adjacent vertices
            for (int neighbor : adj.get(vertex)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If the visited count doesn't match the number of vertices, there is a cycle
        return visitedCount != V;
    }
}

/*

Directed Graph
1
5 4
0 1
0 2
2 3
2 4
NO

1
5 5
0 1
0 2
1 3
2 3
2 4
YES


1
5 4
0 1
0 2
2 3
2 4
NO

//Not directed Graph
1
5 5
0 1
0 2
0 3
2 3
2 4
No


// Directed Graph
1
5 5
0 1
0 2
2 3
3 0
2 4
YES


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