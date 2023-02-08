//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
      int top=0,left=0,bottom=matrix.length-1,right=matrix[0].length-1;
        ArrayList<Integer> list=new ArrayList<>();
        while(left<=right && top<=bottom)
        {
            for(int i=left;i<=right;i++)
                list.add(matrix[top][i]);
             top++;   
            for(int i=top;i<=bottom;i++)
                list.add(matrix[i][right]);
             right--;   
            
            if(top>bottom || left>right)
                  break;
            
            for(int i=right;i>=left;i--)
               { 
                //if(i==left)
                    //break;
                list.add(matrix[bottom][i]);
               }
              bottom--;
            for(int i=bottom;i>=top;i--)
              {    
                  //if(i==top)
                    //  break;
                  list.add(matrix[i][left]);        
             }
             left++;
        
    }
    return list;  
    }
}
