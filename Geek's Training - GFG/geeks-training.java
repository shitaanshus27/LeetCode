//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{ 
    public int recurison(int points[][],int day,int last,int[][] dp)
    {
         if(dp[day][last]!=-1) return dp[day][last];
        if(day==0)
        {
           int maxi=0;
            for(int task=0;task<3;task++)
            {
               if(last!=task)
              { 
                maxi=Math.max(maxi,points[0][task]);
              }
            }
           return dp[day][last]=maxi; 
        }
        int maxi=0;
       for(int task=0;task<3;task++)
       {
         if(last!=task)
         {
           int point=points[day][task]+recurison(points,day-1,task,dp);
           maxi=Math.max(maxi,point);
         } 
       }
      return dp[day][last]=maxi; 
    }
    public int maximumPoints(int points[][],int n){
        int dp[][]=new int[n][4];
       for (int[] row: dp)
       Arrays.fill(row, -1);
     return recurison(points,n-1,3,dp);
    }
}