// User function Template for Java
class Solution {
    int operation(int n,int[] height,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int l = operation(n-1,height,dp) + Math.abs(height[n]-height[n-1]);
        int r =Integer.MAX_VALUE;
        if(n>1) r=operation(n-2,height,dp) + Math.abs(height[n]-height[n-2]);
        return dp[n] = Math.min(l,r);
    }
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return operation(n-1,height,dp);
    }
}