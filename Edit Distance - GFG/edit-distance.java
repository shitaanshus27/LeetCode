//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
      int dp[][]=new int[s.length()+1][t.length()+1];
        
        for(int[] x:dp)
        {
            Arrays.fill(x,-1);
        }
        return fun(s,t,s.length(),t.length(),dp);
    }
     public int fun(String s1,String s2,int i,int j,int[][] dp)
    {
        if(i==0 && j==0) return 0;

        if(j==0) return i;
        
        if(i==0) return j;
        
        if(dp[i][j]!=-1) return dp[i][j];

        char ch1=s1.charAt(i-1);
        char ch2=s2.charAt(j-1);

        if(ch1==ch2)
        {
            return dp[i][j]=fun(s1,s2,i-1,j-1,dp);
        }
        else
        {
            int add=fun(s1,s2,i,j-1,dp);
            int remove=fun(s1,s2,i-1,j,dp);
            int replace=fun(s1,s2,i-1,j-1,dp);
           return dp[i][j]=Math.min(add,Math.min(remove,replace))+1; 
        }
    }
}