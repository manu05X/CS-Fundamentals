package com.manish.DSA.Graph.DFS.TopologicalSort;

import java.util.*;
import java.io.*;
import java.lang.*;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
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

            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v); // Directed graph edge u -> v
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res)) {
                System.out.println("Yes TopoSorted");
                printTopologicalOrder(res); // Print the topological order
            } else {
                System.out.println("Not Topological Sorted");
            }
        }
    }

    // Function to check if the topological sort is valid
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        if (V != res.length) return false;

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

class Solution {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V + 1]; // Visited array
        Arrays.fill(vis, 0); // Mark all as unvisited initially

        // Perform DFS for each node
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        // Extract the topological sort from the stack
        int[] topo = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            topo[i++] = st.pop();
        }
        return topo;
    }

    // DFS function to explore the graph and store nodes in the stack
    public static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1; // Mark node as visited

        // Visit all the adjacent nodes
        for (Integer i : adj.get(node)) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj); // Recursive DFS call
            }
        }

        // After all adjacent nodes are processed, push the current node onto the stack
        st.push(node);
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



 */