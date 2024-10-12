package com.manish.DSA.Graph.BFS.TopologicalSort.CourseSchedule;


import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int P = sc.nextInt();
            int prerequisites[][] = new int[P][2];
            for(int i=0;i<P;i++)
            {
                for(int j=0;j<2;j++)
                {
                    prerequisites[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            if(ob.canFinish(N,P,prerequisites))
            {
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            t--;
        }
    }

}


class Solution {
    public boolean canFinish(int numCourses,int p, int[][] prerequisites) {
         // Your Code goes here
        // Step 1: Build the graph and indegree array
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       int[] inDegree = new int[numCourses];
       
       for(int i = 0; i < numCourses; i++){
           adj.add(new ArrayList<>());
       }
       
       // Populate the adjacency list and indegree array
       for(int[] pre : prerequisites){
           int u = pre[1];  // prerequisite task
            int v = pre[0];  // dependent task

            adj.get(u).add(v);  // Edge from u -> v
            inDegree[v]++;          // Increase indegree of v v has incomming edge u --> v
       }
       
        // Step 2: Initialize the queue with nodes having indegree 0
       Queue<Integer> q = new LinkedList<>();
       for(int i = 0; i < numCourses; i++){
           if(inDegree[i] == 0){
               q.add(i);
           }
       }
       
       // Step 3: Process the queue and perform topological sort
       int count = 0;
       while(!q.isEmpty()){
           int curr = q.poll();
           count++;
           
           // Visit all the neighbors of the node
           for(int neighbor : adj.get(curr)){
               inDegree[neighbor]--;
               
               if(inDegree[neighbor] == 0){
                   q.add(neighbor);
               }
           }
       }
       // Step 4: If all tasks are processed, return true, else false
       return count == numCourses;
    }
}
/*
4
4
1 0
2 1
3 2
2 3
No


4
3
1 0
2 1
3 2
Yes
 */