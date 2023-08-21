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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
       int count=0;
       for(int i=0;i<matrix.length;i++)
       {
         for(int j=0;j<matrix[0].length;j++)
         {
            if(matrix[i][j]==1 && check(matrix,i,j))
            {
                count++;
            }
         }
       }
     return count;  
    }
    public boolean check(int[][] matrix,int row,int col)
    {
       int delrow[]={0,0,1,-1,1,1,-1,-1};
       int delcol[]={1,-1,0,0,1,-1,1,-1};
       int cnt=0;
       for(int i=0;i<8;i++)
       {
         int nrow=row+delrow[i];
         int ncol=col+delcol[i];
         if(nrow>=0 && nrow<matrix.length && ncol>=0 && ncol<matrix[0].length)
         {
             if(matrix[nrow][ncol]==0)cnt++; 
         }
       }
       if(cnt==0) return false;
      return cnt%2==0 ? true:false;
    }
}