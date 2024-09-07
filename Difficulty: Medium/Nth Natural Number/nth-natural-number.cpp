//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    long long findNth(long long n) {
        // code here.
        
        long long num=0;
        string s="";
        while(n>1)
        {
            long long r=(n%9);
            s+=to_string(r);
            n=n/9;
        }
        s+=to_string(n);
        reverse(s.begin(),s.end());
        num=stoll(s);
        
        return num;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        long long n, ans;
        cin >> n;
        Solution obj;
        ans = obj.findNth(n);
        cout << ans << endl;
    }
}

// } Driver Code Ends