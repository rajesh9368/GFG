//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
  bool kmp(string s,string s1){
      int m=s.size();
      int n=s1.size();
      vector<int>lps(n,0);
      int i=1;
      int j=0;
      while(i<n){
          if(s1[i]==s1[j]){
              lps[i]=j+1;
              j++;
              i++;
          }
          else{
              if(j==0){
                  lps[i]=0;
                  i++;
              }
              else{
                  j=lps[j-1];
              }
          }
      }
       i=0;
       j=0;
      while(i<m && j<n){
          if(s[i]==s1[j]){
              i++;
              j++;
          }
          if(j==n){
              return true;
          }
          else if(i<m && s[i]!=s1[j]){
              if(j==0){
                  i++;
              }
              else{
                  j=lps[j-1];
              }
          }
      }
      return false;
  }
    int minRepeats(string& s1, string& s2) {
        int cnt=0;
        string s="";
        while(s.size()<s2.size()){
            cnt++;
            s+=s1;
        }
        if(kmp(s,s2)==true){
            return cnt;
        }
        if(kmp(s+s1,s2)==true){
            return cnt+1;
        }
        return -1;
        
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {
        string A, B;
        getline(cin, A);
        getline(cin, B);

        Solution ob;
        cout << ob.minRepeats(A, B) << endl;
    }
    return 0;
}
// } Driver Code Ends