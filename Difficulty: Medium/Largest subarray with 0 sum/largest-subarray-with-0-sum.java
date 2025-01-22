//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            // Read input array as a string, split by space, and convert to integers
            String[] str = br.readLine().trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Print the result from maxLen function
            System.out.println(new Solution().maxLen(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    //two approaches
    /*Using brute
    other using map*/
    int maxLen(int arr[]) {
        // code here
        int maxi=0;
        int n = arr.length;
        int sum=0;
        // for(int i=0;i<n;i++){
        //     int csum=0;
        //     for(int j=i;j<n;j++){
        //         csum+=arr[j];
        //         if(csum==0) maxi=Math.max(maxi,j-i+1);
        //     }
        // }
        // return maxi;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(mp.containsKey(sum)) maxi=Math.max(maxi,i-mp.get(sum));
            else mp.put(sum,i);
        }
        return maxi;
    }
}