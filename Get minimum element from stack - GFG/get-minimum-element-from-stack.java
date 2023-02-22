//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    List<Integer> list=new ArrayList<>();
    Queue<Integer> q=new PriorityQueue<>();
    /*returns min element from stack*/
    int getMin()
    {
	   if(q.isEmpty())
	   {
	       return -1;
	   }
	   return q.peek();
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	  if(list.isEmpty())
	  {
	      return -1;
	  }
	  Integer n=list.get(list.size()-1);
	  list.remove(list.size()-1);
	  q.remove(n);
	  return n;
    }

    /*push element x into the stack*/
    void push(int x)
    {
	         list.add(x);
	         q.offer(x);
	  }
}

