//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
      int in_start=0,in_end=in.length-1;
      int post_start=0,post_end=post.length-1;
      HashMap<Integer,Integer> hm=new HashMap<>();
      for(int i=0;i<in.length;i++)
      {
         hm.put(in[i],i);
      }
      Node root=buildTree(in,in_start,in_end,post,post_start,post_end,hm);
     return root; 
    }
    Node buildTree(int[] in,int in_start,int in_end,int[] post,int post_start,int post_end,HashMap<Integer,Integer> hm)
    {
        if(in_start>in_end || post_start>post_end)
          return null;
        
        Node root=new Node(post[post_end]);
        
        int in_root=hm.get(post[post_end]);
        int numsLeft=in_root-in_start;
        root.left=buildTree(in,in_start,in_root-1,post,post_start,post_start+numsLeft-1,hm);
        root.right=buildTree(in,in_root+1,in_end,post,post_start+numsLeft,post_end-1,hm);
    return root;    
    }
}
