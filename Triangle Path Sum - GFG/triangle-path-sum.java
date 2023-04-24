//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >triangle) {
       int[][] dp=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        return fun(0,0,triangle,n,dp);
    }
    public static int fun(int i,int j,ArrayList<ArrayList<Integer>> triangle,int n,int[][] dp)
    {
        if(i==n-1) return triangle.get(n-1).get(j);

        if(dp[i][j]!=-1) return dp[i][j];

        int d=triangle.get(i).get(j)+fun(i+1,j,triangle,n,dp);
        int dg=triangle.get(i).get(j)+fun(i+1,j+1,triangle,n,dp);
      return dp[i][j]=Math.min(d,dg);  
    }
}