//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
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


