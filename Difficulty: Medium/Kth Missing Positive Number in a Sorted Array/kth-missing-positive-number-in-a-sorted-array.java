//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kthMissing(int[] arr, int k) {
        int missingCount = 0;
        int current = 1; // Start checking from 1
        int index = 0;

        while (true) {
            // Check if the current number is missing
            if (index < arr.length && arr[index] == current) {
                // Number is in the array; move to the next array element
                index++;
            } else {
                // Number is missing
                missingCount++;
                if (missingCount == k) {
                    return current; // Found the k-th missing number
                }
            }
            current++; // Move to the next number
        }
    }
}