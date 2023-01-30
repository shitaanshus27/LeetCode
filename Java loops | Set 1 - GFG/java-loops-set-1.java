//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0)
        {
            int N = scn.nextInt();

            Solution ob = new Solution();
            ArrayList<Integer> sum = ob.getSum(N);
            System.out.println(sum.get(0)+" "+sum.get(1));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> getSum(int N){
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        int sum_even=0;
        int sum_odd=0;
    for(int i=0;i<=N;i++)
    {
        if(i%2==0)
          sum_even+=i;
        else
          sum_odd+=i;
    }
    list.add(sum_even);
    list.add(sum_odd);
    return list;
    }
}