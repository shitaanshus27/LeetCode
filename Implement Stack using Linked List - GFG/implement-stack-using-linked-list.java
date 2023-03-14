//{ Driver Code Starts
import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}

class GfG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}

// } Driver Code Ends


class MyStack 
{
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;
    //Function to push an integer into the stack.
    StackNode curr=null;
    void push(int a) 
    {
        StackNode new_node=new StackNode(a);
        if(top==null)
        {
         top=new_node;
        }
        else
        {
           new_node.next=top;
           top=new_node;
        }
    }
    int pop() 
    {
        if(top==null)
        {
            return -1;
        }
        else
        {
          StackNode cur=top;
          top=top.next;
          return cur.data;
        }
    }
}
