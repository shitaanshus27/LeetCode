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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
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
    class Pair{
        int row;
        int col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public boolean bfs(int row,int col,int[][] grid){
       Queue<Pair> q=new LinkedList<>();
       q.add(new Pair(row,col));
       int delrow[]={1,0,-1,0};
       int delcol[]={0,-1,0,1};
       while(!q.isEmpty()){
        int rw=q.peek().row;
        int co=q.peek().col; 
        q.remove();
       for(int i=0;i<4;i++)
       {
          int nrow=rw+delrow[i];
          int ncol=co+delcol[i];
          if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==3)
          {
              q.add(new Pair(nrow,ncol));
          }
          else if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==2)
          {
              return true;      
          }
       }
      }
     return false; 
    }
    public boolean is_Possible(int[][] grid)
    {
      for(int i=0;i<grid.length;i++)
      {
        for(int j=0;j<grid[0].length;j++)
        {
           if(grid[i][j]==1)
           {
               if(bfs(i,j,grid)==true)
               {
                  return true; 
               }
           }
        }
      }
     return false; 
    }
}