//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s)
    {
         int dp[][]=new int[s.length()][s.length()];
        for(int[] x:dp)
        {
          Arrays.fill(x,-1);
        }
        return palindromic(s,0,s.length()-1,dp);
    }
      public int palindromic(String s,int i,int j,int[][] dp)
    {
      if(i>=j)
      {
        return i==j?1:0;
      }
      if(dp[i][j]!=-1) return dp[i][j];

      if(s.charAt(i)==s.charAt(j))
      {
        return dp[i][j]=2+palindromic(s,i+1,j-1,dp);
      }
       int a=palindromic(s,i+1,j,dp);
       int b=palindromic(s,i,j-1,dp);
       return dp[i][j]=Math.max(a,b);
    }
}