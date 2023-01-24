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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        int i=0,size=arr.length;
        
        if(size==0)
          return "";
        
        if(size==1)
          return arr[0];
          
        Arrays.sort(arr);  
        
        int end=Math.min(arr[0].length(),arr[size-1].length());  
        
        while(i<end && arr[0].charAt(i)==arr[size-1].charAt(i))
        {
            i++;
        }
        String pre=arr[0].substring(0,i);
        if(i==0)
        {
            return "-1";
        }
    return pre;    
    }
}