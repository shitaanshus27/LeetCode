//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String S = br.readLine().trim();
            String[] S1 = S.split(" ");
            int n = Integer.parseInt(S1[0]);
            int amount  = Integer.parseInt(S1[1]);
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.MinCoin(nums, amount);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinCoin(int[] nums, int amount)
    {
      int dp[][]=new int[nums.length][amount+1];
      for(int[] x:dp)
      {
          Arrays.fill(x,-1);
      }
      int ans=fun(nums,amount,nums.length-1,dp);
      return ans>=(int)1e9?-1:ans;
    }
    public int fun(int[] nums,int amount,int idx,int[][] dp)
    {
      if(idx==0)
      {
        return amount%nums[0]==0?amount/nums[0]:(int)1e9;
      }
      if(dp[idx][amount]!=-1) return dp[idx][amount];
      int notTake=0+fun(nums,amount,idx-1,dp);
      int Take=(int)1e9;
      if(nums[idx]<=amount)
           Take=1+fun(nums,amount-nums[idx],idx,dp);
      return dp[idx][amount]=Math.min(notTake,Take);           
    }
}