//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// class Solution {
//two approaches 
/*Brute approach and hash map approach*/
//     public long subarrayXor(int arr[], int k) {
//         // code here
//         int n = arr.length;
//         long cnt=0;
//         for(int i=0;i<n;i++){
//             int xor=0;
//             for(int j=i;j<n;j++){
//                 xor=xor^arr[j];
//                 if(xor==k) cnt++;
//             }
//         }
//         return cnt;
//     }
// } tle
class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int XOR = 0;
        int ans = 0;
        for(int i : arr){
            XOR ^= i;
            if(map.containsKey(XOR^k)){
                ans += map.get(XOR^k);
            }
            map.put(XOR, map.getOrDefault(XOR, 0)+1);
        }
        return ans;
    }
}