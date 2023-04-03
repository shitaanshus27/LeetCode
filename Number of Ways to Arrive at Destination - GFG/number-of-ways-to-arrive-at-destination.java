//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     static class Pair{
         int first;
         int second;
         Pair(int first,int second)
         {
            this.first=first;
            this.second=second;
         }
     }
    static int countPaths(int n, List<List<Integer>> roads) {
         int mod = (int)1e9+7;

        List<List<Pair>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++){

            adjList.add(new ArrayList<Pair>());

        }

        for(int i=0; i<roads.size(); i++){

            int u = roads.get(i).get(0);

            int v = roads.get(i).get(1);

            int t = roads.get(i).get(2);

            adjList.get(u).add(new Pair(t, v));

            adjList.get(v).add(new Pair(t, u));

        }

        

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        pq.offer(new Pair(0, 0));

        int shortestTime[] = new int[n];

        int numOfWays[] = new int[n];

        Arrays.fill(shortestTime, Integer.MAX_VALUE);

        shortestTime[0] = 0;

        numOfWays[0] = 1;

        while(!pq.isEmpty()){

            Pair curPair = pq.poll();

            int curNode = curPair.second;

            int curTime = curPair.first;

            

            for(Pair adjPair: adjList.get(curNode)){

                int adjNode = adjPair.second;

                int adjNodeTime = adjPair.first;

                if(curTime + adjNodeTime < shortestTime[adjNode]){

                    shortestTime[adjNode] = (curTime + adjNodeTime)%mod;

                    pq.offer(new Pair(shortestTime[adjNode], adjNode));

                    numOfWays[adjNode] = numOfWays[curNode];

                }

                else if(curTime + adjNodeTime == shortestTime[adjNode]){

                    numOfWays[adjNode] = (numOfWays[adjNode] + numOfWays[curNode])%mod;

                }

            }

        }

        return numOfWays[n-1]%mod;

        
    }
}
