//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
      int dp[]=new int[arr.length+1];
      Arrays.fill(dp,-1);
      return FindHelp(arr,0,dp);
    }
    public int FindHelp(int arr[],int index,int[] dp)
    {
        if(index==arr.length-1) return arr[index];
        
        if(index>arr.length-1) return 0;
        
        if(dp[index]!=-1) return dp[index];
        
      int a=arr[index]+FindHelp(arr,index+2,dp);
      int b=0+FindHelp(arr,index+1,dp);
      
     return dp[index]=Math.max(a,b); 
    }
}