//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}
// } Driver Code Ends


//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node insertionSort(Node head)
    {
          Node temp=head;
        Node nhead=null;
        Node curr=null;
        while(temp!=null)
        {
            Node new_node=new Node(temp.data);
            if(nhead==null)
               {
                nhead=new_node;
                curr=new_node;
                }
            else
                {
                    if(temp.data<curr.data)
                    {
                     if(temp.data<=nhead.data)
                     {
                       new_node.next=nhead;
                       nhead=new_node;
                     }
                     else
                     {
                        Node tmp=nhead;
                        Node c=null;
                        while(temp.data>=tmp.data)
                        {
                            c=tmp;
                            tmp=tmp.next;
                        }
                        new_node.next=tmp;
                        c.next=new_node;
                        
                     }
                    }
                   else
                    {
                     curr.next=new_node;
                     curr=new_node;
                   }
                }   
            
            temp=temp.next;
        }
        return nhead;
    }
}