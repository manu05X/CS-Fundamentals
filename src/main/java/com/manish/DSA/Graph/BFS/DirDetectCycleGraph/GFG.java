package com.manish.DSA.Graph.BFS.DirDetectCycleGraph;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
Cycle Detection in Directed Graph using Kahn's Algorithm
 */

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
    // Function to detect cycle in a directed graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] inDegree = new int[V];  // To store in-degree of each vertex

        // Step 1: Calculate in-degree for each vertex
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Step 2: Initialize the queue with all vertices having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Count of vertices processed in the topological sort
        int index = 0;
        // Step 3: Process vertices
        while (!queue.isEmpty()) {
            int curr = queue.poll();  // Get the front element from the queue
            index++;
            // Step 4: Decrease in-degree of all neighbors
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;

                // If in-degree becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 5: Check if there was a cycle
        if(index == V)
            return false;
        else
            return true; // cycle in graph if index != V
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