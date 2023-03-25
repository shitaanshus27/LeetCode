//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


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
    public int Solve(int n, int[][] edge) {
        DisjointSet ds=new DisjointSet(n);
        int cntExtras=0;
        int m=edge.length;
        for(int i=0;i<m;i++)
        {
          int u=edge[i][0];
          int v=edge[i][1];
          if(ds.findParent(u)!=ds.findParent(v))
          {
              ds.unionByrank(u,v);
          }
          else
          {
              cntExtras++;
          }
        }
        int cntC=0;
        for(int i=0;i<n;i++)
        {
            if(ds.parent.get(i)==i) cntC++;
        }
        int ans=cntC-1;
        if(cntExtras>=ans) return ans;
    return -1;    
    }
}