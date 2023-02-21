//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        int max_reach=0,max_sofar=0;
        int step=0;
        if(arr[0]==0)
        {
            return -1;
        }
        for(int i=0;i<arr.length;i++)
        {
            max_reach=Math.max(max_reach,arr[i]+i);
            if(i==max_sofar)
            {
                step++;
             max_sofar=max_reach;
             if(max_sofar>=arr.length-1)
                  break;
            }
            else if(i>max_sofar)
            {
                return -1;
            }
        }
    return step;    
    }
}