//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
       int[][] dp=new int[price.length+1][n+1];
       for(int[] x:dp)
       {
           Arrays.fill(x,-1);
       }
       return fun(price,n,price.length-1,dp);
    }
    public int fun(int[] price,int n,int idx,int[][] dp)
    {
      if(idx==0)
      {
        return n*price[0];
      }
      if(dp[n][idx]!=-1) return dp[n][idx];
      int notTake=0+fun(price,n,idx-1,dp);
      int take=Integer.MIN_VALUE;
      int rodLength=idx+1;
      if(rodLength<=n)
           take=price[idx]+fun(price,n-rodLength,idx,dp);
      return dp[n][idx]=Math.max(notTake,take);           
    }
}