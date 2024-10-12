package com.manish.DSA.Graph.DFS.Bipartite.MaximumBipartite;
import java.util.*;
import java.lang.*;
import java.io.*;

/*
There are M job applicants and N jobs.  Each applicant has a subset of jobs that he/she is interseted in. Each job opening can only accept one applicant and a job applicant can be appointed for only one job. Given a matrix G where G(i,j) denotes ith applicant is interested in jth job. Find an assignment of jobs to applicant in such that as many applicants as possible get jobs.


Example 1:

Input: G = {{1,1,0,1,1},{0,1,0,0,1},
{1,1,0,1,1}}
Output: 3
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.
Third applicant gets the 3rd job.
Example 2:

Input: G = {{1,1},{0,1},{0,1},{0,1},
{0,1},{1,0}}
Output: 2
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.


 */

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            System.out.println(ans);
        }
    }
}

//User function Template for Java

class Solution {
    public int maximumMatch(int[][] G) {
        int applicants = G.length;
        int jobs = G[0].length;

        // Array to store the job assigned to each applicant
        int[] jobAssigned = new int[jobs];

        // Initially no job is assigned, so -1 for all jobs
        Arrays.fill(jobAssigned, -1);

        int maxMatch = 0; // To store the number of maximum matches

        // Try to find a match for each applicant
        for (int i = 0; i < applicants; i++) {
            // Visited array to keep track of jobs already tried for this applicant
            boolean[] visited = new boolean[jobs];

            // Try to find a match for applicant i
            if (dfs(G, i, visited, jobAssigned)) {
                maxMatch++; // If we find a match, increase the count
            }
        }

        return maxMatch;
    }

    // DFS function to find if an applicant can be assigned a job
    private boolean dfs(int[][] G, int applicant, boolean[] visited, int[] jobAssigned) {
        for (int job = 0; job < G[0].length; job++) {
            // If applicant is interested in this job and job has not been visited in this DFS call
            if (G[applicant][job] == 1 && !visited[job]) {
                visited[job] = true; // Mark job as visited

                // If job is not assigned or previously assigned applicant can be reassigned to another job
                if (jobAssigned[job] == -1 || dfs(G, jobAssigned[job], visited, jobAssigned)) {
                    jobAssigned[job] = applicant; // Assign this job to current applicant
                    return true; // Found a match
                }
            }
        }
        return false; // No match found
    }
}

/*
1
3 5
1 1 0 1 1
0 1 0 0 1
1 1 0 1 1
 */