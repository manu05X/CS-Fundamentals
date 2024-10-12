package com.manish.DSA.Graph.DFS.CircleOFStrings;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}


class Solution {
    public int isCircle(String arr[]) {
        int n = arr.length;

        // If there is only one string, it can form a circle only if first and last character are same.
        if(n == 1) {
            return arr[0].charAt(0) == arr[0].charAt(arr[0].length() - 1) ? 1 : 0;
        }

        // To store the graph's in-degree and out-degree
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];

        // Adjacency list for graph representation
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (String str : arr) {
            int u = str.charAt(0) - 'a'; // First character of the string
            int v = str.charAt(str.length() - 1) - 'a'; // Last character of the string

            outDegree[u]++;
            inDegree[v]++;

            adj.get(u).add(v);
        }

        // Step 1: Check if in-degree and out-degree match for every node
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;
            }
        }

        // Step 2: Check for graph connectivity
        // Find a node with non-zero degree to start DFS
        int startNode = -1;
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                startNode = i;
                break;
            }
        }

        // If there are no edges in the graph, strings can't form a circle
        if (startNode == -1) {
            return 0;
        }

        // Perform DFS from the startNode
        if (!isConnected(adj, startNode, inDegree)) {
            return 0;
        }

        return 1;  // The strings can be chained to form a circle
    }

    // Helper function to check if the graph is strongly connected using DFS
    private boolean isConnected(ArrayList<ArrayList<Integer>> adj, int startNode, int[] inDegree) {
        boolean[] visited = new boolean[26];
        dfs(adj, startNode, visited);

        // Check if all nodes with non-zero degree are visited
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    // DFS function to visit nodes
    private void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }
}

/*
1
4
aab bac aaa cda

1
3
abc bcd cdf

1
4
ab bc cd de
 */