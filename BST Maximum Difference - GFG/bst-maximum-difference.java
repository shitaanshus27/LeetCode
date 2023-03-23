//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static Node fn(Node root,int t)
    {
        if(root==null) return null;
        int val=root.data;
        if(val==t) return root;
        if(t>root.data)  return fn(root.right,t);
        else return fn(root.left,t);
    }
    static int fun2(Node root,int t)
    {
        if(root==null) return 0;
        
        int val=root.data;
        if(val==t)return t;
        
        if(t>val) return val+fun2(root.right,t);
        else
            return val+fun2(root.left,t);
    }
    static int fun3(Node root,int store)
    {
      if(root.left==null && root.right==null)
         return store-root.data;
      int a=Integer.MIN_VALUE;
      int b=Integer.MIN_VALUE;
      
      if(root.left!=null) a=fun3(root.left,store-root.data);
      if(root.right!=null) b=fun3(root.right,store-root.data);
      return Math.max(a,b);
    }
    public static int maxDifferenceBST(Node root,int target)
    {
      Node val=fn(root,target);
      if(val==null) return -1;
      
      int store=fun2(root,target);
      int ans=fun3(val,store);
     return ans; 
    }
}