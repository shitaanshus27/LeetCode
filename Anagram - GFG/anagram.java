//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    public static boolean isAnagram(String a,String b)
    {
        int j;
      if(a.length()!=b.length())
      {
          return false;
      }
      int[] arr=new int[26];
      int[] arr1=new int[26];
      for(int i=0;i<a.length();i++)
      {
            char c=a.charAt(i);
            int m=(int)c;
            arr[m-97]+=1;
      }
      for(int i=0;i<b.length();i++)
      {
            char c=b.charAt(i);
            int m=(int)c;
            arr1[m-97]+=1;
      }
      for(j=0;j<arr.length;j++)
      {
           if(arr[j]!=arr1[j])
           {
               return false;
           }
     }
     
 return true;
    }
}