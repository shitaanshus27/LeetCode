//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static class DisjointSet{
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
	static class Pair{
	    int node;
	    int distance;
	    Pair(int node,int distance)
	    {
	       this.node=node;
	       this.distance=distance;
	    }
	}
	static int spanningTree(int V, int E, int edges[][]){

	    DisjointSet ds=new DisjointSet(V);
	    int wt=0;
	    Arrays.sort(edges,(a,b)->{return a[2]-b[2];});
	    for(int i=0;i<edges.length;i++){
	        int s=edges[i][0];
	        int d=edges[i][1];
	        int c=edges[i][2];
	        if(ds.findParent(s)!=ds.findParent(d))
	        {
	            wt+=c;
	            ds.unionByrank(s,d);
	        }
	    }
	 return wt;   
	}
}