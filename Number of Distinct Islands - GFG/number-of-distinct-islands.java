//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public void dfs(int row,int col,int[][] vis,int[][] grid,ArrayList<String>vec,int row0,int col0)
    {
    vis[row][col]=1;
    vec.add(Integer.toString(row-row0)+" "+Integer.toString(col-col0));
    int n=grid.length;
    int m=grid[0].length;
    int delrow[]={-1,0,1,0};
    int delcol[]={0,1,0,-1};
    for(int i=0;i<4;i++)
    {
        int nrow=row+delrow[i];
        int ncol=col+delcol[i];
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
            dfs(nrow,ncol,vis,grid,vec,row0,col0);
        }
    }
    }
    int countDistinctIslands(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        HashSet<ArrayList<String>> st=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1){
                  ArrayList<String> vec=new ArrayList<>();
                  dfs(i,j,vis,grid,vec,i,j);
                  st.add(vec);
                }
            }
        }
        return st.size();
    }
}
