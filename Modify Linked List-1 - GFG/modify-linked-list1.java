//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
      Node slow=head;
      Node fast=head;
      Node prev=null;
      while(slow!=null && fast!=null && fast.next!=null)
      {
           prev=slow; 
           slow=slow.next;
           fast=fast.next.next;
      }
      prev.next=null;
      Node first_half=head;
      Node second_half=reverseList(slow);
      Node tem=second_half;
      while(first_half!=null && second_half!=null)
      {
        int temp=first_half.data;
        first_half.data=second_half.data-first_half.data;
        second_half.data=temp;
        
        first_half=first_half.next;
        second_half=second_half.next;
      }
      
      Node second_half_rev=reverseList(tem);
      
      Node adder=head;
      
      while(adder.next!=null)
      {
         adder=adder.next; 
      }
      adder.next=second_half_rev;
     return head;
    }
     public static Node reverseList(Node head) {
        Node temp =head;
        Node curr=null;
        Node prev=null;

       while(temp!=null)
       {
           curr=temp.next;
           temp.next=prev;
           prev=temp;
           temp=curr;
       } 
     return prev;
    }
}