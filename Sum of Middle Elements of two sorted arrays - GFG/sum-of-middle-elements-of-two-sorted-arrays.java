//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<ar1.length;i++)
             list.add(ar1[i]);
             
        for(int i=0;i<ar2.length;i++)
             list.add(ar2[i]);
        
         int[] arr3=new int[list.size()];
        
        for(int i=0;i<list.size();i++)
              arr3[i]=list.get(i);
            
            Arrays.sort(arr3);
        
        //for(int i=0;i<arr3.length;i++)
            int mid=arr3.length/2;
            
    return arr3[mid]+arr3[mid-1];    
    }
}