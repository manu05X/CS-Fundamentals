package com.manish.DSA.Graph.Basic.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        
        //using BufferedReader to take input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //taking total testcases
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            
            //taking total number of elements
            int n = Integer.parseInt(br.readLine());
            
            int par[] = new int[n+1];
            int rank[] = new int[n+1];
            
            //initializing the parent and
            //the rank array
            for(int i = 1; i<=n; ++i){
                par[i] = i;
                rank[i] = 1;
            }
            int a = 0, b = 0;
            char c = '0';
            
            //taking number of queries
            int query = Integer.parseInt(br.readLine());
            
            Boolean output = false;
            while(query-- >0){
                String str[] = br.readLine().trim().split(" ");
                c = str[0].charAt(0);
                a = Integer.parseInt(str[1]);
                b = Integer.parseInt(str[2]);

                System.out.println();

                //if query type is 'U'
                //then calling union_ method
                if(c == 'U'){
                    new Solution().union_(a, b, par, rank);
                }
                else{//else calling isConnected() method
                    output = new Solution().isConnected(a, b, par, rank);
                    if(output == true)
                        System.out.println("1");
                    else
                        System.out.println("0");
                }
            }



        }
    }
}
// } Driver Code Ends

class Solution
{
    private int find(int x,  int par[]){
        if(x == par[x]) return x;

        // Path compression: attach the node directly to the root
        par[x] = find(par[x], par);
        return par[x];
    }
    //Function to merge two nodes a and b.
    public void union_(int a, int b, int par[], int rank[])
    {
        // add your code here
        int rootA = find(a, par);
        int rootB = find(b, par);

        // If they have the same root, they're already in the same set
        if(rootA == rootB) return;

        // Union by rank: attach the shorter tree under the taller one
        if(rank[rootA] > rank[rootB]){
            par[rootB] = rootA;
        } else if(rank[rootA] < rank[rootB]){
            par[rootA] = rootB;
        } else {
            // If both have the same rank, attach one to the other and increase its rank
            par[rootB] = rootA;
            rank[rootA]++;
        }

    }

    //Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        // add your code here
        // If the root of both nodes is the same, they are connected
        return find(a, par) == find(b, par);
    }

}

/*
1
5
4
U 1 3
C 1 2
U 1 5
C 3 5
 */

