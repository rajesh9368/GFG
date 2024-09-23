//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int n = arr.length;
        int maxi1=-1,maxi2=-1;
        for(int i=0;i<n;i++){
            if(arr[i]>maxi1) maxi1=arr[i];
        }
        for(int i=0;i<n;i++){
            if(arr[i]<maxi1 && maxi2<arr[i]) maxi2=arr[i];
        }
        return maxi2;
    }
}