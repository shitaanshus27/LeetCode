//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

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

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

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

*/

class Solution
{
    public static void reverse(int[] arr,int i,int j)
    {
        while(i<=j)
        {
          int temp=arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
          i++;
          j--;
        }
    }
    public static Node reverse(Node node, int k)
    {
       Node temp=node;
       int count=0;
       while(temp!=null)
       {
           count++;
           temp=temp.next;
       }
       int[] arr=new int[count];
       Node temp1=node;
       int j=0;
       while(temp1!=null)
       {
           arr[j++]=temp1.data;
           temp1=temp1.next;
       }
       int i;
       for(i=0;i<arr.length;i=i+k)
       {
          if((i+k-1)<arr.length)reverse(arr,i,i+k-1);  
       }
       if(i>arr.length) reverse(arr,i-k,arr.length-1);
       
       Node head=null;
       Node curr=null;
      
      for(int m=0;m<arr.length;m++)
       {
          if(head==null)
          {
              Node tem=new Node(arr[m]);
              head=tem;
              curr=head;
          }
          else
          {
             Node tem=new Node(arr[m]);
             curr.next=tem;
             curr=tem;
          }
       }
    return head;  
    }
}

