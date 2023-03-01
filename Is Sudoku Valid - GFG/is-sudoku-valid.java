//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     public static boolean valid(int mat[][],int row,int col,int k)
    {
        for(int i=0;i<mat.length;i++)
        {
            if(mat[row][i]==k && i!=col)
             return false;
            if(mat[i][col]==k && i!=row)
             return false;
            if(mat[3*(row/3)+i/3][3*(col/3)+i%3]== k && (3*(row/3)+i/3)!=row && (3*(row/3)+i%3)!=col)
              return false;
        }
      return true;
    }
    static int isValid(int mat[][]){
      for(int i=0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                int digit = mat[i][j];
                if(digit!=0){
                    if(valid(mat,i,j,digit)==false)return 0;
                }
            }
        }
        return 1;
    }     
}