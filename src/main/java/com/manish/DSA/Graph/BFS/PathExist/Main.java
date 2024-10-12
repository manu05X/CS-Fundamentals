package com.manish.DSA.Graph.BFS.PathExist;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}


//BFS
class Solution
{
    // Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        int n = grid.length;

        // Arrays to define the four possible directions of movement (up, down, left, right).
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        // Find the source cell
        int srcRow = -1, srcCol = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) { // Source found
                    srcRow = i;
                    srcCol = j;
                    break;
                }
            }
        }

        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{srcRow, srcCol});

        // Visited array to keep track of visited cells
        boolean[][] visited = new boolean[n][n];
        visited[srcRow][srcCol] = true;

        // BFS traversal
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];

            // Explore all four possible directions
            for(int k = 0; k < 4; k++) {
                int newRow = currRow + rowDir[k];
                int newCol = currCol + colDir[k];

                // Check if the new cell is within the grid bounds and is traversable
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    if(grid[newRow][newCol] == 2) {
                        return true; // Destination found
                    }

                    if(grid[newRow][newCol] == 3) {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true; // Mark the cell as visited
                    }
                }
            }
        }

        return false; // If destination is not reachable
    }
}


/*
class Solution
{
    // Directions for moving up, down, left, and right
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};

    // Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        int n = grid.length;
        int srcRow = -1, srcCol = -1;

        // Find the source cell (1)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    srcRow = i;
                    srcCol = j;
                    break;
                }
            }
        }

        // Call DFS from the source cell and return the result
        return dfs(grid, srcRow, srcCol, n);
    }

    // DFS helper function
    private boolean dfs(int[][] grid, int row, int col, int n) {
        // Base case: if we move out of bounds, or hit a wall, or a visited cell
        if(row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == 0 || grid[row][col] == -1) {
            return false;
        }

        // If we reach the destination (cell with value 2)
        if(grid[row][col] == 2) {
            return true;
        }

        // Mark the cell as visited by setting it to -1
        grid[row][col] = -1;

        // Explore all four directions
        for(int i = 0; i < 4; i++) {
            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            if(dfs(grid, newRow, newCol, n)) {
                return true; // If any direction leads to the destination, return true
            }
        }

        // If no path is found, return false
        return false;
    }
}
*/


/*
class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int srcRow = -1;
        int srcCol = -1;

        // Find the source position
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    srcRow = i;
                    srcCol = j;
                    break;
                }
            }
        }

        // Call DFS from the source cell
        return dfs(grid, srcRow, srcCol, n);
    }

    private boolean dfs(int[][] grid, int row, int col, int n){
        // Check bounds and if the cell is blocked or already visited
        if(row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == 0 || grid[row][col] == -1){
            return false;
        }

        // If we reach the destination
        if(grid[row][col] == 2){
            return true;
        }

        // Mark the cell as visited
        grid[row][col] = -1;

        // Explore all four directions: up, down, left, right
        boolean foundPath = dfs(grid, row - 1, col, n) ||  // up
                            dfs(grid, row + 1, col, n) ||  // down
                            dfs(grid, row, col - 1, n) ||  // left
                            dfs(grid, row, col + 1, n);    // right

        // Restore the cell back to its original value (optional, based on your requirements)
        // grid[row][col] = 3; // Uncomment if you want to restore the cell after search

        return foundPath; // Return whether a path was found

    }

}
*/

/*
Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall (blocked cell which we cannot traverse).
Note: There are only a single source and a single destination.


Examples :

Input: grid = {{3,0,3,0,0},{3,0,0,0,3},{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}}
Output: 0
Explanation: The grid is-
3 0 3 0 0
3 0 0 0 3
3 3 3 3 3
0 2 3 0 0
3 0 0 1 3
There is no path to reach at (3,1) i,e at destination from (4,3) i,e source.
Input: grid = {{1,3},{3,2}}
Output: 1
Explanation: The grid is-
1 3
3 2
There is a path from (0,0) i,e source to (1,1) i,e destination.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

 */

/*
Input 1 :
1
5
3 0 3 0 0
3 0 0 0 3
3 3 3 3 3
0 2 3 0 0
3 0 0 1 3

Input 2 :
1
2
1 3
3 2

 */