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
		   
		      head = new Solution().mergeSort(head);
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
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        Node list=head;
        Node temp=head;
       int count=0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        
        int[] arr=new int[count];
        int k=0;
        while(list!=null)
        {
            arr[k++]=list.data;
            list=list.next;
        }
        Arrays.sort(arr);

        Node temp_head=null,next_node=null;
        for(int i=0;i<arr.length;i++)
        {
          Node new_node=new Node(arr[i]);
          if(temp_head==null)
          {
              temp_head=new_node;
              next_node=new_node;
              new_node.next=null;
          }
          else
          {
              next_node.next=new_node;
              next_node=new_node;
              new_node.next=null;
          }
    }
    return temp_head;
    }
}


