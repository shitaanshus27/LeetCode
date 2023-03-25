//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            List<List<String>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<String> l = new ArrayList<>();

                String name = sc.next();
                l.add(name);

                int tmp = sc.nextInt();

                sc.nextLine();
                for (int j = 0; j < tmp; j++) {
                    String h = sc.next();

                    l.add(h);
                }

                adj.add(l);
            }

            Solution obj = new Solution();
            List<List<String>> ans = obj.mergeDetails(adj);
            Collections.sort(ans,
                             (x, y)->{ return x.get(0).compareTo(y.get(0)); });

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    class DisjointSet{
   public List<Integer> rank=new ArrayList<Integer>();
   public List<Integer> parent=new ArrayList<Integer>();
    public DisjointSet(int n){
     for(int i=0;i<=n;i++){   
        rank.add(0);
        parent.add(i);
     }   
    }
    public int findParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findParent(parent.get(node));
        parent.set(node,ulp);
       return parent.get(node); 
    }
    public void unionByrank(int u,int v){
        int ulp_u=findParent(u);
        int ulp_v=findParent(v);

        if(ulp_u==ulp_v) return;

        if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_u,ulp_v);
            int rk =rank.get(ulp_u);
            rank.set(ulp_u,rk+1);
        }
    }
}
    public List<List<String>> mergeDetails(List<List<String>> details) {
        int n=details.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer> mapMailNode=new HashMap<String,Integer>();
        for(int i=0;i<n;i++)
        {
         for(int j=1;j<details.get(i).size();j++)
         {
            String mail=details.get(i).get(j);
            if(mapMailNode.containsKey(mail)==false)
            {
                mapMailNode.put(mail,i);
            }
            else
            {
                ds.unionByrank(i,mapMailNode.get(mail));
            }
         }
       }
       ArrayList<String>[] mergedMail=new ArrayList[n];
       for(int i=0;i<n;i++)
       {
          mergedMail[i]=new ArrayList<String>(); 
       }
       for(Map.Entry<String,Integer> it:mapMailNode.entrySet()){
           String mail=it.getKey();
           int node=ds.findParent(it.getValue());
           mergedMail[node].add(mail);
       }
       List<List<String>> ans=new ArrayList<>();
       for(int i=0;i<n;i++)
       {
          if(mergedMail[i].size()==0) continue;
          
          Collections.sort(mergedMail[i]);
          List<String> temp=new ArrayList<>();
          temp.add(details.get(i).get(0));
          for(String it:mergedMail[i])
          {
             temp.add(it); 
          }
          ans.add(temp);
       }
     return ans;  
    }
}