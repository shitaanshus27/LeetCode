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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Tuple{
        int dist;
        int row;
        int col;
        Tuple(int dist,int row,int col)
        {
          this.dist=dist;
          this.row=row;
          this.col=col;
        }
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
     if(source[0]==destination[0] && source[1]==destination[1]) return 0;
     PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
     pq.add(new Tuple(0,source[0],source[1]));
     int dist[][]=new int[grid.length][grid[0].length];
     for(int i=0;i<grid.length;i++)
     {
       for(int j=0;j<grid[0].length;j++)
       {
          dist[i][j]=(int)1e9; 
       }
     }
     dist[source[0]][source[1]]=0;
     int delrow[]={-1,0,1,0};
     int delcol[]={0,1,0,-1};
     while(!pq.isEmpty()){
         int distance=pq.peek().dist;
         int row=pq.peek().row;
         int col=pq.peek().col;
         pq.remove();
        if(row==destination[0] && col==destination[1]) return distance;
        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
          if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length)
          {
              if(grid[nrow][ncol]==1)
              {
                if(dist[row][col]+1<dist[nrow][ncol]) 
                {
                    dist[nrow][ncol]=dist[row][col]+1;
                    pq.add(new Tuple(dist[nrow][ncol],nrow,ncol));
                }
              }
          }
        }
     }
    return -1; 
    }
}
