//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] A, int N) {
        int curr_reach=0;
        for(int i=0;i<A.length;i++)
        {
            if(i>curr_reach)
            {
                return 0;
            }
            curr_reach=Math.max(curr_reach,i+A[i]);
            if(curr_reach>=A.length-1)
            {
                return 1;
            }
        }
    
    return 0;
    }
};