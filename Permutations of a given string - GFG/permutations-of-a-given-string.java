//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
         List<String> ans=new ArrayList<>();
         char[] ch=S.toCharArray();
         Arrays.sort(ch);
         boolean[] freq=new boolean[S.length()];
          permutation(ch,new StringBuilder(""),freq,ans);
        return ans;
    }
    public void permutation(char[] ch,StringBuilder ds,boolean[] freq,List<String> ans)
    {
       if(ds.length()==ch.length)
       {
          if(!ans.contains(ds.toString())) 
              ans.add(ds.toString());
           //ans.add(" ");
           return ;
       }
       for(int i=0;i<ch.length;i++)
       {
           if(!freq[i])
           {
               freq[i]=true;
               ds.append(ch[i]);
               permutation(ch,ds,freq,ans);
               ds.deleteCharAt(ds.length()-1);
               freq[i]=false;
           }
       }
    }
}