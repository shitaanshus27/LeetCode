//{ Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        TreeMap<Integer,Integer> mp=new TreeMap<>();
       TopView(root,mp);
       
       ArrayList<Integer> l=new ArrayList<>(mp.values());
        return l;
    }
     public static void TopView(Node root,TreeMap<Integer,Integer> mp)
    {
        Queue<Pair> q=new LinkedList<>();
        //List<Integer> list=new ArrayList<>();
          q.add(new Pair(0,root));
          //list.add(level);
          while(!q.isEmpty())
          {
              for(int i=0;i<q.size();i++)
              {
                 Pair curr=q.poll();
                 if(mp.containsKey(curr.hd))
                       mp.put(curr.hd,curr.node.data);
                 else
                        mp.put(curr.hd,curr.node.data);
                  if(curr.node.left!=null)
                    { 
                      q.add(new Pair(curr.hd-1,curr.node.left));
                      //list.add(level-1);
                    }   
                        
                  if(curr.node.right!=null)
                    {
                      q.add(new Pair(curr.hd+1,curr.node.right));
                      //list.add(level+1);
                    }        
              }
          }
       //TopView(level-1,root.left);
       
       //TopView(level+1,root.right);
    }
   public static class Pair{
       int hd;
       Node node;
        Pair(int hd,Node node)
        {
            this.hd=hd;
            this.node=node;
        }
   }
}