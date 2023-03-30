//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        ArrayList<String> ans=new ArrayList<String>();
        HashMap<Integer,String> hm=new HashMap<>();
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");
        
        backtrack(a,0,hm,new StringBuilder(),ans);
        return ans;
    }
    private static void backtrack(int a[],int i,HashMap<Integer,String> hm,StringBuilder sb,ArrayList<String> ans){
        if(sb.length()==a.length)
        {
          ans.add(sb.toString());
          return;
        }
        String str=hm.get(a[i]);
        for(int j=0;j<str.length();j++)
        {
          sb.append(str.charAt(j));
          backtrack(a,i+1,hm,sb,ans);
          sb.deleteCharAt(sb.length()-1);
        }
    }
}


