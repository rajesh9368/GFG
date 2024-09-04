//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // public int operation(int n){
    //      if (n == 0) return 1; 
    //     if (n == 1) return 1; 
    //     int one = operation(n - 1);
    //     int two = operation(n - 2);
    //     return one + two;
    // }
    public int nthStair(int n) {
        // Code here
        // return operation(n);
        return n/2+1;
    }
}