class Solution {
    static int function(int i,int j,int[] arr,int[][] dp){
        if(i==j) return 0;
        // int mini = 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<j;k++){
            int cost1 = function(i,k,arr,dp);
            int cost2 = function(k+1,j,arr,dp);
            int totalcost = arr[i-1]*arr[j]*arr[k]+cost1+cost2;
            mini = Math.min(mini,totalcost);
        }
        return dp[i][j]=mini;
    }
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        // code here
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return function(1,n-1,arr,dp);
    }
}