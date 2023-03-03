//{ Driver Code Starts
import java.util.*;
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

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
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
    
}*/
// you have to complete this function
class GfG
{
    public static Node quickSort(Node head)
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