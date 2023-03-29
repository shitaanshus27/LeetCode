//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int K;
            K = sc.nextInt();

            int N;
            N = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.combinationSum(K, N);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            for (int i = 0; i < ans.size(); i++) {
                ArrayList<Integer> cur = ans.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    System.out.print(cur.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int num[]={1,2,3,4,5,6,7,8,9};
        combination(ans,0,num,K,new ArrayList<>(),N);
        return ans;
    }
    public static void combination(ArrayList<ArrayList<Integer>> ans,int idx,int[] num,int K,ArrayList<Integer> list,int N){
        if(list.size()==K){
            if(N==0){
                ans.add(new ArrayList<>(list));
                return;
            }
          return;    
        }
        for(int i=idx;i<num.length;i++)
        {
            if(N<num[i]) break;
            list.add(num[i]);
            combination(ans,i+1,num,K,list,N-num[i]);
            list.remove(list.size()-1);
        }
    }
}