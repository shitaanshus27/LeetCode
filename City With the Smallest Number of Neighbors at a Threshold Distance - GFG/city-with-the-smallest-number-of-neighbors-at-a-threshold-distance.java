//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
         int[][] dist=new int[n][n];
         for(int i=0;i<n;i++)
         {
          for(int j=0;j<n;j++)
          {
             if(i==j) dist[i][j]=0;
             else  dist[i][j]=(int)1e9;
          }
         }
         for(int[] arr:edges)
         {
            int src=arr[0];
            int des=arr[1];
            int wt=arr[2];
            dist[src][des]=wt;
            dist[des][src]=wt;
         }
         for(int k=0;k<n;k++)
         {
           for(int i=0;i<n;i++)
           {
             for(int j=0;j<n;j++)
             {
                dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]); 
             }
           }
         }
         int ans=Integer.MAX_VALUE;
         int city=Integer.MIN_VALUE;
         for(int i=0;i<n;i++)
         {
            int count=0;
            for(int j=0;j<n;j++)
            {
              if(i==j) continue;
              if(dist[i][j]<=distanceThreshold) count++;
            }
            if(count<=ans)
            {
              ans=count;
              city=i;
            }
         }
         /*for(int i=0;i<n;i++)
         {
          for(int j=0;j<m;j++)
          {
            System.out.print(dist[i][j]+" ");
          }
          System.out.println();
         }*/
        return city; 
      }
}
