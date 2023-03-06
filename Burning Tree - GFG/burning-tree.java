//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    public static Node markParent(Node root,Map<Node,Node> parent_track,int target)
    {
        Node targetp=null;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            Node current=queue.poll();
            
              if(current.data==target)
                  targetp=current;
                  
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
      return targetp;    
    }
    
    public static int minTime(Node root, int target) 
    {
        Map<Node,Node> parent_track=new HashMap<>();
        Node targetp=markParent(root,parent_track,target);
        Map<Node,Boolean> visited=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        queue.offer(targetp);
        visited.put(targetp,true);
        int count=0;
        //count++;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            boolean flag=false;
            for(int i=0;i<size;i++)
            {
                Node current=queue.poll();
                if(current.left!=null && visited.get(current.left)==null)
                {
                    queue.offer(current.left);
                    visited.put(current.left,true);
                    flag=true;
                }
                if(current.right!=null && visited.get(current.right)==null)
                {
                    queue.offer(current.right);
                    visited.put(current.right,true);
                     flag=true;
                }
                if(parent_track.get(current)!=null && visited.get(parent_track.get(current))==null)
                {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current),true);
                     flag=true;
                }
            }
            if(flag==true)
                      count++;    
        }
    return count;        
    }
}