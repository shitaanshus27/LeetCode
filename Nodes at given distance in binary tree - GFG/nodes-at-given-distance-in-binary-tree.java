//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static Node markParent(Node root,Map<Node,Node> parent_track,int target)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        Node res=null;
        while(!queue.isEmpty())
        {
            Node current=queue.poll();
            
            if(current.data==target)
              res=current;
              
            if(current.left!=null)
            {     
               queue.offer(current.left);
               parent_track.put(current.left,current);
            }
            if(current.right!=null)
            {     
               queue.offer(current.right);
               parent_track.put(current.right,current);
            }
        }
        return res;
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
       Map<Node,Node> parent_track=new HashMap<>();
       Map<Node,Boolean> visited=new HashMap<>();
       Queue<Node> queue=new LinkedList<>();
       Node targetp=markParent(root,parent_track,target);
        queue.offer(targetp);
        visited.put(targetp,true);
        int curr_level=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            if(curr_level==k) break;
            curr_level++;
            for(int i=0;i<size;i++)
            {
                Node current=queue.poll();
                if(current.left!=null && visited.get(current.left)==null)
                {
                    queue.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null)
                {
                    queue.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parent_track.get(current)!=null && visited.get(parent_track.get(current))==null)
                {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current),true);
                }
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        while(!queue.isEmpty())
        {
            Node curr=queue.poll();
            list.add(curr.data);
        }
        Collections.sort(list);
    return list;        
    }
};