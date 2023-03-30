//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Pair{
        int row;
        int col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    void booleanMatrix(int matrix[][])
    {
       Queue<Pair> q=new LinkedList<>();
       for(int i=0;i<matrix.length;i++)
       {
        for(int j=0;j<matrix[0].length;j++)
        {
            if(matrix[i][j]==1)
            {
                q.add(new Pair(i,j));
            }
        }
       }
      while(!q.isEmpty())
      {
          int row=q.peek().row;
          int col=q.peek().col;
          q.remove();
          for(int i=0;i<matrix[0].length;i++) matrix[row][i]=1;
          for(int i=0;i<matrix.length;i++) matrix[i][col]=1;
      }
    }
}