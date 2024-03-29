//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        StringBuilder res=new StringBuilder();
        if(S==0 && N!=1) return "-1";
        if(S==0) return "0";
        
        int count=0;
        for(int i=0;i<N;i++){
            
            for(int d=9;d>=0;d--){
                if(d<=S){
                    res.append(d);
                    S=S-d;
                    break;
                }
            }
        }
        if(S!=0) return "-1";
        return res.toString();  
    }
}