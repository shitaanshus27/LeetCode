//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int transitionPoint(int arr[], int n) {
       int low=0,upper=arr.length-1,mid=0;;
       while(low<=upper)
       {
           mid=(low+upper)/2;
           
           if(arr[mid]==0)
             low=mid+1;
             
            else if(arr[mid]==1){
                if(mid==0 || (mid>=0 && arr[mid-1]==0))
                {
                    return mid;
                }
           upper=mid-1;         
       }
    }
    return -1;
}
}