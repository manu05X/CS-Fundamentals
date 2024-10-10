package com.manish.DSA.Graph.BFS.DetectCycle;

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
            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++)
            {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                //adj.get(v).add(u);
            }

            System.out.println();

            Solution obj = new Solution();
            boolean hasCycle  = obj.isCycle(V, adj);

            if (hasCycle)
                System.out.println("Yes the Graph has Cycle");
            else
                System.out.println("No The Graph has No Cycle");

            System.out.println();
        }
    }
}

/*

// Class representing a node with a parent for BFS
class Node {
    int vertex;
    int parent;

    public Node(int vertex, int parent) {
        this.vertex = vertex;
        this.parent = parent;
    }
}



class Solution {
    // Function to check for a cycle using BFS
    private boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
        Queue<Node> queue = new LinkedList<>();

        // Add the source node with no parent (-1)
        queue.add(new Node(src, -1));
        visited[src] = true;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int vertex = currentNode.vertex;
            int parent = currentNode.parent;

            // Traverse all adjacent vertices of the current node
            for (Integer neighbor : adj.get(vertex)) {
                // If the neighbor is not visited, add it to the queue
                if (!visited[neighbor]) {
                    queue.add(new Node(neighbor, vertex));
                    visited[neighbor] = true;
                }
                // If the neighbor is visited and is not the parent, cycle is detected
                else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    // Function to check for cycle in the graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // Check for cycle in each component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkForCycle(adj, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
*/

/*
Purpose of Node Class in BFS:
When checking for cycles in an undirected graph using BFS, it is important to track the parent of each node to differentiate between a back edge (which indicates a cycle) and a tree edge (which is part of the traversal).

Starting BFS from node 0, we visit node 1 and 2. Now, 1 has 0 as its parent and 2 also has 0 as its parent.
Then, when visiting node 1, it may encounter node 0 again, but this is not a cycle since 0 is its parent.
Similarly, when visiting node 2, it may encounter 0 again, but again it's not a cycle because 0 is its parent.
However, if node 1 encounters node 3, and node 3 encounters node 2 (or vice versa) without their parent relation, this indicates a cycle.

By tracking the parent of each node, we can differentiate between revisiting a parent (which is expected in BFS) and revisiting a non-parent node (which indicates a cycle).
 */

/*

Without the Node Class:
If we didn’t use the Node class to store both the vertex and its parent, we would have to manage this information separately, either by using additional data structures or by passing extra parameters in the BFS logic.

*/

class Solution {
    // Function to check for a cycle using BFS
    private boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[visited.length]; // Array to track parent of each node
        Arrays.fill(parent, -1); // Initially, no node has a parent

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (Integer neighbor : adj.get(vertex)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = vertex; // Track the parent
                }
                else if (neighbor != parent[vertex]) { // Cycle detected
                    return true;
                }
            }
        }
        return false;
    }

    // Function to check for cycle in the graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkForCycle(adj, i, visited)) {
                    return true;
                }
            }
        }
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
NO

1
5 5
0 1
0 2
1 3
2 3
2 4
YES


 */