//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution{
    public:
    // arr[] : int input array of integers
    // k : the quadruple sum required
    vector<vector<int> > fourSum(vector<int> &a, int k) {
      set<vector<int>> s;
        vector<vector<int>> ans;
        int n = a.size();
        sort(a.begin(), a.end());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int start = j + 1, end = n - 1;
                while (start < end) {
                    int sum = a[i] + a[j] + a[start] + a[end];
                    if (sum == k) {
                        vector<int> quadruple = {a[i], a[j], a[start], a[end]};
                        s.insert(quadruple);
                        start++;
                        end--;
                    } else if (sum > k) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        for (auto x : s) {
            ans.push_back(x);
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k, i;
        cin >> n >> k;
        vector<int> a(n);
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        vector<vector<int> > ans = ob.fourSum(a, k);
        for (auto &v : ans) {
            for (int &u : v) {
                cout << u << " ";
            }
            cout << "$";
        }
        if (ans.empty()) {
            cout << -1;
        }
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends