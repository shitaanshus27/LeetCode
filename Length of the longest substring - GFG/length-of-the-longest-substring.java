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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
        int answer = 0;
        
        Set<Character> set = new HashSet<>();
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            
            while (set.contains(r)) {
                char l = s.charAt(left);
                set.remove(l);
                left++;
            }
            
            set.add(r);
            answer = Math.max(answer, right - left + 1);
        }
        
        return answer;
    }
}