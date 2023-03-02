//{ Driver Code Starts
//Initial Template for Java

import java.util.*; 
import java.io.*;
import java.lang.*;

class DriverClass
{
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            
            GFG g = new GFG();
            g.rotate(arr);
            printMatrix (arr);
        }
	} 
	
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG
{
    static void rotate(int matrix[][]) 
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i+1;j<matrix[0].length;j++)
            {
               int temp=matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=temp;
              // System.out.println(temp);
            }
        }
        int l=0,h=matrix.length-1;
        while(l<h)
        {
         h=matrix.length-l-1;
         for(int j=0;j<matrix[0].length;j++)
         {
             int temp=matrix[l][j];
             matrix[l][j]=matrix[h][j];
             matrix[h][j]=temp;
         }
         l++;
         h--;
        }
      /* for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
               System.out.print(matrix[i][j]);
            }
            System.out.println();
        } */     
    }
}