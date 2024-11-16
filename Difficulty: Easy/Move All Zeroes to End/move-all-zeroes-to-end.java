//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
         int n = arr.length;
        int position = 0; // Pointer to place non-zero elements

        // Traverse the array and move non-zero elements to the `position` index
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[position] = arr[i];
                position++;
            }
        }

        // Fill the remaining positions with zeros
        while (position < n) {
            arr[position] = 0;
            position++;
        }
    }
}