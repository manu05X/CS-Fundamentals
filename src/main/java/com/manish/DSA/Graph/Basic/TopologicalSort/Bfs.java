package com.manish.DSA.Graph.Basic.TopologicalSort;

import java.io.*;
import java.util.*;

/*
Key Steps:
1> Calculate in-degree for every vertex (the number of incoming edges).
2> Add all vertices with in-degree 0 to a queue.
3> Process each vertex by reducing the in-degree of its neighbors, and add neighbors to the queue if their in-degree becomes 0.
4> Continue this process until the queue is empty. If all vertices are processed, the topological order is returned.

 */


public class Bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new SolutionBfs().topoSort(nov, list);

            if (check(list, nov, res) == true)
            {
                System.out.println("Yes TopoSorted");
                printTopologicalOrder(res); // Print the topological order
            } else {
                System.out.println("Not Topological Sorted");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {

        if(V!=res.length)
            return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }

    // Function to print the topological sort order
    static void printTopologicalOrder(int[] topo) {
        for (int i : topo) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
// } Driver Code Ends

class SolutionBfs{
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
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

        // a counter to keep a note of processed node
        int index = 0;
        // Step 3: Process vertices
        int[] topoOrder = new int[V]; // To store the result (topological order)
        while (!queue.isEmpty()) {
            int curr = queue.poll();  // Get the front element from the queue
            topoOrder[index++] = curr;  // Add it to the topological order

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
        if (index != V) {
            // If not all vertices are processed, there's a cycle and topological sort is not possible
            return new int[0];  // Returning an empty array means topological sorting is not possible
        }

        return topoOrder;  // Return the topological order
    }
}

/*
1
6 6
5 0
5 2
2 3
4 0
3 1
4 1


a topological sorting of the following graph is “5 4 2 3 1 0?. There can be more than one topological sorting for a graph. For example, another topological sorting of the following graph is “4 5 2 0 3 1″.
 */