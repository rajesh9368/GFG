//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        int currmax = arr[0],currmin = arr[0];
        int totalsum=arr[0],maxi=arr[0],mini=arr[0];
        for(int i=1;i<arr.length;i++){
            currmax = Math.max(arr[i],currmax+arr[i]);
            maxi=Math.max(maxi,currmax);
            currmin = Math.min(arr[i],currmin+arr[i]);
            mini=Math.min(mini,currmin);
            totalsum+=arr[i];
        }
        if(maxi<0) return maxi;
        return Math.max(maxi,totalsum-mini);
    }
}
