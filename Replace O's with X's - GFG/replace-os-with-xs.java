//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        char[][] ans=new char[n][m];
    Queue<Pair> q=new LinkedList<>();
     int vis[][]=new int[n][m];
     
     for(int i=0;i<n;i++)
     {
         for(int j=0;j<m;j++)
         {
             if(i==0 || j==0 || i==n-1|| j==m-1)
              {
                  if(a[i][j]=='O')
                  {
                      q.add(new Pair(i,j));
                      vis[i][j]=1;
                      ans[i][j]='O';
                  }
              }
         }
     }
     int delrow[]={1,0,-1,0};
     int delcol[]={0,-1,0,1};
     while(!q.isEmpty())
     {
         int row=q.peek().first;
         int col=q.peek().second;
         q.remove();
         for(int i=0;i<4;i++)
         {
             int nrow=row+delrow[i];
             int ncol=col+delcol[i];
             if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && a[nrow][ncol]=='O')
             {
                 q.add(new Pair(nrow,ncol));
                 vis[nrow][ncol]=1;
                 ans[nrow][ncol]='O';
                 
             }
         }
     }
     for(int i=0;i<n;i++)
     {
         for(int j=0;j<m;j++)
         {
             if(ans[i][j]!='O')
                 ans[i][j]='X';
         }
     }
     return ans;
    }
}