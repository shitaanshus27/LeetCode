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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int nums[], int M, int amount) 
	{ 
	 // Your code goes here
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