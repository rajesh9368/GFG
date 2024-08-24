//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int solve(int wt[], int val[], int w, int i) {
        if (i == 0) {
            if (wt[0] <= w) {
                return val[0];
            }
            return 0;
        }
        int nottake = solve(wt, val, w, i - 1);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= w) {
            take = val[i] + solve(wt, val, w - wt[i], i - 1);
        }
        return Math.max(nottake, take);
    }
    static int knapSack(int W, int wt[], int val[]) {
        int n = wt.length;
        return solve(wt, val, W, n - 1);
    }
}
