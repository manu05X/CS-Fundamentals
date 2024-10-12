package com.manish.DSA.Graph.BFS.TopologicalSort.courseScheduleII;


import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);

            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
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
}

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // Build the adjacency list and indegree array
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        
        // Initialize the adjacency list
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        // Populate the adjacency list and indegree array
        for(ArrayList<Integer> pre : prerequisites){
            int u = pre.get(1);  // prerequisite task
            int v = pre.get(0);  // task to be done after completing u
            
            adj.get(u).add(v);
            inDegree[v]++;
        }
        
        // Initialize the queue for Kahn's algorithm (BFS approach)
        Queue<Integer> q = new LinkedList<>();
        
        // Add all nodes with inDegree 0 (tasks with no prerequisites)
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        // Array to store the topological order of tasks
        int[] ans = new int[n];
        int count = 0;  // Counter to track number of tasks processed
        
        // Process the graph using BFS
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[count] = curr;  // Add the task to the result array
            count++;
            
            // Reduce the indegree of all neighbors of the current task
            for(int neighbor : adj.get(curr)){
                inDegree[neighbor]--;
                
                // If indegree becomes 0, add the task to the queue
                if(inDegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        
        // If count is less than n, it means we couldn't process all tasks (i.e., a cycle exists)
        if(count != n) {
            return new int[0];  // Return an empty array when it's impossible to finish all tasks
        }
        
        return ans;  // Return the valid topological order
    }
}

/*
2 1
1 0


1
25 14
10 18
0 18
10 6
16 0
8 7
19 15
24 16
20 14
1 17
14 13
21 21
19 22
23 20
10 5
 */