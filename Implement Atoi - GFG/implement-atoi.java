//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	 int oc=0;

 for(int i=0;i<str.length();i++){

     if(str.charAt(i)=='-' || str.charAt(i)=='+'){

        if(i!=0)return -1;

     }

     else if(str.charAt(i)>='a' && str.charAt(i)<='z'){

         return -1;

     }
 }

    return Integer.valueOf(str);
    }
}
