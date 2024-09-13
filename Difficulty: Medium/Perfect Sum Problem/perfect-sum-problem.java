//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    public static int operation(int s, int[] arr, int n, int sum, int i, int[][] dp){
    
        if (i >= n) {
            if(s==sum) return 1;
        return 0;
        }
        if (s > sum) return 0;
        if (dp[i][s] != -1) return dp[i][s];
        int p = operation(s + arr[i], arr, n, sum, i + 1, dp);
        int up = operation(s, arr, n, sum, i + 1, dp);
        dp[i][s] = (p + up)%1000000007;
        return dp[i][s];
    }
    public int perfectSum(int arr[], int n, int sum) {
        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        return operation(0, arr, n, sum, 0, dp);
    }
}
