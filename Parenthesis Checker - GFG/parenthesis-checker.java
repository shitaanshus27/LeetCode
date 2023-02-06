//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends

class Solution
{
       
    static boolean ispar(String s)
    {
     Stack<Character> st=new Stack<>();
     int k=s.length();
     for(int i=0;i<k;i++)
     {
      if(st.empty())
               st.push(s.charAt(i));
            else if((st.peek()=='('&& s.charAt(i)==')')||(st.peek()=='{' && s.charAt(i)=='}')||(st.peek()=='['&&s.charAt(i)==']'))
            {
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
     }
    if(st.empty() && s.length()!=0)
          return true;
      else
          return false; 
  }
}
