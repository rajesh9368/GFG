//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code herez
        List<Integer> arr1 = new ArrayList<>();
        Arrays.sort(arr);
        int currdiff=Integer.MAX_VALUE;
        int l=0,r=arr.length-1;
        while(l<r){
            int currsum=arr[l]+arr[r];
            if(Math.abs(target-currsum)<currdiff){
                ArrayList<Integer> arr2 = new ArrayList<>();
                currdiff=Math.abs(target-currsum);
                arr2.add(arr[l]);
                arr2.add(arr[r]);
                arr1=arr2;
            }
            if(currsum>target) r--;
            else l++; 
            
        }
        return arr1;
    }
}