//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        // code here
        int n = arr.length;
        int maxi=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> st = new HashSet<>();
            for(int j=i;j<n;j++){
                if(!st.contains(arr[j])) st.add(arr[j]);
                if(st.size()<=2) maxi=Math.max(maxi,j-i+1);
                else break;
            }
        }
        return maxi;
    }
}