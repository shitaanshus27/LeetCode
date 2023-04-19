//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int func(int[][] Matrix,int i,int j,int[][] dp)
    {
        if(j<0 || j>=Matrix[0].length) return -(int)1e9;
        
        if(i==0) return dp[i][j]=Matrix[0][j];
        
        if(dp[i][j]!=-1) return dp[i][j];
        int u=Matrix[i][j]+func(Matrix,i-1,j,dp);
        int ld=Matrix[i][j]+func(Matrix,i-1,j-1,dp);
        int ud=Matrix[i][j]+func(Matrix,i-1,j+1,dp);
        
      return dp[i][j]=Math.max(u,Math.max(ld,ud));    
    }
    static int maximumPath(int N, int Matrix[][])
    {
      int n=Matrix.length;
      int m=Matrix[0].length;
      int dp[][]=new int[n][m];
      
      for(int[] a:dp)
      {
          Arrays.fill(a,-1);
      }
      
      int max=Integer.MIN_VALUE;
      for(int j=0;j<Matrix[0].length;j++)
      {
          max=Math.max(max,func(Matrix,N-1,j,dp));
      }
      return max;
    }
}