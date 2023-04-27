//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
       int sum=0;
       for(int i=0;i<N;i++) sum+=arr[i];
       if(sum%2!=0) return 0;
      return isSubsetSum(N,arr,sum/2)==true?1:0;
    }
     static Boolean isSubsetSum(int N, int arr[], int sum){ 
        int dp[][]=new int[N+1][sum+1];
        for(int[] x:dp)
        {
          Arrays.fill(x,-1);
        }
        return fun(N-1,sum,arr,dp)==1?true:false; 
    }
    static int fun(int idx,int target,int arr[],int[][] dp)
    {
        if(dp[idx][target]!=-1) return dp[idx][target];
        if(target==0)
        {
            return 1;
        }
        if(idx==0)
        {
            return arr[0]==target?1:0;
        }
        int not_take=fun(idx-1,target,arr,dp);
        int take=0;
        if(target>=arr[idx])
        {
            take=fun(idx-1,target-arr[idx],arr,dp);
        }
     return dp[idx][target]=take|not_take; 
    }
}