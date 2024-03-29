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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
     class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col, int time)
        {
            this.row=row;
            this.col=col;
            this.time=time;
        } 
     }
    public int orangesRotting(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        int cntfresh=0;
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<m;j++)
          {
              if(grid[i][j]==2)
              {
                 q.add(new Pair(i,j,0));
                 vis[i][j]=2; 
              }
              else
              {
                  vis[i][j]=0;
              }
            if(grid[i][j]==1) cntfresh++;
          }  
        }
       int tm=0;
       int delrow[]={-1,0,+1,0};
       int delcol[]={0,+1,0,-1};
       int cnt=0;
       while(!q.isEmpty())
       {
           int r=q.peek().row;
           int c=q.peek().col;
           int t=q.peek().time;
           tm=Math.max(tm,t);
           q.remove();
           for(int i=0;i<4;i++)
           {
               int row=r+delrow[i];
               int col=c+delcol[i];
               if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==0 && grid[row][col]==1)
               {
                   q.add(new Pair(row,col,t+1));
                   vis[row][col]=2;
                   cnt++;
               }
           }
       }
    if(cnt!=cntfresh) return -1;
 return tm;        
    }
}