//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
       String new_Str=S.replace("."," ");
       String[] str1=new_Str.split(" ");
       Stack<String> st=new Stack<String>();
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<str1.length;i++)
       {
           st.push(str1[i]);
       }
      while(!st.empty())
      {
         sb.append(st.pop());
         sb.append(".");
      }
      sb.deleteCharAt(sb.length()-1);
      return sb.toString();
    }
}