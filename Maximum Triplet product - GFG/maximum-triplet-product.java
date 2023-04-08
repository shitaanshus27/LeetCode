//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
      long mn1=Integer.MAX_VALUE;
      long mn2=Integer.MAX_VALUE;
      long max1=Integer.MIN_VALUE;
      long max2=Integer.MIN_VALUE;
      long max3=Integer.MIN_VALUE;
      
      for(int i=0;i<n;i++)
      {
          if(arr[i]<mn1){
              mn2=mn1;
              mn1=arr[i];
          }
          else if(arr[i]<mn2){
              mn2=arr[i];
          }
          
          if(arr[i]>max1){
              max3=max2;
              max2=max1;
              max1=arr[i];
          }
          else if(arr[i]>max2){
              max3=max2;
              max2=arr[i];
          }
          else if(arr[i]>max3){
              max3=arr[i];
          }
      }
     return Math.max(mn1*mn2*max1,max1*max2*max3); 
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends