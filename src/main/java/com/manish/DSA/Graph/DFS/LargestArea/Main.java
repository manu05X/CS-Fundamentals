package com.manish.DSA.Graph.DFS.LargestArea;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}

class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int max_area=0;
        int n=grid.length;
        int m=grid[0].length;
        //moving every point of grid  and updating its value when you travelled
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int count=dfs(grid,i,j,n,m);
                    //finding maximum area
                    max_area=Math.max(max_area,count);
                }
            }
        }
        return max_area;
    }

    //use basic dfs operation on the  grid
    public int dfs(int[][] grid,int i,int j,int n,int m)
    {
        // Check if the current position is out of bounds or the cell is not part of the region (0 or already visited).
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0)
        {
            return 0;
        }

        // Mark the current cell as visited by setting it to 0.
        grid[i][j] = 0;

        // Initialize area count (current cell is part of the region, so start with 1).
        int area = 1;

        // Explore all 8 possible directions (horizontally, vertically, and diagonally).
        int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Recursively call DFS in all 8 directions and sum up the area of the connected region.
        for (int d = 0; d < 8; d++)
        {
            area += dfs(grid, i + rowDir[d], j + colDir[d], n, m);
        }

        return area;
    }
}