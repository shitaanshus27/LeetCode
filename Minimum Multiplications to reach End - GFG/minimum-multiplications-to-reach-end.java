//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     class Pair{

    int first,second;

    Pair(int first,int second){

        this.first=first;

        this.second=second;

    }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
       Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(0,start));

        int dist[]=new int[100000];

        Arrays.fill(dist,(int)Math.pow(10,9));

        while(!q.isEmpty()){

            int steps=q.peek().first;

            int node=q.peek().second;

            q.remove();

            for(int i:arr){

                int val=(node*i)%100000;

                if(val==end){

                    return steps+1;

                }

                if(dist[val]>steps+1){

                    dist[val]=steps+1;

                    q.add(new Pair(steps+1,val));

                }

            }

        }

        return -1;
    }
}
