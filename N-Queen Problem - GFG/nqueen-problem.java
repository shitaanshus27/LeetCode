//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        int board[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
         for(int j=0;j<n;j++)
         {
             board[i][j]=0;
         }
        }
         ArrayList<ArrayList<Integer>> ans=new ArrayList<>(); 
         solve(0,board,ans);
       return ans;
    }
     public static void solve(int col,int[][] board,ArrayList<ArrayList<Integer>> ans)
    {
       if(col==board.length)
       {
           ans.add(construct(board));
           return;
       }
       for(int i=0;i<board.length;i++)
       if(isSafe(board,i,col))
       {
           board[i][col]=1;
           solve(col+1,board,ans);
           board[i][col]=0;
       }  
    }
    public static boolean isSafe(int[][] board,int row,int col)
    {
        int d_row=row;
        int d_col=col;
        while(row>=0 && col>=0)
        {
            if(board[row][col]==1)
            {
                return false;
            }
            row--;
            col--;
        }
        row=d_row;
        col=d_col;
        while(col>=0)
        {
            if(board[row][col]==1)
            {
                return false;
            }
          col--;  
        }
        row=d_row;
        col=d_col;
        while(row<board.length && col>=0)
        {
            if(board[row][col]==1)
              return false;
           row++;
           col--;   
        }
        return true;
    }
    public static ArrayList<Integer>construct(int[][] board)
    {
       ArrayList<Integer>res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
        for(int j=0;j < board[0].length;j++) {       
             if(board[j][i]==1)
             {
                 res.add(j+1);
             }
          }
        }
        return res;
    }
}