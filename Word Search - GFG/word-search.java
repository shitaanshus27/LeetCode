//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
     public boolean dfs(char[][] board,int row,int col,String word,int k)
    {
      if(row<0 || col<0 || row>=board.length || col>=board[0].length)
      {
          return false;
      }
      if(board[row][col]==word.charAt(k)){ 
      
      char temp=board[row][col];
      
      board[row][col]='#';
      
      if(word.length()-1==k)
      {
         return true; 
      }
      
      else if(dfs(board,row-1,col,word,k+1)||dfs(board,row+1,col,word,k+1)||dfs(board,row,col-1,word,k+1)||dfs(board,row,col+1,word,k+1))
      {
          return true;
      }
      
      board[row][col]=temp;
     }
     return false; 
    }
    public boolean isWordExist(char[][] board, String word)
    {
        boolean result = false;
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(dfs(board,i,j,word,0))
                {
                    result = true;
                }
            }
        }
        return result;       
    }
}